package web;

import dao.TeacherDAO;
import entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateTeaInfo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int tid=Integer.parseInt(request.getParameter("tid"));
		String tnumber=request.getParameter("tnumber");
		String tname=request.getParameter("tname");
		String gender=request.getParameter("gender");
		String type=request.getParameter("type");
		TeacherDAO dao=new TeacherDAO();
		Teacher tea=new Teacher();
		tea.setTnumber(tnumber);
		tea.setTname(tname);
		tea.setGender(gender);
		tea.setType(type);
		try {
			dao.update(tea);
			request.getRequestDispatcher("listteainfo").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
