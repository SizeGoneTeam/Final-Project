package control;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
import entity.GioHangPK;
import entity.Product;
import entity.TbAccount;
import entity.TbGioHang;
import entity.TbPhienDauGia;
import entity.TbSach;
import model.BookDao;
import model.GioHangDao;
import model.PhienDauGiaDao;
import model.UserDao;
@WebServlet(urlPatterns = {"/placeBid"})
public class placeBid extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    Date now = new Date();
	    Timestamp NowTime = new Timestamp(now.getTime());
		dao Dao = new dao();
		BookDao daoSach = new BookDao();
		UserDao daoUser = new UserDao();
		PhienDauGiaDao daoPhien = new PhienDauGiaDao();
		GioHangDao daoGioHang = new GioHangDao();
		int price;
		try {
		    price = Integer.parseInt(req.getParameter("new_price"));
		}
		catch (Exception e) {
            // TODO: handle exception
        }
		 
		String maSach = req.getParameter("maSach");
		String maKH = req.getParameter("id");
		TbAccount acc = daoUser.findById(Long.valueOf(maKH));
		TbSach sach = daoSach.findById(Integer.valueOf(maSach));
		GioHangPK gioHangPK = new GioHangPK(acc.getMaTK().intValue(),sach.getMaSach());
		TbGioHang giohang = new TbGioHang(gioHangPK);
		TbPhienDauGia phien = daoPhien.findById(sach.getPhienDauGia().getMaPhien());
		if(sach.getPhienDauGia().getLoaiPhien() == 2)
		{
		    phien.setIsEnd(1);
	        if(daoGioHang.findGioHang(maKH, maSach).isEmpty()) {daoGioHang.insert(giohang); System.out.println("thêm giỏ hàng");}
	        daoPhien.update(phien);
		}
	
		resp.sendRedirect("loadSach");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
