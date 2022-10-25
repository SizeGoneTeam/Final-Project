package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entity.TbAccount;
import utils.JpaUntils;

public class UserDao {
    private EntityManager em = JpaUntils.getEntityManager();
    @Override
    protected void finalize() throws Throwable {
        em.close();
        super.finalize();
    }
    
    public void insert(TbAccount acc) {
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
    
    
    public Boolean checkExitAccount(String UName) {
        
        TbAccount acc = em.find(TbAccount.class, UName);
        if(acc != null) return true;
        return false;
    }
    
    public TbAccount findById(Long maTK) {
        TbAccount entity = em.find(TbAccount.class, maTK);
        return entity;
    }
    
    public TbAccount findByName(String UName) {
        try {
            String jpql = "SELECT o FROM TbAccount o WHERE o.UName =:UName";
            TypedQuery<TbAccount> query = em.createQuery(jpql,TbAccount.class);
            query.setParameter("UName",UName );
            TbAccount entity = query.getSingleResult();
            return entity;
        }
        catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
    
    public TbAccount login(String UName, String PWord ) {
        try {
            String jpql = "SELECT o FROM TbAccount o WHERE o.UName =:UName AND o.PWord =:PWord";
            TypedQuery<TbAccount> query = em.createQuery(jpql,TbAccount.class);
            query.setParameter("UName",UName );
            query.setParameter("PWord",PWord );
            TbAccount entity = query.getSingleResult();
            return entity;
        }
        catch (Exception e) {
           
        }
        return null;
        
    }
    
    public void update(TbAccount acc) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(acc);
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
    
    public void delete(Long maTK) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            TbAccount acc = em.find(TbAccount.class, maTK);
            if(acc != null)
                em.merge(acc);
            else {
                throw new Exception("Can't delete user. User can't found");
            }
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
