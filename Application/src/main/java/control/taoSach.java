package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.TbTacGia;
import model.TacGiaDao;

@WebServlet(urlPatterns = {"/taoSach"})
public class taoSach extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TacGiaDao dao = new TacGiaDao();
        List<TbTacGia> tacGias = dao.GetAll();
        req.setAttribute("ListTacGia", tacGias);
        req.getRequestDispatcher("updata.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }
}
