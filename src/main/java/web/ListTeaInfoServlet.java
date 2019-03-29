package web;

import dao.TeacherDAO;
import entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 显示教师个人信息
 * @author ZYZ
 *
 */
public class ListTeaInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String tnumber = (String) request.getSession().getAttribute("username");
		TeacherDAO teadao = new TeacherDAO();
		try {
			Teacher teainfo = teadao.findTea(tnumber);
			Teacher teacher = new Teacher();
			teacher.setTid(teainfo.getTid());
			teacher.setTnumber(teainfo.getTnumber());
			teacher.setTname(teainfo.getTname());
			teacher.setGender(teainfo.getGender());
			teacher.setType(teainfo.getType());
			teacher.setCount(teainfo.getCount());
			request.setAttribute("teacher", teacher);
			request.getRequestDispatcher("teacher/tea_info.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
