package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.TbAccount;
import model.UserDao;
import utils.CookieUtil;

@WebServlet(urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    
	    String back = req.getParameter("back");
	    String url ="";
	    System.out.println("url:" + back);
	    if (back == null) {
	        url = "loadSach";
        } 
	    HttpSession session = req.getSession();
		Cookie[] cookies = req.getCookies();
		String accountID = CookieUtil.getCookieValue(cookies, "accountID");
		String username = req.getParameter("user");
        String password = req.getParameter("pass");
        
        if (accountID.equals("")) {         
            UserDao dao = new UserDao();
            TbAccount a = dao.login(username, password);
            
            if (a == null) {
                if(username != null || password != null)
                req.setAttribute("mess", "Bạn đã nhập sai tài khoản hoặc mật khẩu");
                req.setAttribute("back", back);
                url= "Login.jsp";
            }
            else {
                url = back;
                req.setAttribute("back", back);
                session.setAttribute("acc", a);
                session.setMaxInactiveInterval(60*30);
                
                String rememberMe = req.getParameter("rememberMe");
                if (rememberMe == null) {
                    rememberMe = "";
                }
                if (rememberMe.equals("on")) {
                    Cookie c = new Cookie("accountID", a.getMaTK().toString());
                    //Cookie 1 ngay
                    c.setMaxAge(60*60*24);
                    c.setPath("/");
                    resp.addCookie(c);
                }
            }
        }
        else
        {
            UserDao dao = new UserDao();
            session.setAttribute("acc", dao.selectAccount(accountID));
        }
        System.out.println(url);
        req.getRequestDispatcher(url).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
