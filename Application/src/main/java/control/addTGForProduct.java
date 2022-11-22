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
import entity.TacGia;
@WebServlet(urlPatterns = {"/addTGForProduct"})
public class addTGForProduct extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String maSach = req.getParameter("MaSach");
		dao Dao = new dao();
		List<TacGia> list = Dao.getALLTacGia();
		req.setAttribute("listTG", list);
		req.getRequestDispatcher("adminpage/addTacGiaForProduct.jsp").forward(req, resp);
	}
}
