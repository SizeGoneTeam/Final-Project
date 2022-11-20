package service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;

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

public class test2 {
    public static void main(String[] args) {
        BookDao bookDao = new BookDao();
        for (TbSach sach : bookDao.searchSach("vla","0")) {
            System.out.println(sach.toString());
        }
    }
}