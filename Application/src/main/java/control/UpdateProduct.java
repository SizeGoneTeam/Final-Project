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
@WebServlet(urlPatterns = {"/updateProduct"})
public class UpdateProduct extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String maSach = req.getParameter("maSach");
		String tenSach = req.getParameter("tenSach");
		String anh = req.getParameter("anh");
		int price = Integer.parseInt(req.getParameter("price"));
		int soLuong =Integer.parseInt(req.getParameter("soLuong"));
		String moTa = req.getParameter("moTa");
		System.out.println(maSach);
		dao Dao = new dao();
		Dao.updateProduct(maSach, tenSach, anh, price, soLuong, moTa);
		Product p = Dao.getProductbyID(maSach);
		req.setAttribute("detail", p);
		List<TacGia> list = Dao.getALLTacGia();
		req.setAttribute("listTG", list);
		req.getRequestDispatcher("addTGForProduct").forward(req, resp);
	}
}
