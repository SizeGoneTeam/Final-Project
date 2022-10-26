package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.TbSach;
import entity.TbTheLoai;
import model.BookDao;

/**
 * Servlet implementation class CategoryControl
 */
@WebServlet("/categorysearch")

public class CategoryControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String key = request.getParameter("keycategory");
        String page = request.getParameter("page");
        int pagecout;
        if(page == null) {
            page = "0";
        }
        else {
            page = Integer.toString(Integer.parseInt(page)*9-9);
        }
        BookDao bookDao = new BookDao();
        List<TbSach> searchtheloai = bookDao.seachcategory(key,page);
        List<TbSach> lastAdd = bookDao.LastAdd();
        List<TbTheLoai> category = bookDao.GetCategory();
        int count = bookDao.CountAllCategory(key);
        int endPage = count/9;
        if(count % 9!=0) {
            endPage++;
        }
        String endPTitle ="0";
        request.setAttribute("lastAdd", lastAdd);
        request.setAttribute("search", searchtheloai); 
        request.setAttribute("category", category);
        request.setAttribute("endPCategory", endPage);
        request.setAttribute("endPTitle", endPTitle);
        request.setAttribute("pageout", page);
        request.setAttribute("keyout", key);
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