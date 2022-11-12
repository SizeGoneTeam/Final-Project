package service;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import control.Chart;
import entity.GioHangPK;
import entity.TbAccount;
import entity.TbGioHang;
import entity.TbSach;
import model.BookDao;
import model.GiaodichDao;
import model.GioHangDao;
import model.UserDao;
import utils.CloudinaryUtil;

public class test3 {
    public static void main(String[] args) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Timestamp NowTime = Timestamp.valueOf(dtf.format(LocalDateTime.now()));
        Calendar now = Calendar.getInstance();
        now.setTime(NowTime);
        now.add(Calendar.YEAR, 1900);
        now.add(Calendar.MONTH, -11);
        
        GiaodichDao dao= new GiaodichDao();
        List<Chart> charts = new ArrayList<>();
        
        List<String> nam = new ArrayList<>();
        for(int i=0; i<12;i++ ) {
            try {
                Chart chart = new Chart();
                chart.setTien(dao.Doanhthutheothang(Integer.valueOf(now.getTime().getMonth())+1, Integer.valueOf(now.getTime().getYear())));
                chart.setThang(Integer.valueOf(now.getTime().getMonth())+1);
                chart.setNam(Integer.valueOf(now.getTime().getYear()));
                charts.add(chart);
                //System.out.println((now.getTime().getMonth()+1) + "/"+now.getTime().getYear()+ " :"+dao.Doanhthutheothang(Integer.valueOf(now.getTime().getMonth())+1, Integer.valueOf(now.getTime().getYear())));
                
            } catch (Exception e) {
               System.out.println(e);
            }
            now.add(Calendar.MONTH, 1);
        }
        //tien.add(dao.Doanhthutheothang(Integer.valueOf(now.getTime().getMonth())+1, Integer.valueOf(now.getTime().getYear())));
      // System.out.println(NowTime.getYear());
      for (Chart double1 : charts) {
          System.out.println(double1.getThang());
        
    }
//      for (String string : nam) {
//          System.out.println(nam);
//    }
         
    }
}