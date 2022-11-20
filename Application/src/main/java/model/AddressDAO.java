package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.TbAccount;
import entity.TbDiaChiKH;
import entity.TbTinhThanh;
import utils.JpaUntils;

public class AddressDAO {
    public static List<TbDiaChiKH> selectAddress(TbAccount account) {
        EntityManager em = JpaUntils.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM TbDiaChiKH a WHERE a.tbAccount = :account";
        TypedQuery<TbDiaChiKH> q = em.createQuery(qString, TbDiaChiKH.class);
        q.setParameter("account", account);
        try {
            List<TbDiaChiKH> addresses = q.getResultList();
            return addresses;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    public static boolean insertAddress(TbDiaChiKH address) {
        EntityManager em = JpaUntils.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(address);
            trans.commit();
        }
        catch (Exception ex) {
            trans.rollback();
            return false;
        }
        finally {
            em.close();
        }
        return true;
    }
    public static boolean deleteAddress(TbDiaChiKH address) {
        EntityManager em = JpaUntils.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(address));
            trans.commit();
        }
        catch (Exception ex) {
            trans.rollback();
            return false;
        }
        finally {
            em.close();
        }
        return true;
    }
    public static boolean updateAddress(TbDiaChiKH address) {
        EntityManager em = JpaUntils.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(address);
            trans.commit();
        }
        catch (Exception ex) {
            trans.rollback();
            return false;
        }
        finally {
            em.close();
        }
        return true;
    }
    public static List<TbTinhThanh> selectAllProvince() {
        EntityManager em = JpaUntils.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM TbTinhThanh p";
        TypedQuery<TbTinhThanh> q = em.createQuery(qString, TbTinhThanh.class);
        try {
            List<TbTinhThanh> provinces = q.getResultList();
            return provinces;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static int CountAll(TbAccount account) {
        EntityManager em = JpaUntils.getEmFactory().createEntityManager();
        String jpql = "SELECT count(a) FROM TbDiaChiKH a WHERE a.tbAccount = :account";
        Query query = em.createQuery(jpql);
        query.setParameter("account", account);
        return ((Long) query.getSingleResult()).intValue();
    }
}
