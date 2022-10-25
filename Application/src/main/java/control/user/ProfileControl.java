package control.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.AccountDB;
import entity.TbAccount;

@WebServlet("/user/profile")
public class ProfileControl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		TbAccount account = (TbAccount) session.getAttribute("acc");
		
		if (account == null) {
		    getServletContext().getRequestDispatcher("/login").forward(request, response);
		}
		else {
		    //Sync data account
		    TbAccount data = AccountDB.selectAccount(Long.toString(account.getMaTK()));
		    session.setAttribute("acc", data);
		    
		    String fullName = request.getParameter("fullName");
	        String email = request.getParameter("email");
	        String phoneNumber = request.getParameter("phoneNumber");
	        String dateOfBirth = request.getParameter("dateOfBirth");
	        
	        if (fullName.equals("") && email.equals("") && phoneNumber.equals("") && dateOfBirth.equals("")) {
	        }
	        else {
	            //Do update
	        }

	        getServletContext().getRequestDispatcher("/user/profile.jsp").forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}