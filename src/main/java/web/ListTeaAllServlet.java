package web;

import dao.TeacherDAO;
import entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * 显示所有教师
 * @author ZYZ
 *
 */
public class ListTeaAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		TeacherDAO dao=new TeacherDAO();
		try {
			List<Teacher> teachers= dao.findAll();
			request.setAttribute("teachers", teachers);
			//添加显示所有教师的jsp
			request.getRequestDispatcher("admin/list_alltea.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
