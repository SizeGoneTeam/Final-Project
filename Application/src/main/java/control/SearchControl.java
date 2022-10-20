package control;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.StringUtils;
import org.hibernate.annotations.common.util.StringHelper;

import entity.TbSach;
import entity.TbTheLoai;
import model.BookDao;

/**
 * Servlet implementation class SearchControl
 */
@WebServlet("/search")
public class SearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    String key = request.getParameter("key");

	    

	    BookDao bookDao = new BookDao();
	    List<TbSach> search = bookDao.seachTilte(key);  
	    List<TbSach> lastAdd = bookDao.LastAdd();
        List<TbTheLoai> category = bookDao.GetCategory();
        request.setAttribute("category", category);
	    request.setAttribute("search", search);
	    request.setAttribute("lastAdd", lastAdd);
	    request.getRequestDispatcher("Item-search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
