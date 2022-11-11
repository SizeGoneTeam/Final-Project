package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.TbSach;
import model.BookDao;

/**
 * Servlet implementation class OrderControl
 */
@WebServlet("/OrderControl")
public class OrderControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String MaTK = request.getParameter("MaTK");
        BookDao dao = new BookDao();
        List<TbSach> lastSeen = dao.getLastSeen(MaTK);
        List<TbSach> Order = dao.OrderTop9(MaTK);

        request.setAttribute("Order", Order);

        request.setAttribute("lastSeen", lastSeen);
        request.setAttribute("MaTK", MaTK);

        request.getRequestDispatcher("Order.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}