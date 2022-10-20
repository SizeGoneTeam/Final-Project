package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
import entity.Account;
import entity.TbAccount;
import model.UserDao;

@WebServlet(urlPatterns = { "/Register" })
public class RegisterControl extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		String re_password = req.getParameter("re_pass");
		Long matk = new Long(3);
		UserDao dao = new UserDao();
		//try {
	        if (dao.findByName(username) == null) {
	            if (password.equals(re_password)) {
	                TbAccount a = new TbAccount();
	                a.setUName(username);
	                a.setPWord(re_password);
	                dao.insert(a);
	                req.setAttribute("mess", "Đăng ký thành công");
	            } else {
	                req.setAttribute("mess", "Mật khấu nhập lại không chính xác");
	            }

	        } else {
	            req.setAttribute("mess", "Tên Tài khoản đã tồn tại");
	        }

	        req.getRequestDispatcher("Login.jsp").forward(req, resp);
	    }//
        /*
         * catch (Exception e) {
         * 
         * }
         */
		
    //}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}