package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
@WebServlet(urlPatterns = {"/addProduct"})
public class addProduct extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tenSach = req.getParameter("tenSach");
		String anh = req.getParameter("anh");
		int price = Integer.parseInt(req.getParameter("price"));
		int soLuong =Integer.parseInt(req.getParameter("soLuong"));
		String moTa = req.getParameter("moTa");
		dao Dao = new dao();
		Dao.addProduct(tenSach, anh, price, soLuong, moTa);
		resp.sendRedirect("AdminProduct");
	}
}
