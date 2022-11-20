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

import entity.Account;
import entity.Product;
import entity.TbAccount;
import entity.TbSach;
import entity.TbTheLoai;
import model.BookDao;

@WebServlet(urlPatterns = {"/loadSach"})
public class HomeControl extends HttpServlet{

	private static final long serialVersionUID = 1967259404927028254L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		BookDao home = new BookDao();
		List<TbSach> all = home.GetAll();
		List<TbSach> lowest = home.Lowest();
		List<TbSach> lastAdd = home.LastAdd();
	    List<TbTheLoai> category = home.GetCategory();
		HttpSession session=req.getSession();
		TbAccount account;
		account= (TbAccount) session.getAttribute("acc");
		if(account != null) {
		    int demyt = home.countyeuthich(account.getMaTK().toString());
		    int demdb = home.CountDangBan(account.getMaTK().toString());
		    int demgh = home.CountGioHang(account.getMaTK().toString());
			String maKH = String.valueOf(account.getMaTK());
			List<TbSach> lastSeen = home.getLastSeen(maKH);
			req.setAttribute("lastSeen", lastSeen);
			req.setAttribute("demyt", demyt);
			req.setAttribute("demdb", demdb);
			req.setAttribute("demgh", demgh);
		}
		
		req.setAttribute("listP", all);
		req.setAttribute("category", category);
		req.setAttribute("listNew", lastAdd);
		req.setAttribute("lowest", lowest);


		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}