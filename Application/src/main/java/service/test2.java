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

public class test2 {
    public static void main(String[] args) {
        BookDao daoSach = new BookDao();
        TacGiaDao daoTacGia = new TacGiaDao();
        String name1 = "";
        String name2 = "abc";
        String name3 = "abc";
        TbSach sach = daoSach.findById(201);
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
        daoSach.update(sach);
        for (TbTacGia tbTacGia : sach.getTbTacGias()) {
            System.out.println(tbTacGia.getTenTacGia());
        }
         
    }

}
