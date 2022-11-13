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
import entity.TbDiaChiKH;
import entity.TbPhienDauGia;
import entity.TbSach;
import entity.TbTacGia;
import entity.TbTheLoai;
import model.BookDao;
import model.PhienDauGiaDao;
import model.TacGiaDao;
import model.UserDao;

public class test2 {
    public static void main(String[] args) {
       BookDao dao = new BookDao();
       TbSach sach = dao.findById(1);
      List<TbDiaChiKH> diaChiKHs = sach.getNguoiSoHuu().getTbDiaChiKhs();
      for (TbDiaChiKH tbDiaChiKH : diaChiKHs) {
    }
       
       
}
}
