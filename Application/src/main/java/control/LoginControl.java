package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			HttpSession session = req.getSession();
			session.setAttribute("acc", a);
			session.setMaxInactiveInterval(600);
			

			req.getServletContext().getRequestDispatcher("/loadSach").forward(req, resp);
			//getServletContext().getRequestDispatcher("/loadSach");

		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
