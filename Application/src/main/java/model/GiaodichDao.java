package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.TbChiTietHD;
import entity.TbGioHang;
import entity.TbHoaDon;
import entity.TbSach;
import utils.JpaUntils;

public class GiaodichDao {
    private EntityManager em = JpaUntils.getEntityManager();
    @Override
    protected void finalize() throws Throwable {
        em.close();
        super.finalize();
    }
    
    public Double Doanhthutheothang(int thang, int nam) {
        String jpql = "SELECT SUM(tienHoaHong) FROM TbGiaoDich o where EXTRACT(year FROM o.ngayTao) = :nam and EXTRACT(month FROM o.ngayTao) = :thang ";
        Query query = em.createQuery(jpql);
        query.setParameter("thang",thang);
        query.setParameter("nam",nam);
        Double entity = (double) query.getSingleResult();
        return entity;
    }
    public Double Tongdoanthu(String MaTK) {
        String jpql = "SELECT SUM(tienGD) FROM TbGiaoDich o where o.nguoiNhan = :MaTK and o.loaiGD = 2";
        Query query = em.createQuery(jpql);
        query.setParameter("MaTK",Integer.parseInt(MaTK));
        if(query.getSingleResult() != null) {
        Double entity = (double) query.getSingleResult();
        return entity;
        }
        return 0.0;
    }
    public Double Tongmua(String MaTK) {
        String jpql = "SELECT SUM(tienGD) FROM TbGiaoDich o where o.nguoiGui = :MaTK and o.loaiGD = 2";
        Query query = em.createQuery(jpql);
        query.setParameter("MaTK",Integer.parseInt(MaTK));
        if(query.getSingleResult() != null) {
            Double entity = (double) query.getSingleResult();
            return entity;
        }
        return 0.0;
    }
    public Long Tongsachdang(String MaTK) {
        String jpql = "SELECT Count(o) FROM TbPhienDauGia o where o.account.maTK = :MaTK";
        Query query = em.createQuery(jpql);
        query.setParameter("MaTK",Long.parseLong(MaTK));
        if(query.getSingleResult() != null) {
            Long entity =  (Long) query.getSingleResult();
            return entity;
        }
        return (long) 0;
    }
    public Long taikhoadangkymoi(int thang, int nam) {
        String jpql = "SELECT  Count(o) FROM TbGiaoDich o where EXTRACT(year FROM o.ngayTao) = :nam and EXTRACT(month FROM o.ngayTao) = :thang ";
        Query query = em.createQuery(jpql);
        query.setParameter("thang",thang);
        query.setParameter("nam",nam);
        if(query.getSingleResult() != null) {
            Long entity = (Long) query.getSingleResult();
            return entity;
        }
        return (long) 0;
    }
    public int Tongsachmua(String MaTK) {
        String jpql = "SELECT o FROM TbHoaDon o where o.maTK = :MaTK";
        TypedQuery<TbHoaDon> query = em.createQuery(jpql, TbHoaDon.class);
        query.setParameter("MaTK",Integer.parseInt(MaTK));
        List<TbHoaDon> entity = query.getResultList();
        List<TbChiTietHD> entity1 = new ArrayList<TbChiTietHD>();
        for (TbHoaDon product : entity) {
            entity1.addAll(product.getTbChiTietHds());
        }
        int dem = 0;
        for (TbChiTietHD product : entity1) {
            dem++;
        }

        return dem;
    }
    public List<TbSach> OrderTop3(String MaTK) {
        String jpql = "SELECT o FROM TbGioHang o "
                + "where o.gioHangPK.maTK = :MaTK and o.trangThaiThanhToan = 1 order by o.gioHangPK desc";
        TypedQuery<TbGioHang> query = em.createQuery(jpql,TbGioHang.class);
        query.setParameter("MaTK",Integer.parseInt(MaTK));
        List<TbGioHang> entity = query.setMaxResults(3).getResultList();
        List<TbSach> entity1 = new ArrayList<TbSach>();
        for (TbGioHang product : entity) {
            entity1.add(product.getTbSach());
        }
        return entity1;
    }
    public static void main(String[] args) {
        GiaodichDao dao = new GiaodichDao();
        Long list = dao.taikhoadangkymoi(11,2022);
        System.out.println(list);


    }
}


