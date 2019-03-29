package web;

import dao.GradeDAO;
import dao.Stu_InfoDAO;
import dao.Stu_TeaDAO;
import dao.TeacherDAO;
import entity.Grade;
import entity.Stu_Info;
import entity.Stu_Tea;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListPartStuGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String tnumber=(String) request.getSession().getAttribute("username");
		Stu_TeaDAO dao=new Stu_TeaDAO();
		GradeDAO dao2=new GradeDAO();
		TeacherDAO dao3=new TeacherDAO();
		Stu_InfoDAO dao4=new Stu_InfoDAO();
		Map<Stu_Info, Grade>one_grade=new HashMap<Stu_Info, Grade>();
		try {
			String course=dao3.findTea(tnumber).getType();
			List<Stu_Tea>sts= dao.findStu(tnumber);
			for (Stu_Tea stu : sts) {
				String snumber=stu.getSnumber();
				Stu_Info stu_Info=dao4.findOneStu(snumber);
				Grade grade=dao2.findOneCourse(snumber, course);
				one_grade.put(stu_Info, grade);
			}
			System.out.println("老师多带每个学生的成绩："+one_grade);
			request.setAttribute("one_grade", one_grade);
			request.getRequestDispatcher("teacher/list_grade.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
