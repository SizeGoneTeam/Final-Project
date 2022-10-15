package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import utils.JpaUntil;

public class UserDao {
    public void insert(TbAccount acc) {
        EntityManager em = JpaUntil.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(acc);
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
}
