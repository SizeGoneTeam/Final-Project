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
        PhienDauGiaDao dao = new PhienDauGiaDao();
        UserDao dao1 = new UserDao();
        BookDao dao2 = new BookDao();
        Integer ThoiGianGiam = Integer.valueOf("10");
        Integer ThoiGian = Integer.valueOf("25");
        BigInteger GiaGiam = new BigInteger("5");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Timestamp NowTime = Timestamp.valueOf(dtf.format(LocalDateTime.now()));
        Timestamp EndTime = null;
        Calendar now = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        now.setTime(NowTime);
        end.add(Calendar.SECOND, ThoiGian);
        System.out.println(now.getTime());
        System.out.println(end.getTime());

        Long NguoiSoHuu = Long.valueOf(1);
        TbPhienDauGia phien = new TbPhienDauGia(BigInteger.valueOf(1000), 1, new Timestamp(end.getTime().getTime()), NowTime, ThoiGian, GiaGiam, BigInteger.valueOf(100), ThoiGianGiam);

        TbSach sach = new TbSach(null, BigInteger.valueOf(1000), "", NowTime.toString(), null);
        String theloai1 = "1";
        String theloai2 = "2"; 
        String theloai3 = "3"; 
        String theloai4 = "4"; 
        if (theloai1 != null ) sach.addTheLoai(dao2.findTheLoaiById(Integer.valueOf(theloai1)));
        if (theloai2 != null ) sach.addTheLoai(dao2.findTheLoaiById(Integer.valueOf(theloai2)));
        if (theloai3 != null ) sach.addTheLoai(dao2.findTheLoaiById(Integer.valueOf(theloai3)));
        if (theloai4 != null ) sach.addTheLoai(dao2.findTheLoaiById(Integer.valueOf(theloai4)));
        
        TacGiaDao daoTacGia = new TacGiaDao();
        String name1 = "";
        String name2 = "abc";
        String name3 = "abc";
        TbTacGia tacgia1 = daoTacGia.findByName(name1);
        TbTacGia tacgia2 = daoTacGia.findByName(name2);
        TbTacGia tacgia3 = daoTacGia.findByName(name3);
        List<TbTacGia> tacGias = new ArrayList<TbTacGia>();
        if(tacgia1 != null )
        {
            System.out.println("thêm tác giả vào sách " + tacgia1.getTenTacGia());
           tacGias.add(tacgia1);
           
        }
        else if(name1 != null && name1 != "") {
            System.out.println("tạo tác giả " + name1);
            tacgia1 = new TbTacGia();
            tacgia1.setTenTacGia(name1);
            daoTacGia.insert(tacgia1);
            tacGias.add(tacgia1);
        }
        
        if(tacgia2 != null )
        {
            if(tacgia2!=tacgia1)
            {
                System.out.println("thêm tác giả vào sách " + tacgia2.getTenTacGia());
                tacGias.add(tacgia2);
            }
        }
        else if(name2 != null && name2 != "") {
            if(tacgia2!=tacgia1)
            {
                System.out.println("tạo tác giả " + name2);
                tacgia2 = new TbTacGia();
                tacgia2.setTenTacGia(name2);
                daoTacGia.insert(tacgia2);
                tacGias.add(tacgia2);
            }
            
        }
        
        if(tacgia3 != null )
        {
            if(tacgia3!=tacgia2 && tacgia3 != tacgia1)
            {
                System.out.println("thêm tác giả vào sách " + tacgia3.getTenTacGia());
                tacGias.add(tacgia3);
            }
            
           
        }
        else if(name3 != null && name3 != "") {
            if(tacgia3!=tacgia2 && tacgia3 != tacgia1)
            {
                System.out.println("tạo tác giả " + name3);
                tacgia3 = new TbTacGia();
                tacgia3.setTenTacGia(name3);
                daoTacGia.insert(tacgia3);
                tacGias.add(tacgia3);
            }
            
        }
        sach.setTbTacGias(tacGias);
        
        phien.setMaSach(sach);
        dao.insert(phien);
          TbAccount acc = dao1.findById(NguoiSoHuu);
          acc.add(phien);
          dao1.update(acc);
          
          // tạo task tự đông
          
          GiamGia myTask = new GiamGia(phien,sach);
          Timer timer = new Timer();
          timer.schedule(myTask, ThoiGianGiam * 1000, ThoiGianGiam * 1000);
         
         
    }

}
