package control;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.GioHangPK;
import entity.Product;
import entity.TbAccount;
import entity.TbGioHang;
import entity.TbLichSuBid;
import entity.TbPhienDauGia;
import entity.TbSach;
import model.BookDao;
import model.GioHangDao;
import model.PhienDauGiaDao;
import model.UserDao;
@WebServlet(urlPatterns = {"/placeBid"})
public class placeBid extends HttpServlet{
	@Override
	protected synchronized void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String url ="";
	    HttpSession session = req.getSession();
        TbAccount account = (TbAccount) session.getAttribute("acc");
        String maKH = account.getMaTK().toString();
        if(maKH != null)
        {
            Date now = new Date();
            BookDao daoSach = new BookDao();
            UserDao daoUser = new UserDao();
            PhienDauGiaDao daoPhien = new PhienDauGiaDao();
            Double price = Double.valueOf(req.getParameter("new_price"));
             
            String maSach = req.getParameter("maSach");
            TbAccount acc = daoUser.findById(Long.valueOf(maKH));
            TbSach sach = daoSach.findById(Integer.valueOf(maSach));
            TbPhienDauGia phien = daoPhien.findById(sach.getPhienDauGia().getMaPhien());
            System.out.println(phien.getNgayKetThuc().getTime() - now.getTime());
            if(phien.getNgayKetThuc().getTime() - now.getTime() < 0 || daoPhien.findById(phien.getMaPhien()).getIsEnd() == 1)
            {
                phien.setGiaChot(price);
                daoPhien.update(phien);
                url = "ErrorPayment.jsp";
                req.setAttribute("mess", "Phiên đấu giá đã kết thúc");
            }else {
                if(price - sach.getDonGia() >0)
                {
                    TbLichSuBid bid = new TbLichSuBid(price, acc);
                    phien.addBid(bid);
                    phien.setGiaChot(price);
                    phien.getMaSach().setDonGia(price);
                    daoPhien.update(phien);
                    url = "detail?pid=" + sach.getMaSach();
                }else {
                    url = "ErrorPayment.jsp";
                    req.setAttribute("mess", "Có người đã đặt giá cao hơn bạn\r\n"
                            + "Bạn vui lòng thử lại sau");
                }
            }
            
        }else {
            url = "login";
        }
	    
        
		req.getRequestDispatcher(url).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
