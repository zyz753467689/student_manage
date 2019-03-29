package web;

import dao.UserDAO;
import entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 为教师添加用户和密码
 * @author ZYZ
 *
 */
public class AddUser_TeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Teacher tea= (Teacher) request.getAttribute("teacher");
		String tnumber= tea.getTnumber();
		UserDAO dao=new UserDAO();
		try {
			dao.addUser(tnumber, tnumber,2);
			request.getRequestDispatcher("listteaall").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("服务器繁忙，请稍后重试！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
