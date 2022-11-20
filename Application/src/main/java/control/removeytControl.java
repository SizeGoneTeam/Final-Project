package control;

import java.io.IOException;
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
import entity.TbSach;
import entity.TbTheLoai;
import entity.TbYeuThich;
import entity.TbYeuThichPK;
import model.BookDao;

/**
 * Servlet implementation class removeytControl
 */
@WebServlet("/removeytControl")
public class removeytControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String maSach = request.getParameter("MaSach");
	        HttpSession session = request.getSession();
	        TbAccount account = (TbAccount) session.getAttribute("acc");
	        String MaTK = account.getMaTK().toString();
	        BookDao dao = new BookDao();
	        BookDao daodem = new BookDao();
	        int demyt = daodem.countyeuthich(MaTK)-1;
	        if(demyt < 0)
	            demyt = 0;
	        int demdb = daodem.CountDangBan(MaTK);
	        int demgh = daodem.CountGioHang(MaTK);
	        request.setAttribute("demyt", demyt);
	        request.setAttribute("demdb", demdb);
	        request.setAttribute("demgh", demgh);
	        TbYeuThichPK tbYeuThichPK = new TbYeuThichPK(Integer.parseInt(MaTK),Integer.parseInt(maSach));
	        dao.deleteyeuthich(tbYeuThichPK);
	        List<TbSach> getyeuthichList = dao.GetYeuThich(MaTK);
	        int dem = dao.countyeuthich(MaTK);
	        request.setAttribute("getyeuthich", getyeuthichList);
	        request.setAttribute("dem", dem);
	        request.getRequestDispatcher("YeuThich.jsp").forward(request, response);
	    }
	    /**
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // TODO Auto-generated method stub
	        doGet(request, response);
	    }
}