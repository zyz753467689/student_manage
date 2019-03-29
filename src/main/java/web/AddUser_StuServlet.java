package web;

import dao.UserDAO;
import entity.Stu_Info;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 为学生添加用户名和密码
 * @author ZYZ
 *
 */
public class AddUser_StuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Stu_Info tea= (Stu_Info) request.getAttribute("student");
		String snumber= tea.getSnumber();
		UserDAO dao=new UserDAO();
		try {
			dao.addUser(snumber, snumber,1);
			request.getRequestDispatcher("liststuall").forward(request, response);
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
