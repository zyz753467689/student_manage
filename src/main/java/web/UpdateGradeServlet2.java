package web;

import dao.GradeDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateGradeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String snumber = request.getParameter("snumber");
		String course=request.getParameter("course");
		int grade=Integer.parseInt(request.getParameter("grade"));
		GradeDAO dao = new GradeDAO();
		dao.update_grade(snumber, course, grade);
		request.getRequestDispatcher("listpartstugrade").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
