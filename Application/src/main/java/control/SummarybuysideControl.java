package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao;
import entity.TbAccount;
import entity.TbSach;
import model.BookDao;
import model.GiaodichDao;

/**
 * Servlet implementation class SummarybuysideControl
 */
@WebServlet("/SummarybuysideControl")
public class SummarybuysideControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        TbAccount account = (TbAccount) session.getAttribute("acc");
        String MaTK = account.getMaTK().toString();
        BookDao dao = new BookDao();
        List<TbSach> lastSeen = dao.getLastSeen(MaTK);
        List<TbSach> OrderTop3 = dao.OrderTop3(MaTK);
        List<TbSach> NopayTop3= dao.NoPayTop3(MaTK);
        GiaodichDao giaodichDao = new GiaodichDao();
        int Tongsachmua = giaodichDao.Tongsachmua(MaTK);
        Double Tongmua = giaodichDao.Tongmua(MaTK);
        request.setAttribute("Tongsachmua", Tongsachmua);
        request.setAttribute("Tongmua", Tongmua);

        
        
        request.setAttribute("OrderTop3", OrderTop3);
        request.setAttribute("NopayTop3", NopayTop3);
        request.setAttribute("lastSeen", lastSeen);
        

        request.getRequestDispatcher("Summary-buymode.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
