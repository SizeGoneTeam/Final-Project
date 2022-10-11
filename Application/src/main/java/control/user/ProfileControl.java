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

@WebServlet("/user/profile")
public class ProfileControl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		dao DAO = new dao();
//		DAO.changeUserName(session.getAttribute("acc.user"), getServletInfo());
		Account acc = (Account) session.getAttribute("acc");
		DAO.changeUserName(acc.getMaTK(), (String) request.getParameter("userName"));
		acc.setHoTen((String) request.getParameter("userName"));
		session.setAttribute("acc", acc);
		response.sendRedirect("profile.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}