package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.TbAccount;
import entity.TbGioHang;
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
            List<TbGioHang> carts = CartDAO.selectCart(account);
            
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
