package control.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao;
import entity.Account;

@WebServlet("/user/password")
public class PasswordControl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		dao DAO = new dao();
		Account acc = (Account) session.getAttribute("acc");
		
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String newPasswordRepeat = request.getParameter("newPasswordRepeat");
		String message;
		
		if (oldPassword.equals(acc.getPass()) && newPassword.equals(newPasswordRepeat)) {
			DAO.changePassword(acc.getId(), newPassword, oldPassword);
			
			acc.setPass(newPassword);
			session.setAttribute("acc", acc);
			message = "Đổi mật khẩu thành công";
		}
		else {
			message = "Sai mật khẩu";
		}
		
		
		
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/user/password.jsp").forward(request, response);	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}