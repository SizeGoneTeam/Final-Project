package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
import entity.Account;

@WebServlet(urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		dao Dao = new dao();
		Account a = Dao.login(username, password);
		if(a==null) {
			req.setAttribute("mess", "Bạn đã nhập sai tài khoản hoặc mật khẩu");
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
