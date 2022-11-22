package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
import entity.Product;

@WebServlet(urlPatterns = {"/AdminEditProduct"})
public class AdminEditProduct extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		dao Dao = new dao();
		Product p = Dao.getProductbyID(id);
		request.setAttribute("detail", p);
		request.getRequestDispatcher("adminpage/edit.jsp").forward(request, response);
	}
}
