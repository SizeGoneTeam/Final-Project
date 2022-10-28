package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.TbSach;
import entity.TbYeuThich;
import entity.TbYeuThichPK;
import model.BookDao;

/**
 * Servlet implementation class insertyt
 */
@WebServlet("/insertyt")
public class insertyt extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSach = request.getParameter("MaSach");
        String MaTK = request.getParameter("MaTK");
        BookDao dao = new BookDao();
        List<TbSach> getyeuthichList = dao.GetYeuThich(MaTK);
        TbYeuThichPK tbYeuThichPK = new TbYeuThichPK(Integer.parseInt(MaTK),Integer.parseInt(maSach));
        TbYeuThich tbYeuThich = new TbYeuThich(tbYeuThichPK);
        if(dao.findyeuthich(MaTK, maSach).isEmpty()) {
            dao.insertyeuthich(tbYeuThich);
        }
        

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}