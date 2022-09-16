package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
import entity.Account;

@WebServlet(urlPatterns = { "/Register" })
public class RegisterControl extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		String re_password = req.getParameter("re_pass");

		dao Dao = new dao();
		Account a = Dao.checkAccountExitst(username);
		if (a == null) {
			if (password.equals(re_password)) {
				Dao.register(username, password);
				req.setAttribute("mess", "Đăng ký thành công");
			} else {
				req.setAttribute("mess", "Mật khấu nhập lại không chính xác");
			}

		} else {
			req.setAttribute("mess", "Tên Tài khoản đã tồn tại");
		}

		req.getRequestDispatcher("Login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}