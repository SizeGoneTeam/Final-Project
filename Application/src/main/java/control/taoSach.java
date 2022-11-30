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
import entity.TbTacGia;
import model.TacGiaDao;

@WebServlet(urlPatterns = {"/taoSach"})
public class taoSach extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String url ="updata.jsp";
        TacGiaDao dao = new TacGiaDao();
        HttpSession session = request.getSession();
        TbAccount acc = (TbAccount) session.getAttribute("acc");
        if (acc==null) {
            url = "ErrorPayment.jsp";
            request.setAttribute("mess", "Vui lòng đăng nhập\r\n"
                    + "<a href=\"/login\">Login</a>");
            request.getRequestDispatcher(url).forward(request, resp);
            return;
        }
        System.out.println(acc.getDiaChiMacDinh());
        if(acc.getDiaChiMacDinh() == 0) {
            url = "ErrorPayment.jsp";
            request.setAttribute("mess", "Vui lòng thêm địa chỉ mặc định trước khi tạo sách\r\n"
                    + "<a href=\"user/profile\">Thêm địa chỉ</a>");
            request.getRequestDispatcher(url).forward(request, resp);
            return;
            
        }
        List<TbTacGia> tacGias = dao.GetAll();
        request.setAttribute("ListTacGia", tacGias);
        request.getRequestDispatcher("updata.jsp").forward(request, resp);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }
}
