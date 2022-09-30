package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
import entity.Product;

@WebServlet(urlPatterns = {"/AdminProduct"})
public class AdminProductControl extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dao Dao = new dao();
		List<Product> list = Dao.getALLProduct();
		req.setAttribute("listP", list);
		req.getRequestDispatcher("adminpage/product.jsp").forward(req, resp);
	}
}
