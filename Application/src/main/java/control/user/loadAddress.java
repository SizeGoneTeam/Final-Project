package control.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.TbAccount;
import entity.TbDiaChiKH;
import entity.TbTinhThanh;
import model.AddressDAO;
import model.BookDao;
import model.UserDao;

/**
 * Servlet implementation class loadAddress
 */
@WebServlet("/user/loadAddress")
public class loadAddress extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        TbAccount account = (TbAccount) session.getAttribute("acc");
        String MaTK = account.getMaTK().toString();
        if (account == null) {
            response.sendRedirect("../login");
            return;
        } else {
            // Sync data account
            TbAccount user = UserDao.selectAccount(Long.toString(account.getMaTK()));
            session.setAttribute("acc", user);

            List<TbTinhThanh> provinces = AddressDAO.selectAllProvince();
            BookDao dao = new BookDao();

            int demyt = dao.countyeuthich(MaTK);
            int demdb = dao.CountDangBan(MaTK);
            int demgh = dao.CountGioHang(MaTK);
            request.setAttribute("demyt", demyt);
            request.setAttribute("demdb", demdb);
            request.setAttribute("demgh", demgh);
            List<TbDiaChiKH> addresses = AddressDAO.selectAddress(user);
            int count = AddressDAO.CountAll(user);

            request.setAttribute("provinces", provinces);
            request.setAttribute("countDC", count);

            request.setAttribute("addresses", addresses);

            getServletContext().getRequestDispatcher("/user/address.jsp").forward(request, response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(req, resp);
    }

}
