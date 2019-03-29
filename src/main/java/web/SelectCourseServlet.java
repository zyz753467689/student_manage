package web;

import dao.CourseDAO;
import dao.GradeDAO;
import dao.Stu_TeaDAO;
import dao.TeacherDAO;
import entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
/**
 * 学生选课(成绩默认为0)
 * @author ZYZ
 *
 */
public class SelectCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String snumber=(String) session.getAttribute("username");
		TeacherDAO dao=new TeacherDAO();
		CourseDAO dao2=new CourseDAO();
		GradeDAO dao3=new GradeDAO();
		Stu_TeaDAO dao4=new Stu_TeaDAO();
		String tnumber="";
		try {
			List<Teacher> teachers=dao.findAllCourse();
			for (Teacher teacher : teachers) {
				String type=teacher.getType();
				tnumber=request.getParameter(type);
				if(tnumber!=null) {
					dao2.addCourse(snumber, tnumber, type);
					dao3.addGrade(snumber, type);
					dao4.addRel(snumber, tnumber);
				}
			}
			request.getRequestDispatcher("stusubject").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
