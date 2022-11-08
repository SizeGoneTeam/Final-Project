package model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entity.TbAccount;
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
    
    
    public static void main(String[] args) {
        /*
         * BookDao dao2 = new BookDao();
         * PhienDauGiaDao dao = new PhienDauGiaDao();
         * UserDao dao1 = new UserDao();
         * TbPhienDauGia phien = new TbPhienDauGia(null, BigInteger.valueOf(100), 0,
         * null, Timestamp.valueOf("2022-10-25 11:44:10"));
         * TbSach sach = new TbSach(null, BigInteger.valueOf(100), null, "Deromon 2");
         * //dao2.insert(sach);
         * System.out.println(sach);
         * TbAccount acc = dao1.findByName("hai");
         * phien.setMaSach(sach);
         * dao.insert(phien);
         * System.out.println(phien);
         * acc.add(phien);
         * dao1.update(acc);
         */
        // System.out.println(acc);
       //  System.out.println(acc.getPhienDauGias());
        
    }
}
