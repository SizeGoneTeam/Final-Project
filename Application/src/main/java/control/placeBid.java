package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
import entity.Product;
@WebServlet(urlPatterns = {"/placeBid"})
public class placeBid extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dao Dao = new dao();
		int price = Integer.parseInt(req.getParameter("new_price"));
		String maSach = req.getParameter("maSach");
		String maKH = req.getParameter("id");
		Dao.bidProduct(maSach, price);
		Dao.addBidHistory(maKH, maSach, price);
		resp.sendRedirect("detail?pid="+maSach);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
