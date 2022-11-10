package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
import entity.TbSach;
import model.BookDao;

/**
 * Servlet implementation class SummarybuysideControl
 */
@WebServlet("/SummarybuysideControl")
public class SummarybuysideControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String MaTK = request.getParameter("MaTK");
        BookDao dao = new BookDao();
        List<TbSach> lastSeen = dao.getLastSeen(MaTK);
        request.setAttribute("lastSeen", lastSeen);
        request.setAttribute("MaTK", MaTK);

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
