package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entity.TbAccount;
import entity.TbGioHang;
import entity.TbHoaDon;
import entity.TbSach;
import entity.TbYeuThich;
import utils.JpaUntils;

public class GioHangDao {
    private EntityManager em = JpaUntils.getEntityManager();
    @Override
    protected void finalize() throws Throwable {
        em.close();
        super.finalize();
    }
    
    public void remove(TbGioHang gioHang) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(gioHang);
            trans.commit();
            
        } catch (Exception e) {
            // TODO: handle exception
            trans.rollback();
           System.out.println("Error:"+ e.toString());
        }
        finally {
            //em.close();
        }
    }
    
    public void insert(TbGioHang gioHang) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(gioHang);
            trans.commit();
            
        } catch (Exception e) {
            // TODO: handle exception
            trans.rollback();
           System.out.println("Error:"+ e.toString());
        }
        finally {
            em.close();
        }
    }
    
    public void insertHD(TbHoaDon hoaDon) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(hoaDon);
            trans.commit();
            
        } catch (Exception e) {
            // TODO: handle exception
            trans.rollback();
           System.out.println("Error:"+ e.toString());
        }
        finally {
            em.close();
        }
    }
    
    public List<TbSach> GetYeuThich(String MaTK) {
        String jpql = "SELECT o FROM TbGioHang o where o.gioHangPK.maTK = : MaTK ";
        TypedQuery<TbYeuThich> query = em.createQuery(jpql,TbYeuThich.class);
        query.setParameter("MaTK",Integer.parseInt(MaTK));
        List<TbYeuThich> entity = query.getResultList();
        List<TbSach> entity1 = new ArrayList<TbSach>();
        for (TbYeuThich product : entity) {
            entity1.add(product.getTbSach());
        }
        return entity1;
    }
    public TbGioHang findGioHang(String MaTK, String MaSach) {
        String jpql = "SELECT o FROM TbGioHang o "
                + "where o.gioHangPK.maTK = :MaTK and o.gioHangPK.maSach= :MaSach ";

        TypedQuery<TbGioHang> query = em.createQuery(jpql,TbGioHang.class);
        query.setParameter("MaTK",Integer.parseInt(MaTK));
        query.setParameter("MaSach",Integer.parseInt(MaSach));
        TbGioHang entity = query.getSingleResult();
        return entity;
    }
    
    public List<TbGioHang> findGioHang(String MaTK) {
        String jpql = "SELECT o FROM TbGioHang o "
                + "where o.gioHangPK.maTK = :MaTK ";

        TypedQuery<TbGioHang> query = em.createQuery(jpql,TbGioHang.class);
        query.setParameter("MaTK",Integer.parseInt(MaTK));
        List<TbGioHang> entity = query.getResultList();
        return entity;
    }

}
