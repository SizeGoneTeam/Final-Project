package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.TbAccount;
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
        HttpSession session = request.getSession();
        TbAccount account = (TbAccount) session.getAttribute("acc");
        String MaTK = account.getMaTK().toString();
        BookDao dao = new BookDao();
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