package control;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.StringUtils;
import org.hibernate.annotations.common.util.StringHelper;

import dao.dao;
import entity.TbAccount;
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
	    String page = request.getParameter("page");
	    HttpSession session = request.getSession();
        TbAccount account = (TbAccount) session.getAttribute("acc");
        String maKH = account.getMaTK().toString();
	    int pagecout;
	    if(page == null) {
	        page = "0";
	    }
	    else {
            page = Integer.toString(Integer.parseInt(page)*9-9);
        }

	    BookDao bookDao = new BookDao();
	    List<TbSach> search = bookDao.searchSach(key,page);  
	    List<TbSach> lastAdd = bookDao.LastAdd();
        List<TbTheLoai> category = bookDao.GetCategory();
        int count = bookDao.CountAll(key);
        int endPage = count/9;
        if(count % 9!=0) {
            endPage++;
        }
        if(maKH != null) {
            int demyt = bookDao.countyeuthich(maKH);
            int demdb = bookDao.CountDangBan(maKH);
            int demgh = bookDao.CountGioHang(maKH);
            request.setAttribute("demyt", demyt);
            request.setAttribute("demdb", demdb);
            request.setAttribute("demgh", demgh);
        }
        String endPCategory = "0";
        request.setAttribute("category", category); 
        request.setAttribute("endPCategory", endPCategory);
        request.setAttribute("endPage", endPage);
        request.setAttribute("keyout", key);
	    request.setAttribute("search", search);
	    request.setAttribute("pageout", page);
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
