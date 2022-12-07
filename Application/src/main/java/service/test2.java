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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TbSach sach = new TbSach();
        sach.getPhienDauGia().getIsEnd();
        
    }
    
}