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
import dao.dao;
import entity.TbAccount;
import entity.TbAnh;
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
        BookDao bookDao = new BookDao();
        TbSach sach = bookDao.findById(52);
        List<TbAnh> anhs = sach.getAnhs();
        for (TbAnh tbAnh : anhs) {
            System.out.println(tbAnh.getAnh());
        }
        
    }

}
