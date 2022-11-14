package control;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TinhTien.GiaoHang;
import entity.TbAccount;
import entity.TbDiaChiKH;
import entity.TbGioHang;
import entity.TbTinhThanh;
import model.AddressDAO;
import model.CartDAO;
import model.UserDao;

@WebServlet("/cart")
public class CartControl extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        TbAccount account = (TbAccount) session.getAttribute("acc");
        
        if (account == null) {
            response.sendRedirect("login");
        }
        else {
            TbAccount user = UserDao.selectAccount(Long.toString(account.getMaTK()));
            session.setAttribute("acc", user);            
            
            List<TbGioHang> carts = CartDAO.selectCart(user);
            
            List<TbTinhThanh> provinces = AddressDAO.selectAllProvince();
            
            List<TbDiaChiKH> addresses = AddressDAO.selectAddress(user);

            request.setAttribute("provinces", provinces);
            
            request.setAttribute("addresses", addresses);
            
            request.setAttribute("carts", carts);
            
            getServletContext().getRequestDispatcher("/shoping-cart.jsp").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    String checkNullString(String string) {
        if (string == null) {
            return "";
        }
        return string;
    }
}
