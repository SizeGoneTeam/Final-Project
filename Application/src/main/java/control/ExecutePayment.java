package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
import com.paypal.api.payments.*;
import com.paypal.base.rest.PayPalRESTException;

import entity.TbAccount;
import entity.TbGiaoDich;
import model.GiaodichDao;
import model.UserDao;
import service.PaymentServices;
 
@WebServlet("/execute_payment")
public class ExecutePayment extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public ExecutePayment() {
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");
 
        try {
            HttpSession session = request.getSession();
            TbAccount acc = (TbAccount) session.getAttribute("acc");
            UserDao dao = new UserDao();
            acc = dao.findByName(acc.getUName());
            double oldTien = acc.getTien();
            
            
            PaymentServices paymentServices = new PaymentServices();
            Payment payment = paymentServices.executePayment(paymentId, payerId);
             
            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);
            
            acc.setTien(oldTien+ Double.parseDouble(transaction.getAmount().getTotal()));
            TbGiaoDich giaoDich = new TbGiaoDich(1, 1, acc.getMaTK().intValue(), Double.parseDouble(transaction.getAmount().getTotal()));
            GiaodichDao giaodichDao = new GiaodichDao();
            giaodichDao.insert(giaoDich);
            dao.update(acc);
            
            session.setAttribute("acc", acc);
            request.setAttribute("payer", payerInfo);
            request.setAttribute("transaction", transaction);          
 
            request.getRequestDispatcher("LichsugiaodichControl").forward(request, response);
             
        } catch (PayPalRESTException ex) {
            request.getRequestDispatcher("ErrorPatment.html").forward(request, response);
        }
    }
 
}
