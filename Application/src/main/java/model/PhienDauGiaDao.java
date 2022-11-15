package model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entity.TbAccount;
import entity.TbLichSuBid;
import entity.TbLichSuXem;
import entity.TbPhienDauGia;
import entity.TbSach;
import entity.TbTheLoai;
import utils.JpaUntils;

public class PhienDauGiaDao {
    private EntityManager em = JpaUntils.getEntityManager();
    @Override
    protected void finalize() throws Throwable {
        em.close();
        super.finalize();
    }
    
    public TbPhienDauGia findById(int maPhien) {
        TbPhienDauGia entity = em.find(TbPhienDauGia.class, maPhien);
        return entity;
    }
    
    public void insert(TbPhienDauGia phienDauGia) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(phienDauGia);
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
    
   
    
    public void update(TbPhienDauGia phienDauGia) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(phienDauGia);
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
    
    public void refresh(TbPhienDauGia phienDauGia) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.refresh(phienDauGia);
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
    
    public List<TbLichSuBid> getTop8Bid(int maPhien) {
        String jpql = "SELECT o FROM TbLichSuBid o "
                + "where o.phienDauGia.maPhien = :maPhien "
                + "order by o.ngayTao desc";

        TypedQuery<TbLichSuBid> query = em.createQuery(jpql,TbLichSuBid.class);
        query.setParameter("maPhien",maPhien);
        List<TbLichSuBid> entity = query.setMaxResults(8).getResultList();
        return entity;
    }
    
    public TbLichSuBid getTopBid(int maPhien)
    {
        String jpql = "SELECT o FROM TbLichSuBid o "
                + "where o.phienDauGia.maPhien = :maPhien "
                + "order by o.ngayTao desc";
        TypedQuery<TbLichSuBid> query = em.createQuery(jpql,TbLichSuBid.class); 
        query.setParameter("maPhien",maPhien);
        TbLichSuBid entity = query.setMaxResults(1).getSingleResult();
        return entity;
    }
    
    public static void main(String[] args) {
        PhienDauGiaDao dao = new PhienDauGiaDao();
        TbLichSuBid bid = dao.getTopBid(18);
        System.out.println(bid.getAccount().getMaTK());
        
    }
}
