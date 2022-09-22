package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;

@WebServlet(urlPatterns = {"/deleteProduct"})
public class DeleteProduct extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("MaSach");
	dao Dao = new dao();
	Dao.deleteProduct(id);
	resp.sendRedirect("AdminProduct");
}
}
