package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entity.TbAccount;
import entity.TbDiaChiKH;
import entity.TbGioHang;
import utils.JpaUntils;

public class CartDAO {
    public static List<TbGioHang> selectCart(TbAccount account) {
        EntityManager em = JpaUntils.getEmFactory().createEntityManager();
        String qString = "SELECT c FROM TbGioHang c WHERE c.tbAccount = :account";
        TypedQuery<TbGioHang> q = em.createQuery(qString, TbGioHang.class);
        q.setParameter("account", account);
        try {
            List<TbGioHang> addresses = q.getResultList();
            return addresses;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
