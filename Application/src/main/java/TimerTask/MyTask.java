package TimerTask;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimerTask;

import entity.TbAccount;
import entity.TbPhienDauGia;
import entity.TbSach;
import model.BookDao;
import model.PhienDauGiaDao;

public class MyTask extends TimerTask {
    private TbPhienDauGia phienDauGia;
    private TbAccount acc;
    private TbSach sach;

    public MyTask(TbPhienDauGia phienDauGia, TbSach sach) {
        this.phienDauGia = phienDauGia;
        this.sach = sach;
    }

    @Override
    public void run() {
        Date now = new Date();
        if (now.getTime() - phienDauGia.getNgayKetThuc().getTime() >= 0) {
            Boolean value = cancel();
            System.out.println("Stop");
            return;
        }
        
        System.out.println("Gia Thap Nhat: " + phienDauGia.getGiaThapNhat());
        System.out.println("Gia Moi: " + (phienDauGia.getGiaKhoiDiem()-phienDauGia.getGiaGiam()));
        System.out.println(phienDauGia.getGiaThapNhat()
                .compareTo(phienDauGia.getGiaKhoiDiem() -(phienDauGia.getGiaGiam())));

        if (phienDauGia.getGiaThapNhat()
                .compareTo(phienDauGia.getGiaKhoiDiem() -(phienDauGia.getGiaGiam())) == -1) {
            Double GiaMoi = phienDauGia.getGiaKhoiDiem() -(phienDauGia.getGiaGiam());
            phienDauGia.setGiaKhoiDiem(GiaMoi);
            System.out.println("Run my Task Giam Gia" + GiaMoi);
            PhienDauGiaDao daoPhien = new PhienDauGiaDao();
            BookDao daoSach = new BookDao();
            daoPhien.update(phienDauGia);
            sach.setDonGia(GiaMoi);
            daoSach.update(sach);
        }

    }
}
