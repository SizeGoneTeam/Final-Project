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
 * Servlet implementation class SellingControl
 */
@WebServlet("/SellingControl")
public class SellingControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String MaTK = request.getParameter("MaTK");
        BookDao dao = new BookDao();
        List<TbSach> selling = dao.SellingTop9(MaTK);
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
