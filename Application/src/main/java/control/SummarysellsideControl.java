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
 * Servlet implementation class SummarysellsideControl
 */
@WebServlet("/SummarysellsideControl")
public class SummarysellsideControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String MaTK = request.getParameter("MaTK");
        BookDao dao = new BookDao();
        List<TbSach> Topselling = dao.SellingTop3(MaTK);
        List<TbSach> Topsold = dao.SoldTop3(MaTK);
        

        
        request.setAttribute("Topselling", Topselling);
        request.setAttribute("Topsold", Topsold);
        request.setAttribute("MaTK", MaTK);
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