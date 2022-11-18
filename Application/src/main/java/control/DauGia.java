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

import dao.dao;
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
@WebServlet(urlPatterns = {"/DauGia"})
public class DauGia extends HttpServlet{
    @Override
    protected synchronized void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String url = "loadSach";
        HttpSession session = req.getSession();
        TbAccount account = (TbAccount) session.getAttribute("acc");
        String maKH = account.getMaTK().toString();
        UserDao daoUser = new UserDao();
        TbAccount acc = daoUser.findById(Long.valueOf(maKH));
        if(acc != null)
        {
            BookDao daoSach = new BookDao();
            PhienDauGiaDao daoPhien = new PhienDauGiaDao();
            String maSach = req.getParameter("maSach");
            TbSach sach = daoSach.findById(Integer.valueOf(maSach));
            TbPhienDauGia phien = daoPhien.findById(sach.getPhienDauGia().getMaPhien());
            if(phien.getIsEnd() != 1)
            {
                Date now = new Date();
                Timestamp NowTime = new Timestamp(now.getTime());

                GioHangDao daoGioHang = new GioHangDao();
                GioHangPK gioHangPK = new GioHangPK(acc.getMaTK().intValue(),sach.getMaSach());
                TbGioHang giohang = new TbGioHang(gioHangPK);
                phien.setIsEnd(1);
                daoGioHang.insert(giohang);
                System.out.println("thêm giỏ hàng");
                TbLichSuBid bid = new TbLichSuBid(sach.getDonGia(), acc);
                phien.addBid(bid);
                daoPhien.update(phien);
            }else {
                url = "detail?pid=" + maSach;
            }
            
            url = "cart";
        }else {
            url = "login";
        }
        
    
        resp.sendRedirect(url);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
