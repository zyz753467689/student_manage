package web;

import dao.StuDAO;
import dao.TeacherDAO;
import entity.Course;
import entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StuSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		String snumber= (String) session.getAttribute("username");
		StuDAO dao=new StuDAO();
		TeacherDAO dao2=new TeacherDAO();
		Map<String, Object>allCourse_info=new HashMap<String, Object>();
		try {
			List<Course> cours=dao.findcourse(snumber);
			//1 绑定数据
			request.setAttribute("cours", cours);
			//2 获得转发
			List<Teacher> teachers= dao2.findAll();
			for (Teacher teacher : teachers) {
				String type=teacher.getType();
				List<Teacher>partteachers= dao2.findPartTea(type);
				allCourse_info.put(type, partteachers);
			}
			System.out.println("课程及对应的老师："+allCourse_info);
			request.setAttribute("allCourse", allCourse_info);
			request.getRequestDispatcher("student/stusubject.jsp").forward(request, response);
			return ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
