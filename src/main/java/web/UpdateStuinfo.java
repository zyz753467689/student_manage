package web;

import dao.StuDAO;
import entity.Stu_Info;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateStuinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		String snumber=(String)session.getAttribute("username");
		System.out.println("学号："+snumber);
		StuDAO dao=new StuDAO();
		try {
			Stu_Info user=dao.find(snumber);
			//1绑定数据
			session.setAttribute("users", user);
			//2获得转发器
			response.sendRedirect("student/updatestuinfo.jsp");
			return ;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
