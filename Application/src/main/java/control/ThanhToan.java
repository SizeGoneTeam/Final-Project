package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TinhTien.GiaoHang;
import entity.GioHangPK;
import entity.TbAccount;
import entity.TbChiTietHD;
import entity.TbGiaoDich;
import entity.TbGioHang;
import entity.TbHoaDon;
import entity.TbSach;
import model.BookDao;
import model.GiaodichDao;
import model.GioHangDao;
import model.UserDao;

/**
 * Servlet implementation class ThanhToan
 */
@WebServlet("/ThanhToan")
public class ThanhToan extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        
        try {
            GiaoHang giaoHang = new GiaoHang();
            UserDao userDao = new UserDao();
            GioHangDao gioHangDao = new GioHangDao();
            GiaodichDao GDDao = new GiaodichDao();
            BookDao bookDao = new BookDao();
            HttpSession session = request.getSession();
            TbAccount acc = (TbAccount) session.getAttribute("acc");
            TbGioHang gioHang = new TbGioHang();
            TbChiTietHD chiTietHD = new TbChiTietHD();
            TbGiaoDich giaoDich = new TbGiaoDich();

            acc = userDao.findById(acc.getMaTK());

            // Danh sách sách cần thanh toán
            String[] maSachs = request.getParameterValues("MaSach");
            List<TbSach> sachs = new ArrayList<TbSach>();
            for (String maSach : maSachs) {
                sachs.add(bookDao.findById(Integer.valueOf(maSach)));
                System.out.println(maSach);
            }
            double TienVC = 0;
            double Tong = 0;
            int i = 0;

            // Kiểm tra tài khoản đủ tiền hay không
            for (TbSach sach : sachs) {
                TienVC += giaoHang.dijkstra(acc.getTbDiaChiKhs().get(0).getTbTinhThanh().getId(),
                        sach.getNguoiSoHuu().getTbDiaChiKhs().get(0).getTbTinhThanh().getId()).intValue();
                TienVC = (double) Math.round((TienVC / 23000) * 100) / 100;
                Tong += TienVC + sach.getDonGia();
            }
            System.out.println(Tong);
            if (acc.getTien() > Tong) {

                TbHoaDon hoaDon = new TbHoaDon(acc);
                GDDao.insert(hoaDon);
                for (TbSach sach : sachs) {
                    TienVC = giaoHang.dijkstra(acc.getTbDiaChiKhs().get(0).getTbTinhThanh().getId(),
                            sach.getNguoiSoHuu().getTbDiaChiKhs().get(0).getTbTinhThanh().getId()).intValue();
                    TienVC = (double) Math.round((TienVC / 23000) * 100) / 100;
                    Tong = TienVC + sach.getDonGia();
                    giaoDich = new TbGiaoDich(2, acc.getMaTK().intValue(), sach.getNguoiSoHuu().getMaTK().intValue(), Tong);
                    chiTietHD = new TbChiTietHD(hoaDon, TienVC, giaoDich, sach);
                    GDDao.insert(chiTietHD);
                    acc.setTien(Math.ceil((acc.getTien() - Tong)*100) /100);
                    userDao.update(acc);
                    sach.getNguoiSoHuu().setTien(Math.ceil((sach.getNguoiSoHuu().getTien() + Tong * 0.8)*100)/100);
                    userDao.update(sach.getNguoiSoHuu());
                    gioHangDao.remove(gioHangDao.findGioHang(acc.getMaTK().toString(), Integer.toString(sach.getMaSach())));
                }
                url = "OrderControl";
            } else {
                url = "ErrorPayment.jsp";
                request.setAttribute("mess", "Tài khoản không đủ thanh toán\r\n"
                        + "Vui lòng kiểm tra lại số dư");
            }
        }catch (Exception e) {
            url = "ErrorPayment.jsp";
        }
        
        request.getRequestDispatcher(url).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
