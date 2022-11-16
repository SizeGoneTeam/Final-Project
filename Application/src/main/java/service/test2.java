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
        GiaoHang giaoHang = new GiaoHang();
        UserDao userDao = new UserDao();
        BookDao bookDao = new BookDao();
        GioHangDao gioHangDao = new GioHangDao();
        PhienDauGiaDao phienDauGiaDao = new PhienDauGiaDao();
        GiaodichDao daoGD = new GiaodichDao();
        TbAccount acc = userDao.findById(Long.valueOf(5));
        int i = 0;
        List<TbGioHang> gioHangs = gioHangDao.findGioHang(acc.getMaTK().toString());
        List<TbSach> sachs = new ArrayList<TbSach>();
        TbGiaoDich giaoDich;
        TbChiTietHD chiTietHD;
        TbHoaDon hoaDon= new TbHoaDon(acc);
        daoGD.insert(hoaDon);
        System.out.println("ma hd" + hoaDon.getMaHD());
        double TienVC = 0;
        double Tong=0;
        for (TbGioHang tbGioHang : gioHangs) {
            sachs.add(tbGioHang.getMaSach());
        }
        for (TbSach sach : sachs) {
            TienVC=giaoHang.dijkstra(acc.getTbDiaChiKhs().get(0).getTbTinhThanh().getId(), sach.getNguoiSoHuu().getTbDiaChiKhs().get(0).getTbTinhThanh().getId()).intValue();
            TienVC= (double)Math.round((TienVC/23000) *100) /100;
            Tong = TienVC + sach.getDonGia();
            System.out.println(TienVC);
            System.out.println(sach.getMaSach()+" - "+sach.getDonGia());
            giaoDich = new TbGiaoDich(2, acc.getMaTK().intValue(), sach.getNguoiSoHuu().getMaTK().intValue() , Tong);
            chiTietHD = new TbChiTietHD(hoaDon,TienVC, giaoDich, sach);
            daoGD.insert(chiTietHD);
            acc.setTien(acc.getTien()-Tong);
            userDao.update(acc);
            sach.getNguoiSoHuu().setTien(sach.getNguoiSoHuu().getTien()+ Tong * 0.8);
            userDao.update( sach.getNguoiSoHuu());
            gioHangDao.remove(gioHangs.get(i++));
            
            
            System.out.println("Giao dich: " + giaoDich.toString());
        }
        
        
        
        
        
        //TbHoaDon hoaDon = new TbHoaDon(acc, TienSach, TienVC);
       // gioHangDao.insertHD(hoaDon);
        
        
    }
}
