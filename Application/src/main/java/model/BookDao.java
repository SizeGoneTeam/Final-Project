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

public class BookDao {
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
//    public List<TbSach> getLastSeen() {
//        String jpql = "SELECT o FROM TbSach o inner join o.TbLichSuXem p "
//                + "where o.maSach = p.maSach "
//                + "order by p.ngayXem desc";
//        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
//        List<TbSach> entity = query.setMaxResults(4).getResultList();
//        return entity;
//    }
    public List<TbSach> seachTilte(String keyword) {
        String jpql = "SELECT o FROM TbSach o where o.tenSach like :keyword";
        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
        query.setParameter("keyword","%" + keyword + "%" );
        List<TbSach> entity = query.getResultList();
        return entity;
    }
    public static void main(String[] args) {
        BookDao dao = new BookDao();
        List<TbSach> list = dao.seachTilte("xu");
          for (TbSach product : list) {
          System.out.println(product.getMaSach()+ " " + product.getTenSach());
          }
        

    }
}

