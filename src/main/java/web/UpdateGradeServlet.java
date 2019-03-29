package web;

import dao.GradeDAO;
import entity.Grade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 添加或修改分数
 * @author ZYZ
 *
 */
public class UpdateGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String snumber = request.getParameter("snumber");
		String course=request.getParameter("course");
		GradeDAO dao = new GradeDAO();
		Grade onegrade= dao.findOneCourse(snumber, course);
		request.setAttribute("onegrade", onegrade);
		request.getRequestDispatcher("teacher/update_grade.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
