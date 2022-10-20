package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.dao;
import entity.BidHistory;
import entity.Product;
import entity.TbTheLoai;
import model.BookDao;


@WebServlet("/detail")
public class DetailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		String maKH = request.getParameter("maKH");
		dao Dao = new dao();
		Product p = Dao.getProductbyID(id);
		List<BidHistory> list = Dao.getTopBid(p.getMaSach());
		List<Product> last = Dao.getLast(maKH, id);
		BookDao home = new BookDao();
		List<TbTheLoai> category = home.GetCategory();
		if(last.isEmpty()) {
			Dao.addLastSeen(maKH, id);
			 
		}
		else {
			Dao.updateDate(maKH, id); 
		}
		request.setAttribute("BidHistory", list);
		request.setAttribute("detail", p);
		request.setAttribute("category", category);


		request.getRequestDispatcher("Item-detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}