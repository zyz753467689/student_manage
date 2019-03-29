package web;

import dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String snumber=request.getParameter("snumber");
		CourseDAO dao1=new CourseDAO();
		GradeDAO dao2=new GradeDAO();
		Stu_InfoDAO dao3=new Stu_InfoDAO();
		Stu_TeaDAO dao4=new Stu_TeaDAO();
		UserDAO dao5=new UserDAO();
		try {
			dao1.delStu(snumber);
			dao2.delete(snumber);
			dao3.delete(snumber);
			dao4.delStu_Rel(snumber);
			dao5.delUser(snumber);
			request.getRequestDispatcher("liststuall").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
