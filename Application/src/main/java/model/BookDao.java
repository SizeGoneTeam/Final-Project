package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dao.dao;
import entity.Account;
import entity.Product;
import entity.TbAccount;
import entity.TbSach;
import entity.TbTheLoai;
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
    public List<TbTheLoai> GetCategory() {
        String jpql = "SELECT o FROM TbTheLoai o";
        TypedQuery<TbTheLoai> query = em.createQuery(jpql,TbTheLoai.class);
        List<TbTheLoai> entity = query.setMaxResults(12).getResultList();
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
    public List<TbSach> seachcategory(String keyword) {
        String jpql = "SELECT o FROM TbTheLoai o where o.tenTheLoai like :keyword";
        TypedQuery<TbTheLoai> query = em.createQuery(jpql,TbTheLoai.class);
        query.setParameter("keyword","%" + keyword + "%" );
        List<TbTheLoai> entity = query.getResultList();
        List<TbSach> entity1 = new ArrayList<TbSach>();
        for (TbTheLoai product : entity) {
            entity1.addAll(product.getTbSaches());
        }
        return entity1;
    }
    public static void main(String[] args) {
        BookDao dao = new BookDao();
        String key = "2";
        List<TbTheLoai> list = dao.GetCategory();
          for (TbTheLoai product : list) {
          System.out.println(product.getMaTheLoai()+ " " + product.getTenTheLoai());
          }
        
    }
}

