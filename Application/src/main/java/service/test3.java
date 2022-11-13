package service;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.uuid.Generators;
import com.google.gson.Gson;

import entity.GioHangPK;
import entity.TbAccount;
import entity.TbGioHang;
import entity.TbSach;
import model.BookDao;
import model.GioHangDao;
import model.UserDao;
import utils.CloudinaryUtil;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import java.util.UUID;
public class test3 {
    public static void main(String[] args) throws IOException, AuthenticationException {
        
        
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
        httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));
        CloseableHttpResponse httpResponse = client.execute(httpPost);
        
        // lấy dữ liệu
        String content = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
        Gson gson = new Gson();
        PayPalToken api = new PayPalToken();
        api = gson.fromJson(content, PayPalToken.class);
        
        
        //General Payout
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost1 = new HttpPost("https://api-m.sandbox.paypal.com/v1/payments/payouts");
        UUID uuid = Generators.timeBasedGenerator().generate();
        String id = uuid.toString();
        System.out.println("---" + id);
        double value = 10.0;
        String receiver="ec2-buyer-1@gmail.com";
        
        String JSON_STRING="{\r\n"
                + "  \"sender_batch_header\": {\r\n"
                + "    \"sender_batch_id\": \"" +id+"\",\r\n"
                + "    \"email_subject\": \"You have a payout!\",\r\n"
                + "    \"email_message\": \"You have received a payout! Thanks for using our service!\"\r\n"
                + "  },\r\n"
                + "  \"items\": [\r\n"
                + "    {\r\n"
                + "      \"recipient_type\": \"EMAIL\",\r\n"
                + "      \"amount\": {\r\n"
                + "        \"value\": \""+value+"\",\r\n"
                + "        \"currency\": \"USD\"\r\n"
                + "      },\r\n"
                + "      \"note\": \"successful withdrawal\",\r\n"
                + "      \"receiver\": \""+receiver+"\"\r\n"
                + "    }\r\n"
                + "  ]\r\n"
                + "}";
        
        
          HttpEntity stringEntity = new
          StringEntity(JSON_STRING,ContentType.APPLICATION_JSON);
          httpPost1.setEntity(stringEntity);
          httpPost1.setHeader(HttpHeaders.CONTENT_TYPE,"application/json");
          httpPost1.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " +
          api.getAccess_token());
          CloseableHttpResponse response2 = httpclient.execute(httpPost1);

          String content2 = IOUtils.toString(response2.getEntity().getContent(),
          "UTF-8");
         
        Payout payout = new Payout();
        payout = gson.fromJson(content2, Payout.class);
        try {
                if(payout.getBatch_header().getPayout_batch_id() != null) System.out.println("Rút tiền thành công");
            }
         catch (Exception e) {
                System.out.println("RÚt không thành công . Quý khách vui lòng thử lại sau");
            }
        }        
          
}