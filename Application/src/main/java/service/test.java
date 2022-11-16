package service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;

import TimerTask.GiamGia;
import entity.TbAccount;
import entity.TbGioHang;
import entity.TbPhienDauGia;
import entity.TbSach;
import entity.TbTacGia;
import entity.TbTheLoai;
import model.BookDao;
import model.GioHangDao;
import model.PhienDauGiaDao;
import model.TacGiaDao;
import model.UserDao;

public class test {
    public static void main(String[] args) {
        GioHangDao gioHangDao = new GioHangDao();
        TbGioHang TbGioHang = gioHangDao.findGioHang("1","20");
        System.out.println(TbGioHang.getMaTK());
    }

}
