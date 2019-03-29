package web;

import dao.Stu_InfoDAO;
import entity.Stu_Info;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加学生
 * 
 * @author ZYZ
 *
 */
public class AddStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String snumber = request.getParameter("snumber");
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String profession = request.getParameter("profession");

		Stu_Info stu = new Stu_Info();
		stu.setSnumber(snumber);
		stu.setSname(sname);
		stu.setGender(gender);
		stu.setAge(age);
		stu.setProfession(profession);
		Stu_InfoDAO dao = new Stu_InfoDAO();
		dao.insert_stu(stu);
		request.setAttribute("student", stu);
		request.getRequestDispatcher("adduserstu").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
