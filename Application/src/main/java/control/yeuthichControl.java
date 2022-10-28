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
 * Servlet implementation class yeuthichControl
 */
@WebServlet("/yeuthich")
public class yeuthichControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String MaTK = request.getParameter("MaTK");
	    
	    BookDao dao = new BookDao();
	    List<TbSach> getyeuthichList = dao.GetYeuThich(MaTK);
	    int dem = dao.countyeuthich(MaTK);
	    request.setAttribute("getyeuthich", getyeuthichList);
	    request.setAttribute("dem", dem);
	    request.getRequestDispatcher("YeuThich.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
