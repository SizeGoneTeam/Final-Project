package control;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao;
import entity.Account;
import entity.Product;

@WebServlet(urlPatterns = {"/loadSach"})
public class HomeControl extends HttpServlet{

	private static final long serialVersionUID = 1967259404927028254L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		dao Dao = new dao();
		List<Product> list = Dao.getALLProduct();
		List<Product> listLast = Dao.getLatestProduct();
		List<Product> listNew = Dao.getTopNew();
		List<Product> listBid = Dao.getTopBid();
		
		HttpSession session=req.getSession();
		Account account;
		account= (Account) session.getAttribute("acc");
		if(account != null) {
			String maKH = String.valueOf(account.getId());
			List<Product> lastSeen = Dao.getTopLast(maKH);
			req.setAttribute("lastSeen", lastSeen);
		}

		req.setAttribute("listP", list);
		req.setAttribute("listLast", listLast);
		req.setAttribute("listNew", listNew);
		req.setAttribute("listBid", listBid);

		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
