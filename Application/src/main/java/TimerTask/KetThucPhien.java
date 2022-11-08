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
import model.UserDao;

public class KetThucPhien extends TimerTask {
    private TbPhienDauGia phienDauGia;
    public KetThucPhien(TbPhienDauGia phienDauGia) {
        this.phienDauGia = phienDauGia;
    }

    @Override
    public void run() {
        Date now = new Date();
        PhienDauGiaDao dao = new PhienDauGiaDao();
        System.out.println(now);
        phienDauGia.setIsEnd(1);
        dao.update(phienDauGia);
        

    }
}
