package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entity.TbAccount;
import entity.TbSach;
import entity.TbTacGia;
import utils.JpaUntils;

public class TacGiaDao {

    private EntityManager em = JpaUntils.getEntityManager();
    @Override
    protected void finalize() throws Throwable {
        em.close();
        super.finalize();
    }
    public TbTacGia findByName(String TenTacGia) {
        try {
            String jpql = "SELECT o FROM TbTacGia o WHERE o.tenTacGia =:tenTacGia";
            TypedQuery<TbTacGia> query = em.createQuery(jpql,TbTacGia.class);
            query.setParameter("tenTacGia",TenTacGia );
            TbTacGia entity = query.getSingleResult();
            return entity;
        }
        catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
    
    public void insert(TbTacGia tacGia) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(tacGia);
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
    
    public List<TbTacGia> GetAll() {
        String jpql = "SELECT o FROM TbTacGia o";
        TypedQuery<TbTacGia> query = em.createQuery(jpql,TbTacGia.class);
        List<TbTacGia> entity = query.getResultList();
        return entity;
    }
}
