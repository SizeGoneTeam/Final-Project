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
import entity.TbSach;
import model.BookDao;

/**
 * Servlet implementation class SellingControl
 */
@WebServlet("/SellingControl")
public class SellingControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        TbAccount account = (TbAccount) session.getAttribute("acc");
        String MaTK = account.getMaTK().toString();
        String page = request.getParameter("page");

        BookDao dao = new BookDao();
        int pagecout;
        if(page == null) {
            page = "0";
        }
        else {
            page = Integer.toString(Integer.parseInt(page)*6-6);
        }
        int demyt = dao.countyeuthich(MaTK);
        int demdb = dao.CountDangBan(MaTK);
        int demgh = dao.CountGioHang(MaTK);
        request.setAttribute("demyt", demyt);
        request.setAttribute("demdb", demdb);
        request.setAttribute("demgh", demgh);
        List<TbSach> selling = dao.SellingTop9(MaTK,page);
        int count = dao.Tongdangban(MaTK);
        int endPage = count/6;
        if(count % 6!=0) {
            endPage++;
        }
        request.setAttribute("endPape", endPage);
        request.setAttribute("pageout", page);
        request.setAttribute("selling", selling);
        request.setAttribute("MaTK", MaTK);
        request.getRequestDispatcher("Selling.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
