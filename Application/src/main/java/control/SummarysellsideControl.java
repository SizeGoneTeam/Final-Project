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
import model.GiaodichDao;
import model.PhienDauGiaDao;

/**
 * Servlet implementation class SummarysellsideControl
 */
@WebServlet("/SummarysellsideControl")
public class SummarysellsideControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        TbAccount account = (TbAccount) session.getAttribute("acc");
        String MaTK = account.getMaTK().toString();
        BookDao dao = new BookDao();
        List<TbSach> Topselling = dao.SellingTop3(MaTK);
        List<TbSach> Topsold = dao.SoldTop3(MaTK);
        GiaodichDao giaodichDao = new GiaodichDao();
        Long sachdadangLong = giaodichDao.Tongsachdang(MaTK);
        Double tongdoanhthu = giaodichDao.Tongdoanthu(MaTK);

        
        request.setAttribute("Topselling", Topselling);
        request.setAttribute("Topsold", Topsold);
        request.setAttribute("sachdadangLong", sachdadangLong);
        request.setAttribute("tongdoanhthu", tongdoanhthu);
        request.getRequestDispatcher("Summary-sellmode.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}