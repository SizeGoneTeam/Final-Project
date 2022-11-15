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
import entity.GioHangPK;
import entity.TbAccount;
import entity.TbDiaChiKH;
import entity.TbGioHang;
import entity.TbLichSuBid;
import entity.TbPhienDauGia;
import entity.TbSach;
import entity.TbTacGia;
import entity.TbTheLoai;
import model.BookDao;
import model.GioHangDao;
import model.PhienDauGiaDao;
import model.TacGiaDao;
import model.UserDao;

public class test2 {
    public static void main(String[] args) {
        PhienDauGiaDao daoPhien  = new PhienDauGiaDao();
        TbPhienDauGia phienDauGia = new TbPhienDauGia();
        phienDauGia = daoPhien.findById(phienDauGia.getMaPhien());
        phienDauGia.setIsEnd(1);
        TbLichSuBid bid = daoPhien.getTopBid(phienDauGia.getMaPhien());
        daoPhien.update(phienDauGia);
        Date now = new Date();
        int maSach =phienDauGia.getMaSach().getMaSach();
        GioHangDao daoGH = new GioHangDao();
        System.out.println(phienDauGia.getMaPhien());

        System.out.println(bid.getMaBid());
        int maTK = bid.getAccount().getMaTK().intValue();
        System.out.println(now);
        GioHangPK gioHangPK = new GioHangPK(maTK,maSach);
        TbGioHang giohang = new TbGioHang(gioHangPK);
        if(daoGH.findGioHang(Integer.toString(maTK), Integer.toString(maSach)).isEmpty()) {daoGH.insert(giohang); System.out.println("thêm giỏ hàng");}
    }
}
