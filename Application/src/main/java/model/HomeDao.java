package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dao.dao;
import entity.Account;
import entity.Product;
import entity.TbAccount;
import entity.TbSach;
import utils.JpaUntils;

public class HomeDao {
    private EntityManager em = JpaUntils.getEntityManager();
    @Override
    protected void finalize() throws Throwable {
        em.close();
        super.finalize();
    }
    
    

    public List<TbSach> GetAll() {
        String jpql = "SELECT o FROM TbSach o";
        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
        List<TbSach> entity = query.getResultList();
        return entity;
    }
    public List<TbSach> LastAdd() {
        String jpql = "SELECT o FROM TbSach o order by o.maSach desc ";
        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
        List<TbSach> entity = query.setMaxResults(4).getResultList();
        return entity;
    }    
    public List<TbSach> MostBid() {
        String jpql = "SELECT o FROM TbSach o order by o.maSach desc ";
        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
        List<TbSach> entity = query.setMaxResults(4).getResultList();
        return entity;
    }
    public List<TbSach> LastSeen() {
        String jpql = "SELECT o FROM TbSach o order by o.maSach desc ";
        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
        List<TbSach> entity = query.setMaxResults(4).getResultList();
        return entity;
    }
    public static void main(String[] args) {
        HomeDao dao = new HomeDao();
        List<TbSach> list = dao.GetAll();
          for (TbSach product : list) {
          System.out.println(product.getMaSach()+ " " + product.getTenSach());
          }
        

    }
}

