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
import entity.TbGiaoDich;
import entity.TbSach;
import model.BookDao;
import model.GiaodichDao;

/**
 * Servlet implementation class LichsugiaodichControl
 */
@WebServlet("/LichsugiaodichControl")
public class LichsugiaodichControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        TbAccount account = (TbAccount) session.getAttribute("acc");
        String MaTK = account.getMaTK().toString();
        String page = request.getParameter("page");
        int matk = account.getMaTK().intValue();
        BookDao dao = new BookDao();
        GiaodichDao gDao = new GiaodichDao();
        int pagecout;
        if(page == null) {
            page = "0";
        }
        else {
            page = Integer.toString(Integer.parseInt(page)*12-12);
        }

        List<TbGiaoDich> lsgd = gDao.getGiaoDichs(MaTK,page);
        int count = gDao.Tonggiaodich(MaTK);
        int endPage = count/12;
        if(count % 12!=0) {
            endPage++;
        }

        int demyt = dao.countyeuthich(MaTK);
        int demdb = dao.CountDangBan(MaTK);
        int demgh = dao.CountGioHang(MaTK);

        request.setAttribute("endPape", endPage);
        request.setAttribute("demyt", demyt);
        request.setAttribute("demdb", demdb);
        request.setAttribute("demgh", demgh);
        request.setAttribute("lsgd", lsgd);
        request.setAttribute("pageout", page);

        request.setAttribute("matk", matk);
        request.getRequestDispatcher("Lichsugiaodich.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
