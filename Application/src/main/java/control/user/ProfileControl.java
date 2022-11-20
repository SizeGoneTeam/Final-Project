package control.user;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.TbAccount;
import model.BookDao;
import model.UserDao;

@WebServlet("/user/profile")
public class ProfileControl extends HttpServlet {
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
	        String MaTK = account.getMaTK().toString();
		    String fullName = checkNullString(request.getParameter("fullName"));
	        String email = checkNullString(request.getParameter("email"));
	        String phoneNumber = checkNullString(request.getParameter("phoneNumber"));
	        String dateOfBirth = checkNullString(request.getParameter("dateOfBirth"));
	        BookDao dao = new BookDao();
	        
	        int demyt = dao.countyeuthich(MaTK);
	        int demdb = dao.CountDangBan(MaTK);
	        int demgh = dao.CountGioHang(MaTK);
	        request.setAttribute("demyt", demyt);
	        request.setAttribute("demdb", demdb);
	        request.setAttribute("demgh", demgh);
	        if (fullName.equals("") && email.equals("") && phoneNumber.equals("") && dateOfBirth.equals("")) {
	        }
	        else {
	            data.setHoTen(fullName);
	            data.setEmail(email);
	            data.setPhone(phoneNumber);
	            data.setDateOfBirth(java.sql.Date.valueOf(dateOfBirth));
	               
	            boolean flag = UserDao.updateAccount(data);
	        }

	        getServletContext().getRequestDispatcher("/user/profile.jsp").forward(request, response);
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