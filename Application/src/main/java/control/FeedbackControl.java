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
import entity.TbNhanXet;
import entity.TbSach;
import model.BookDao;
import model.GiaodichDao;
import model.UserDao;

/**
 * Servlet implementation class SummarybuysideControl
 */
@WebServlet("/FeedbackControl")
public class FeedbackControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        TbAccount account = (TbAccount) session.getAttribute("acc");
        String url = "";
        
        if(account != null) {
            int tichCuc = 0;
            int trungLap= 0;
            int tieuCuc = 0;
            double trungBinh =(double) 0.0;
            int count =0;
            url = "feedbackpage.jsp";
            String MaTK = account.getMaTK().toString();
            BookDao dao = new BookDao();
            UserDao userDao = new UserDao();
            GiaodichDao giaodichDao = new GiaodichDao();
            Long sachdadangLong = giaodichDao.Tongsachdang(MaTK);
            int demyt = dao.countyeuthich(MaTK);
            int demdb = dao.CountDangBan(MaTK);
            int demgh = dao.CountGioHang(MaTK);
            request.setAttribute("demyt", demyt);
            request.setAttribute("demdb", demdb);
            request.setAttribute("demgh", demgh);
            
            List<TbNhanXet> nhanXets = userDao.GetNhanXet(account);
            for (TbNhanXet tbNhanXet : nhanXets) {
                count++;
                trungBinh+= tbNhanXet.getSao();
                if(tbNhanXet.getSao()==5 || tbNhanXet.getSao()==4) {
                    tichCuc++;
                }else if(tbNhanXet.getSao()==3) {
                    trungLap++;
                }else {
                    tieuCuc++;
                }
            }
            
            
            // Phân trang
            
            int tongNX = userDao.GetCountNX(account);
            int endPage = tongNX/3;
            if(tongNX%3 != 0) endPage++;
            Integer startPage =1;
            try {
                 startPage = Integer.valueOf(request.getParameter("startPage"));
            }catch (Exception e) {
                // TODO: handle exception
            }
           
            List<TbNhanXet> nhanXetsPage = userDao.GetNX_Page(account, (startPage.intValue() -1) *3);
            
            
            trungBinh =((double) Math.round((trungBinh/count) *100)/100);
            request.setAttribute("tichCuc", tichCuc);
            request.setAttribute("trungLap", trungLap);
            request.setAttribute("tieuCuc", tieuCuc);
            request.setAttribute("ngayThamGIa",(account.getNgayTao().getMonth() +1) + "-" + (account.getNgayTao().getYear() + 1900));
            request.setAttribute("nhanXets", nhanXetsPage);
            request.setAttribute("trungBinh", trungBinh);
            request.setAttribute("sachdadangLong", sachdadangLong);
            request.setAttribute("tongNX", tongNX);
            request.setAttribute("endPage", endPage);
            System.out.println(nhanXets);
            
        }else {
            url = "login?back=FeedbackControl";
            
        }
        
        

        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
