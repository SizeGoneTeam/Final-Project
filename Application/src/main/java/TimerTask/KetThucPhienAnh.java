package TimerTask;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimerTask;

import entity.GioHangPK;
import entity.TbAccount;
import entity.TbGioHang;
import entity.TbLichSuBid;
import entity.TbPhienDauGia;
import entity.TbSach;
import model.BookDao;
import model.GioHangDao;
import model.PhienDauGiaDao;
import model.UserDao;

public class KetThucPhienAnh extends TimerTask {
    private TbPhienDauGia phienDauGia;
    public KetThucPhienAnh(TbPhienDauGia phienDauGia) {
        this.phienDauGia = phienDauGia;
    }

    @Override
    public void run() {
        PhienDauGiaDao daoPhien = new PhienDauGiaDao();
        phienDauGia = daoPhien.findById(phienDauGia.getMaPhien());
        phienDauGia.setIsEnd(1);
        TbLichSuBid bid = daoPhien.getTopBid(phienDauGia.getMaPhien());
        daoPhien.update(phienDauGia);
        Date now = new Date();
        int maSach =phienDauGia.getMaSach().getMaSach();
        GioHangDao daoGH = new GioHangDao();
        System.out.println(phienDauGia.getMaPhien());

        System.out.println(bid.getMaBid());
        int maTK = bid.getAccount().getMaTK().intValue();
        System.out.println(now);
        GioHangPK gioHangPK = new GioHangPK(maTK,maSach);
        TbGioHang giohang = new TbGioHang(gioHangPK);
        if(daoGH.findGioHang(Integer.toString(maTK), Integer.toString(maSach)).isEmpty()) {daoGH.insert(giohang); System.out.println("thêm giỏ hàng");}
        

    }
}
