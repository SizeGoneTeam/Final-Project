package service;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import entity.GioHangPK;
import entity.TbAccount;
import entity.TbGioHang;
import entity.TbSach;
import model.BookDao;
import model.GioHangDao;
import model.UserDao;
import utils.CloudinaryUtil;

public class test3 {
    public static void main(String[] args) throws IOException {
        Date now = new Date();
        Timestamp NowTime = new Timestamp(now.getTime());
        BookDao daoSach = new BookDao();
        UserDao daoUser = new UserDao();
        GioHangDao daoGioHang = new GioHangDao();

          GioHangPK gioHangPK = new GioHangPK(1,330);
          TbGioHang giohang = new TbGioHang(gioHangPK);
          if(daoGioHang.findGioHang("1", "330").isEmpty()) {daoGioHang.insert(giohang); System.out.println("thêm giỏ hàng");}
         
    }
}