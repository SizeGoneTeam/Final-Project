package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.TbAccount;
import entity.TbNhanXet;
import entity.TbSach;
import model.BookDao;

/**
 * Servlet implementation class NhanXet
 */
@WebServlet("/NhanXet")
public class NhanXet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String url = "";
        try {
            HttpSession session = request.getSession();
            TbAccount acc = (TbAccount) session.getAttribute("acc");
            if(acc != null) {
                String NhanXet = request.getParameter("NhanXet");
                int MaSach = Integer.valueOf(request.getParameter("MaSach"));
                int Sao = Float.valueOf(request.getParameter("Sao")).intValue();
                System.out.println("Mã Sách "+ MaSach +" Sao = "  + Sao + " | Nhận Xét: " + NhanXet);
                BookDao bookDao = new BookDao();
                TbNhanXet tbNhanXet = new TbNhanXet(MaSach, acc.getMaTK().intValue(), NhanXet, Sao);
                bookDao.insert(tbNhanXet);
                url = "LoadSachNX?pid=" + MaSach;
            }
            else {
                url ="login";
            }
            
        } catch (Exception e) {
            url = "";
        }
        
        request.getRequestDispatcher(url).forward(request, response);
    }

}
