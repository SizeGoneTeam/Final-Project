package model;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.engine.spi.EntityEntryFactory;

import entity.TbAccount;
import entity.TbChiTietHD;
import entity.TbGioHang;
import entity.TbHoaDon;
import entity.TbLichSuXem;
import entity.TbLichSuXemPK;
import entity.TbNhanXet;
import entity.TbSach;
import entity.TbTacGia;
import entity.TbTheLoai;
import entity.TbYeuThich;
import entity.TbYeuThichPK;
import utils.JpaUntils;

public class BookDao {
    private EntityManager em = JpaUntils.getEntityManager();
    @Override
    protected void finalize() throws Throwable {
        em.close();
        super.finalize();
    }
    public TbSach findById(int maSach) {
        TbSach entity = em.find(TbSach.class, maSach);
        return entity;
    }
    
    public void insert(TbNhanXet nhanXet) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(nhanXet);
            trans.commit();
            
        } catch (Exception e) {
            // TODO: handle exception
            trans.rollback();
           System.out.println("Error:"+ e.toString());
        }
        finally {
            //em.close();
        }
    }
    
    public void insertyeuthich(TbYeuThich xem) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(xem);
            trans.commit();
            
            
        } catch (Exception e) {
            // TODO: handle exception
            trans.rollback();
           System.out.println("Error:"+ e.toString());
        }
        finally {
           //em.close();
        }
    }
    
    public void deleteyeuthich(TbYeuThichPK xem) {
        EntityTransaction trans = em.getTransaction();
        try {
            
            TbYeuThich tbYeuThich = em.find(TbYeuThich.class, xem);
            trans.begin();
            em.remove(tbYeuThich);
            trans.commit();
            
            
        } catch (Exception e) {
            // TODO: handle exception
            trans.rollback();
           System.out.println("Error:"+ e.toString());
        }
        finally {
           //em.close();
        }
    }
    
    public void update(TbLichSuXem xem) {
            EntityTransaction trans = em.getTransaction();
            try {
                trans.begin();
                em.merge(xem);
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
    
    public void update(TbSach sach) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(sach);
            trans.commit();
            
        } catch (Exception e) {
            // TODO: handle exception
            trans.rollback();
           System.out.println("Error:"+ e.toString());
        }
        finally {
        }
    }
    
    public void refresh(TbSach sach) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.refresh(sach);
            trans.commit();
            
        } catch (Exception e) {
            // TODO: handle exception
            trans.rollback();
           System.out.println("Error:"+ e.toString());
        }
        finally {
        }
    }
    
    public void insert(TbSach sach) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(sach);
            trans.commit();
            
        } catch (Exception e) {
            // TODO: handle exception
            trans.rollback();
           System.out.println("Error:"+ e.toString());
        }
        finally {
        }
    }


    public void insert(TbLichSuXem xem) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(xem);
            trans.commit();
            
        } catch (Exception e) {
            // TODO: handle exception
            trans.rollback();
           System.out.println("Error:"+ e.toString());
        }
        finally {
        }
    }
    public int CountDangBan(String MaTK) {
        String jpql = "SELECT count(o)  FROM TbSach o "
                + "where o.nguoiSoHuu.maTK = :MaTK and o.phienDauGia.isEnd = 0 order by o.maSach desc";
        Query query = em.createQuery(jpql);
        query.setParameter("MaTK",Long.parseLong(MaTK));
        return ((Long) query.getSingleResult()).intValue();
    }
    public int CountGioHang(String MaTK) {
        String jpql = "SELECT count(o) FROM TbGioHang o where o.gioHangPK.maTK = :MaTK";
        Query query = em.createQuery(jpql);
        query.setParameter("MaTK",Integer.parseInt(MaTK));
        return ((Long) query.getSingleResult()).intValue();
    }
    public int CountAll(String keyword) {
        String jpql = "SELECT count(o) FROM TbSach o where o.tenSach like :keyword and o.phienDauGia.isEnd = 0";
        Query query = em.createQuery(jpql);
        query.setParameter("keyword","%" + keyword + "%" );
        return ((Long) query.getSingleResult()).intValue();
    }
    
    public List<TbSach> GetAll() {
        String jpql = "SELECT o FROM TbSach o where o.phienDauGia.isEnd = 0 order by o.phienDauGia.ngayTao desc";
        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
        List<TbSach> entity = query.setMaxResults(12).getResultList();
        return entity;
    }
    public List<TbSach> GetAll2() {
        String jpql = "SELECT o FROM TbSach o";
        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
        List<TbSach> entity = query.getResultList();
        return entity;
    }
    public List<TbTheLoai> GetCategory() {
        String jpql = "SELECT o FROM TbTheLoai o";
        TypedQuery<TbTheLoai> query = em.createQuery(jpql,TbTheLoai.class);
        List<TbTheLoai> entity = query.getResultList();
        return entity;
    }
    public List<TbSach> LastAdd() {
        String jpql = "SELECT o FROM TbSach o order by o.maSach desc ";
        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
        List<TbSach> entity = query.setMaxResults(4).getResultList();
        return entity;
    }
    public List<TbSach> Lowest() {
        String jpql = "SELECT o FROM TbSach o where o.phienDauGia.isEnd = 0 order by o.donGia asc ";
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
    public List<TbSach> SellingTop3(String MaTK) {
        String jpql = "SELECT o FROM TbSach o "
                + "where o.nguoiSoHuu.maTK = :MaTK and o.phienDauGia.isEnd = 0 order by o.maSach desc";
        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
        query.setParameter("MaTK",Long.parseLong(MaTK));
        List<TbSach> entity = query.setMaxResults(3).getResultList();
        return entity;
    }
    public int Tongdangban(String MaTK) {
        String jpql = "SELECT Count(o) FROM TbSach o "
                + "where o.nguoiSoHuu.maTK = :MaTK and o.phienDauGia.isEnd = 0";
        Query query = em.createQuery(jpql);
        query.setParameter("MaTK",Long.parseLong(MaTK));
        return ((Long) query.getSingleResult()).intValue();
    }
    public List<TbSach> SellingTop9(String MaTK, String page) {
        String jpql = "SELECT o FROM TbSach o "
                + "where o.nguoiSoHuu.maTK = :MaTK and o.phienDauGia.isEnd = 0 order by o.maSach desc";
        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
        query.setParameter("MaTK",Long.parseLong(MaTK));
        List<TbSach> entity = query.setFirstResult(Integer.parseInt(page)).setMaxResults(6).getResultList();
        return entity;
    }
    public List<TbSach> SoldTop3(String MaTK) {
        String jpql = "SELECT o FROM TbSach o "
                + "where o.nguoiSoHuu.maTK = :MaTK and o.phienDauGia.isEnd = 1 order by o.phienDauGia.maPhien desc";
        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
        query.setParameter("MaTK",Long.parseLong(MaTK));
        List<TbSach> entity = query.setMaxResults(3).getResultList();
        return entity;
    }
    public int Tongdaban(String MaTK) {
        String jpql = "SELECT Count(o) FROM TbSach o "
                + "where o.nguoiSoHuu.maTK = :MaTK and o.phienDauGia.isEnd = 1";
        Query query = em.createQuery(jpql);
        query.setParameter("MaTK",Long.parseLong(MaTK));
        return ((Long) query.getSingleResult()).intValue();
    }
    
    public List<TbSach> SoldTop9(String MaTK, String page) {
        String jpql = "SELECT o FROM TbSach o "
                + "where o.nguoiSoHuu.maTK = :MaTK and o.phienDauGia.isEnd = 1 order by o.phienDauGia.maPhien desc";
        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
        query.setParameter("MaTK",Long.parseLong(MaTK));
        List<TbSach> entity = query.setFirstResult(Integer.parseInt(page)).setMaxResults(6).getResultList();
        return entity;
    }
    public List<TbSach> OrderTop3(String MaTK) {
        String jpql = "SELECT o FROM TbHoaDon o "
                + "where o.account.maTK = :MaTK order by o.NgayTao desc";
        TypedQuery<TbHoaDon> query = em.createQuery(jpql,TbHoaDon.class);
        query.setParameter("MaTK",Long.parseLong(MaTK));
        List<TbHoaDon> entity = query.setMaxResults(9).getResultList();
        List<TbChiTietHD> entity1 = new ArrayList<TbChiTietHD>();
        List<TbSach> entity2 = new ArrayList<TbSach>();
        for (TbHoaDon product : entity) {
            entity1.addAll(product.getTbChiTietHds());
        }
        for (TbChiTietHD tbSach : entity1) {
            entity2.add(tbSach.getMaSach());
        }
        return entity2;
    }
    public List<TbSach> OrderTop9(String MaTK) {
        String jpql = "SELECT o FROM TbHoaDon o "
                + "where o.account.maTK = :MaTK order by o.NgayTao desc ";
        TypedQuery<TbHoaDon> query = em.createQuery(jpql,TbHoaDon.class);
        query.setParameter("MaTK",Long.parseLong(MaTK));
        List<TbHoaDon> entity = query.setMaxResults(9).getResultList();
        List<TbChiTietHD> entity1 = new ArrayList<TbChiTietHD>();
        List<TbSach> entity2 = new ArrayList<TbSach>();
        for (TbHoaDon product : entity) {
            entity1.addAll(product.getTbChiTietHds());
        }
        for (TbChiTietHD tbSach : entity1) {
            entity2.add(tbSach.getMaSach());
        }
        return entity2;
    }
    public List<TbSach> NoPayTop3(String MaTK) {
        String jpql = "SELECT o FROM TbGioHang o "
                + "where o.gioHangPK.maTK = :MaTK order by o.gioHangPK desc";
        TypedQuery<TbGioHang> query = em.createQuery(jpql,TbGioHang.class);
        query.setParameter("MaTK",Integer.parseInt(MaTK));
        List<TbGioHang> entity = query.setMaxResults(3).getResultList();
        List<TbSach> entity1 = new ArrayList<TbSach>();
        for (TbGioHang product : entity) {
            entity1.add(product.getTbSach());
        }
        return entity1;
    }
    public List<TbSach> NoPayTop9(String MaTK) {
        String jpql = "SELECT o FROM TbGioHang o "
                + "where o.gioHangPK.maTK = :MaTK order by o.gioHangPK desc";
        TypedQuery<TbGioHang> query = em.createQuery(jpql,TbGioHang.class);
        query.setParameter("MaTK",Integer.parseInt(MaTK));
        List<TbGioHang> entity = query.setMaxResults(9).getResultList();
        List<TbSach> entity1 = new ArrayList<TbSach>();
        for (TbGioHang product : entity) {
            entity1.add(product.getTbSach());
        }
        return entity1;
    }
    public List<TbSach> getLastSeen(String MaTK) {
        String jpql = "SELECT o FROM TbLichSuXem o "
                + "where o.id.maTK = :MaTK "
                + "order by o.ngayXem desc";
        
        TypedQuery<TbLichSuXem> query = em.createQuery(jpql,TbLichSuXem.class);
        query.setParameter("MaTK",Integer.parseInt(MaTK));
        List<TbLichSuXem> entity = query.setMaxResults(4).getResultList();
        List<TbSach> entity1 = new ArrayList<TbSach>();
        for (TbLichSuXem product : entity) {
            entity1.add(product.getTbSach());
        }
        return entity1;
    }
    public List<TbSach> getLastSeenTop9(String MaTK) {
        String jpql = "SELECT o FROM TbLichSuXem o "
                + "where o.id.maTK = :MaTK "
                + "order by o.ngayXem desc";
        
        TypedQuery<TbLichSuXem> query = em.createQuery(jpql,TbLichSuXem.class);
        query.setParameter("MaTK",Integer.parseInt(MaTK));
        List<TbLichSuXem> entity = query.setMaxResults(9).getResultList();
        List<TbSach> entity1 = new ArrayList<TbSach>();
        for (TbLichSuXem product : entity) {
            entity1.add(product.getTbSach());
        }
        return entity1;
    }
    public List<TbLichSuXem> getlast(String MaTK, String MaSach) {
        String jpql = "SELECT o FROM TbLichSuXem o "
                + "where o.id.maTK = :MaTK and o.id.maSach= :MaSach ";

        TypedQuery<TbLichSuXem> query = em.createQuery(jpql,TbLichSuXem.class);
        query.setParameter("MaTK",Integer.parseInt(MaTK));
        query.setParameter("MaSach",Integer.parseInt(MaSach));
        List<TbLichSuXem> entity = query.getResultList();
        return entity;
    }
    
    
    public List<TbSach> seachTilte(String keyword, String page) {
        String jpql = "SELECT o FROM TbSach o where o.tenSach like :keyword and o.phienDauGia.isEnd = 0";
        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
        query.setParameter("keyword","%" + keyword + "%" );
        List<TbSach> entity = query.setFirstResult(Integer.parseInt(page)).setMaxResults(9).getResultList();
        return entity;
    }
    
    public List<TbSach> searchSach(String keyword,Double tien, String page) {
        String jpql = "SELECT DISTINCT o FROM TbSach o JOIN o.tbTacGias tb where (o.tenSach like :keyword or tg.tenTacGia like :keyword  or o.donGia <= :tien) and o.phienDauGia.isEnd = 0";
        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
        query.setParameter("keyword", "%" + keyword + "%"  );
        query.setParameter("tien", tien);
        List<TbSach> entity = query.setFirstResult(Integer.parseInt(page)).setMaxResults(9).getResultList();
        return entity;
    }
    
    public List<TbSach> searchSach(String keyword, String page) {
        String jpql = "SELECT DISTINCT o FROM TbSach o LEFT JOIN o.tbTacGias tg where (o.tenSach like :keyword or tg.tenTacGia like :keyword) and o.phienDauGia.isEnd = 0";
        TypedQuery<TbSach> query = em.createQuery(jpql,TbSach.class);
        query.setParameter("keyword", "%" + keyword + "%"  );
        List<TbSach> entity = query.setFirstResult(Integer.parseInt(page)).setMaxResults(9).getResultList();
        return entity;
    }
    public List<TbTacGia> searchTG(String keyword, String page) {
        String jpql = "SELECT DISTINCT o FROM TbTacGia o JOIN o.tbSachs sach where o.tenTacGia like :keyword or sach.tenSach like :keyword";
        TypedQuery<TbTacGia> query = em.createQuery(jpql,TbTacGia.class);
        query.setParameter("keyword", "%" + keyword + "%"  );
        List<TbTacGia> entity = query.getResultList();
        return entity;
    }
    
    public List<TbSach> seachcategory(String keyword, String page) {
        String jpql = "SELECT o FROM TbTheLoai o where o.tenTheLoai like :keyword";
        TypedQuery<TbTheLoai> query = em.createQuery(jpql,TbTheLoai.class);
        query.setParameter("keyword","%" + keyword + "%" );
        List<TbTheLoai> entity = query.setFirstResult(Integer.parseInt(page)).setMaxResults(9).getResultList();
        List<TbSach> entity1 = new ArrayList<TbSach>();
        List<TbSach> entity2 = new ArrayList<TbSach>();
        for (TbTheLoai product : entity) {
            entity1.addAll(product.getTbSaches());
        }
        for (TbSach tbSach : entity1) {
            if(tbSach.getPhienDauGia().getIsEnd()==0) {
                entity2.add(tbSach);
            }
        }
        return entity2;
    }
    public int CountAllCategory(String keyword) {
        String jpql = "SELECT o FROM TbTheLoai o where o.tenTheLoai like :keyword";
        int dem=0;
        TypedQuery<TbTheLoai> query = em.createQuery(jpql,TbTheLoai.class);
        query.setParameter("keyword","%" + keyword + "%" );
        List<TbTheLoai> entity = query.getResultList();
        List<TbSach> entity1 = new ArrayList<TbSach>();
        for (TbTheLoai product : entity) {
            entity1.addAll(product.getTbSaches());
        }
        for (TbSach tbSach : entity1) {
            if(tbSach.getPhienDauGia().getIsEnd()==0) {
                dem++;
            }
        }
        return dem;
    }
    
    public List<TbSach> GetYeuThich(String MaTK) {
        String jpql = "SELECT o FROM TbYeuThich o where o.id.maTK = : MaTK ";
        TypedQuery<TbYeuThich> query = em.createQuery(jpql,TbYeuThich.class);
        query.setParameter("MaTK",Integer.parseInt(MaTK));
        List<TbYeuThich> entity = query.getResultList();
        List<TbSach> entity1 = new ArrayList<TbSach>();
        for (TbYeuThich product : entity) {
            entity1.add(product.getTbSach());
        }
        return entity1;
    }
    public List<TbYeuThich> findyeuthich(String MaTK, String MaSach) {
        String jpql = "SELECT o FROM TbYeuThich o "
                + "where o.id.maTK = :MaTK and o.id.maSach= :MaSach ";

        TypedQuery<TbYeuThich> query = em.createQuery(jpql,TbYeuThich.class);
        query.setParameter("MaTK",Integer.parseInt(MaTK));
        query.setParameter("MaSach",Integer.parseInt(MaSach));
        List<TbYeuThich> entity = query.getResultList();
        return entity;
    }
    
    public int countyeuthich(String MaTK) {
        String jpql = "SELECT o FROM TbYeuThich o "
                + "where o.id.maTK = :MaTK";
        int dem =0;
        TypedQuery<TbYeuThich> query = em.createQuery(jpql,TbYeuThich.class);
        query.setParameter("MaTK",Integer.parseInt(MaTK));

        List<TbYeuThich> entity = query.getResultList();
        for (TbYeuThich product : entity) {
            dem++;
         }
        return dem;
    }
    
    public TbTheLoai findTheLoaiById(int maTheLoai) {
        TbTheLoai entity = em.find(TbTheLoai.class, maTheLoai);
        return entity;
    }
    
   
    
    public static void main(String[] args) {
        BookDao dao = new BookDao();
//        String key = "2";
//        Date date = new Date();
//        TbLichSuXemPK xem1 = new TbLichSuXemPK(2,9); 
//        
//      
//        Timestamp timestamp = new Timestamp(date.getTime());
//        TbLichSuXem xem = new TbLichSuXem(xem1, timestamp);
//        System.out.println(xem.getId().getMaSach()+ " " + xem.getId().getMaTK() + " " +xem.getNgayXem());
//        dao.update(xem);
//        dao.insert(xem);
      
//        TbYeuThichPK tbYeuThichPK = new TbYeuThichPK(2,7);
//        TbYeuThich tbYeuThich = new TbYeuThich(tbYeuThichPK);
//        dao.deleteyeuthich(tbYeuThichPK);
//        List<TbSach> list = dao.Lowest();
//        for (TbSach product : list) {
//        System.out.println(product.getMaSach());
//        }
//        List<TbYeuThich> list = dao.findyeuthich("2","12");
//          for (TbYeuThich product : list) {
//          System.out.println(product.getId());
//          }
////        
        
        System.out.println(dao.CountDangBan("1"));
    }
}

