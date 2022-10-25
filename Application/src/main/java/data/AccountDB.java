package data;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entity.TbAccount;

public class AccountDB {
    public static TbAccount selectAccount(String accountID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM TbAccount a WHERE a.maTK = :accountID";
        TypedQuery<TbAccount> q = em.createQuery(qString, TbAccount.class);
        q.setParameter("accountID", Long.parseLong(accountID));
        try {
            TbAccount account = q.getSingleResult();
            return account;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}