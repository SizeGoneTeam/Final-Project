package service;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TimerTask.GiamGia;
import TinhTien.GiaoHang;
import entity.GioHangPK;
import entity.TbAccount;
import entity.TbChiTietHD;
import entity.TbDiaChiKH;
import entity.TbGiaoDich;
import entity.TbGioHang;
import entity.TbHoaDon;
import entity.TbLichSuBid;
import entity.TbNhanXet;
import entity.TbPhienDauGia;
import entity.TbSach;
import entity.TbTacGia;
import entity.TbTheLoai;
import model.BookDao;
import model.GiaodichDao;
import model.GioHangDao;
import model.PhienDauGiaDao;
import model.TacGiaDao;
import model.UserDao;

@WebServlet("/test2")
public class test2 extends HttpServlet {
    public URL url;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String NhanXet = request.getParameter("NhanXet");
        int MaSach = Integer.valueOf(request.getParameter("MaSach"));
        int Sao = Long.valueOf(request.getParameter("Sao")).intValue();
        System.out.println("Mã Sách "+ MaSach +" Sao = "  + Sao + " | Nhận Xét: " + NhanXet);
        BookDao bookDao = new BookDao();
      
        TbSach sach = new TbSach();
        sach.getTbNhanXet().getAccount().getUName();
        
        
    }
    
}