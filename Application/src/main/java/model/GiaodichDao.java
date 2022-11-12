package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.TbSach;
import utils.JpaUntils;

public class GiaodichDao {
    private EntityManager em = JpaUntils.getEntityManager();
    @Override
    protected void finalize() throws Throwable {
        em.close();
        super.finalize();
    }
    
    public Double Doanhthutheothang(int thang, int nam) {
        String jpql = "SELECT SUM(tienHoaHong) FROM TbGiaoDich o where EXTRACT(year FROM o.ngayTao) = :nam and EXTRACT(month FROM o.ngayTao) = :thang ";
        Query query = em.createQuery(jpql);
        query.setParameter("thang",thang);
        query.setParameter("nam",nam);
        Double entity = (double) query.getSingleResult();
        return entity;
    }
    
    public static void main(String[] args) {
        GiaodichDao dao = new GiaodichDao();

        Double list = dao.Doanhthutheothang(11,2022);

        System.out.println(list);


    }
}


