package TimerTask;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimerTask;

import entity.TbAccount;
import entity.TbLichSuBid;
import entity.TbPhienDauGia;
import entity.TbSach;
import model.BookDao;
import model.PhienDauGiaDao;
import model.UserDao;

public class GiamGia extends TimerTask {
    private TbPhienDauGia phienDauGia;
    private TbSach sach;

    public GiamGia(TbPhienDauGia phienDauGia, TbSach sach) {
        this.phienDauGia = phienDauGia;
        this.sach = sach;
    }

    @Override
    public void run() {
        Date now = new Date();
        PhienDauGiaDao daoPhien = new PhienDauGiaDao();
        if (now.getTime() - phienDauGia.getNgayKetThuc().getTime() >= 0 || daoPhien.findById(phienDauGia.getMaPhien()).getIsEnd() == 1) {
            cancel();
            System.out.println(now);
            System.out.println("Stop");
            return;
        }
        
     // Kiểm tra có giảm được tiếp hay không
        if (phienDauGia.getGiaThapNhat()
                .compareTo(phienDauGia.getGiaChot() -(phienDauGia.getGiaGiam())) == -1) {
            
            // Nếu giảm xong vẫn lơn hơn giá thấp nhất
            phienDauGia.setGiaChot(phienDauGia.getGiaChot() - (phienDauGia.getGiaGiam()));
            
            System.out.println("Run my Task Giam Gia" + phienDauGia.getGiaChot());
            sach.setDonGia(phienDauGia.getGiaChot());
            TbLichSuBid bid = new TbLichSuBid(phienDauGia.getGiaChot(), null);
            System.out.println("Ma Sach" + sach.getMaSach());
            phienDauGia.addBid(bid);
            phienDauGia.setMaSach(sach);
            daoPhien.update(phienDauGia);
            phienDauGia.removeBid(bid);
        }
        else if (phienDauGia.getGiaThapNhat().compareTo(phienDauGia.getGiaChot()) != 0)
        {
            //Nếu bị thấp giá thấp nhất thì dừng giảm giá đặt về giá thấp nhất
            phienDauGia.setGiaChot(phienDauGia.getGiaThapNhat());
            System.out.println("Gia thap nhat" + phienDauGia.getGiaChot());
            sach.setDonGia(phienDauGia.getGiaChot());
            TbLichSuBid bid = new TbLichSuBid(phienDauGia.getGiaChot(), null);
            phienDauGia.addBid(bid);
            phienDauGia.setMaSach(sach);
            daoPhien.update(phienDauGia);
            System.out.println(now);
            cancel();
        }

    }
}
