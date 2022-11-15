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
import entity.TbPhienDauGia;
import entity.TbSach;
import entity.TbTacGia;
import entity.TbTheLoai;
import model.BookDao;
import model.PhienDauGiaDao;
import model.TacGiaDao;
import model.UserDao;

public class test {
    public static void main(String[] args) {
        Double a = Double.valueOf("9111111111");
        Double b = Double.valueOf("9111111111");
        System.out.println(a.compareTo(b));
        System.out.println(a -b);
        
    }

}
