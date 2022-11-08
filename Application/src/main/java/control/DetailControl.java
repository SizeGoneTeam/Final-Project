package control;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.dao;
import entity.BidHistory;
import entity.Product;
import entity.TbLichSuXem;
import entity.TbLichSuXemPK;
import entity.TbTheLoai;
import model.BookDao;
import model.UserDao;


@WebServlet("/detail")
public class DetailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		String maKH = request.getParameter("maKH");
		dao Dao = new dao();
		Product p = Dao.getProductbyID(id);
		List<BidHistory> list = Dao.getTopBid(p.getMaSach());
		//List<Product> last = Dao.getLast(maKH, id);
		BookDao detail = new BookDao();
		List<TbTheLoai> category = detail.GetCategory();
		if(maKH !="") {
    		List<TbLichSuXem> last = detail.getlast(maKH, id);
            TbLichSuXemPK xem1 = new TbLichSuXemPK(Integer.parseInt(maKH),Integer.parseInt(id)); 
            int dem = detail.countyeuthich(maKH);
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            TbLichSuXem xem = new TbLichSuXem(xem1, timestamp);
            request.setAttribute("dem", dem);
    		if(last.isEmpty()) {
    		    detail.insert(xem);
    			 
    		}
    		else {
    			detail.update(xem); 
    		}
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