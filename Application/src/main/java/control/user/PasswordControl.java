package control.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.TbAccount;
import model.UserDao;

@WebServlet("/user/password")
public class PasswordControl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        TbAccount account = (TbAccount) session.getAttribute("acc");
        
        if (account == null) {
            response.sendRedirect("../login");
        }
        else {
            //Sync data account
            TbAccount data = UserDao.selectAccount(Long.toString(account.getMaTK()));
            session.setAttribute("acc", data);
            
            String oldPassword = checkNullString(request.getParameter("oldPassword"));
            String newPassword = checkNullString(request.getParameter("newPassword"));
            String newPasswordRepeat = checkNullString(request.getParameter("newPasswordRepeat"));
          
            if (oldPassword.equals("") || newPassword.equals("") || newPasswordRepeat.equals("")) {
                //First launch
            }
            else {
                String message;

                if (oldPassword.equals(data.getPWord()) && newPassword.equals(newPasswordRepeat)) {
                    data.setPWord(newPassword);
                    
                    if (UserDao.updateAccount(data)) {
                        message = "Đổi mật khẩu thành công";
                    }
                    else {
                        message = "Đổi mật khẩu không thành công";
                    }
                }
                else {
                    message = "Đổi mật khẩu không thành công";
                }
                
                request.setAttribute("message", message);
            }  
            
            getServletContext().getRequestDispatcher("/user/password.jsp").forward(request, response);
        }
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	String checkNullString(String string) {
        if (string == null) {
            return "";
        }
        return string;
    }
}