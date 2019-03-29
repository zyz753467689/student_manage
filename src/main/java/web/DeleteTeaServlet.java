package web;

import dao.CourseDAO;
import dao.Stu_TeaDAO;
import dao.TeacherDAO;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String tnumber=request.getParameter("tnumber");
		CourseDAO dao1=new CourseDAO();
		Stu_TeaDAO dao2=new Stu_TeaDAO();
		TeacherDAO dao3=new TeacherDAO();
		UserDAO dao4=new UserDAO();
		try {
			dao1.delTea(tnumber);
			dao2.delTea_Rel(tnumber);
			dao3.delete(tnumber);
			dao4.delUser(tnumber);
			request.getRequestDispatcher("listteaall").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
