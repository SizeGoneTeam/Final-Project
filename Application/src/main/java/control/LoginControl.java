package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.AccountDB;
import entity.TbAccount;
import model.UserDao;
import utils.CookieUtil;

@WebServlet(urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    HttpSession session = req.getSession();
		Cookie[] cookies = req.getCookies();
		String accountID = CookieUtil.getCookieValue(cookies, "accountID");
		
		if (accountID.equals("")) {
		    String username = req.getParameter("user");
	        String password = req.getParameter("pass");
	        UserDao dao = new UserDao();
	        TbAccount a = dao.login(username, password);
	        
	        if (a == null) {
	            req.setAttribute("mess", "Bạn đã nhập sai tài khoản hoặc mật khẩu");
	            req.getRequestDispatcher("Login.jsp").forward(req, resp);
	        }
	        else {
	            
	            session.setAttribute("acc", a);
	            session.setMaxInactiveInterval(60*30);
	            
	            String rememberMe = req.getParameter("rememberMe");
	            if (rememberMe.equals("on")) {
	                Cookie c = new Cookie("accountID", a.getMaTK().toString());
	                //Cookie 1 ngay
	                c.setMaxAge(60*60*24);
	                c.setPath("/");
	                resp.addCookie(c);
	            }
	            
	            req.getServletContext().getRequestDispatcher("/loadSach").forward(req, resp);
	        }
		}
		else
		{
		    session.setAttribute("acc", AccountDB.selectAccount(accountID));
		    req.getServletContext().getRequestDispatcher("/loadSach").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
