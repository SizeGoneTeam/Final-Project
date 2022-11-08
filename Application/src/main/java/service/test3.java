package service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import entity.TbLichSuBid;
import entity.TbPhienDauGia;
import entity.TbTacGia;
import model.PhienDauGiaDao;
import model.TacGiaDao;
import model.UserDao;

public class test3 {
    public static void main(String[] args) {
        PhienDauGiaDao dao = new PhienDauGiaDao();
        UserDao dao1 = new UserDao();
        TbPhienDauGia phien = dao.findById(168);
        TbLichSuBid bid1 = new TbLichSuBid(BigInteger.valueOf(100), null);
        TbLichSuBid bid2 = new TbLichSuBid(BigInteger.valueOf(200), null);
        TbLichSuBid bid3 = new TbLichSuBid(BigInteger.valueOf(300), null);
        TbLichSuBid bid4 = new TbLichSuBid(BigInteger.valueOf(400), null);
        TbLichSuBid bid5 = new TbLichSuBid(BigInteger.valueOf(500), null);
        bid1.setAccount(dao1.findById(Long.valueOf(1)));
        bid2.setAccount(dao1.findById(Long.valueOf(1)));
        bid3.setAccount(dao1.findById(Long.valueOf(1)));
        bid4.setAccount(dao1.findById(Long.valueOf(1)));
        bid5.setAccount(dao1.findById(Long.valueOf(1)));
        phien.addBid(bid1);
        phien.addBid(bid2);
        dao.update(phien);
        phien.addBid(bid3);
        phien.addBid(bid4);
        dao.update(phien);
        
    }
}
