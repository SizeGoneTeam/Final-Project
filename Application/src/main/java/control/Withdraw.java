package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.uuid.Generators;
import com.google.gson.Gson;

import entity.TbAccount;
import entity.TbGiaoDich;
import entity.TbGioHang;
import model.GiaodichDao;
import model.GioHangDao;
import model.UserDao;
import service.PayPalToken;
import service.Payout;

/**
 * Servlet implementation class Payout
 */
@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        UserDao daoUser = new UserDao();
        HttpSession session = request.getSession();
        TbAccount account = (TbAccount) session.getAttribute("acc");
        System.out.println(account.getMaTK());
        UUID uuid = Generators.timeBasedGenerator().generate();
        String id = uuid.toString();
        double value = Double.valueOf(request.getParameter("total"));
        String receiver = request.getParameter("email");
        if (account.getTien() - value >= 0) {
            // General Token

            String token = "";
            String uname = "AacQ0Q5c7wRMX2tCwE8AVLPaOQ0rwaQRZhDoXtb78HD17Jba9BoDUNGgKWoFgmgvoTQ6ERQMhdYtwWuh";
            String pass = "EOEgqN1jb4xHBJsVzL6fjYSaeMPsT_uKeRb61LibzsWfQIRN4Km_aMDZrfRw8NGgr6V7Y3jU0VNa0lbO";
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("https://api-m.sandbox.paypal.com/v1/oauth2/token");
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("grant_type", "client_credentials"));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            UsernamePasswordCredentials creds = new UsernamePasswordCredentials(uname, pass);
            try {
                httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));
            } catch (AuthenticationException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            CloseableHttpResponse httpResponse = client.execute(httpPost);

            // lấy dữ liệu
            String content = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
            Gson gson = new Gson();
            PayPalToken api = new PayPalToken();
            api = gson.fromJson(content, PayPalToken.class);

            // General Payout
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost1 = new HttpPost("https://api-m.sandbox.paypal.com/v1/payments/payouts");

            String JSON_STRING = "{\r\n"
                    + "  \"sender_batch_header\": {\r\n"
                    + "    \"sender_batch_id\": \"" + id + "\",\r\n"
                    + "    \"email_subject\": \"You have a payout!\",\r\n"
                    + "    \"email_message\": \"You have received a payout! Thanks for using our service!\"\r\n"
                    + "  },\r\n"
                    + "  \"items\": [\r\n"
                    + "    {\r\n"
                    + "      \"recipient_type\": \"EMAIL\",\r\n"
                    + "      \"amount\": {\r\n"
                    + "        \"value\": \"" + value + "\",\r\n"
                    + "        \"currency\": \"USD\"\r\n"
                    + "      },\r\n"
                    + "      \"note\": \"successful withdrawal\",\r\n"
                    + "      \"receiver\": \"" + receiver + "\"\r\n"
                    + "    }\r\n"
                    + "  ]\r\n"
                    + "}";

            HttpEntity stringEntity = new StringEntity(JSON_STRING, ContentType.APPLICATION_JSON);
            httpPost1.setEntity(stringEntity);
            httpPost1.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            httpPost1.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " +
                    api.getAccess_token());
            CloseableHttpResponse response2 = httpclient.execute(httpPost1);

            String content2 = IOUtils.toString(response2.getEntity().getContent(),
                    "UTF-8");

            Payout payout = new Payout();
            payout = gson.fromJson(content2, Payout.class);
            try {
                if (payout.getBatch_header().getPayout_batch_id() != null)
                    System.out.println("Rút tiền thành công");
                account.setTien(Math.floor((account.getTien() - value) * 100) / 100);
                TbGiaoDich giaoDich = new TbGiaoDich(3, account.getMaTK().intValue(), 1, value);
                GiaodichDao giaodichDao = new GiaodichDao();
                giaodichDao.insert(giaoDich);
                UserDao.updateAccount(account);
                session.setAttribute("acc", account);
                url = "LichsugiaodichControl";
            } catch (Exception e) {
                System.out.println("Rút không thành công . Quý khách vui lòng thử lại sau");
                url = "ErrorPayment.jsp";
            }

        } else {
            url = "ErrorPayment.jsp";
            request.setAttribute("mess", "Số dư tài khoản không đủ để rút");
        }
        request.removeAttribute("total");
        request.getRequestDispatcher(url).forward(request, response);
    }    
    


}
