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
import javax.servlet.http.HttpSession;


import entity.BidHistory;
import entity.Product;
import entity.TbAccount;
import entity.TbAnh;
import entity.TbGioHang;
import entity.TbLichSuBid;
import entity.TbLichSuXem;
import entity.TbLichSuXemPK;
import entity.TbSach;
import entity.TbTacGia;
import entity.TbTheLoai;
import model.BookDao;
import model.GioHangDao;
import model.PhienDauGiaDao;
import model.UserDao;


@WebServlet("/LoadSachNX")
public class LoadSachNX extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String url = "SachNhanXet.jsp";
	    try
	    {
	        String id = request.getParameter("pid");
	         HttpSession session = request.getSession();
	        TbAccount account = (TbAccount) session.getAttribute("acc");
	        String maKH = account.getMaTK().toString();
	        UserDao userDao = new UserDao();
	        account = userDao.findById(Long.valueOf(maKH));
	        BookDao daoSach = new BookDao();
	        TbSach sach = daoSach.findById(Integer.valueOf(id));
	        BookDao detail = new BookDao();
	        List<TbAnh> anhs = sach.getAnhs();
	        if(maKH != null) {
	            int demyt = daoSach.countyeuthich(maKH);
	            int demdb = daoSach.CountDangBan(maKH);
	            int demgh = daoSach.CountGioHang(maKH);
	            
	            List<TbLichSuXem> last = detail.getlast(maKH, id);
	            TbLichSuXemPK xem1 = new TbLichSuXemPK(Integer.parseInt(maKH),Integer.parseInt(id)); 
	            Date date = new Date();
	            Timestamp timestamp = new Timestamp(date.getTime());
	            TbLichSuXem xem = new TbLichSuXem(xem1, timestamp);
	            request.setAttribute("demyt", demyt);
	            request.setAttribute("demdb", demdb);
	            request.setAttribute("demgh", demgh);
	            request.setAttribute("diachi", account.getDiaChiMacDinh());
	            System.out.println(account.getDiaChiMacDinh());
	            session.setAttribute("acc", account);
	            
	            if(last.isEmpty()) {
	                detail.insert(xem);
	                 
	            }
	            else {
	                detail.update(xem); 
	            }
	        }
	        request.setAttribute("detail", sach);
	        request.setAttribute("anhs", anhs);
	    }catch (Exception e) {
            url = "login";
            e.printStackTrace();
        }
		


		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}