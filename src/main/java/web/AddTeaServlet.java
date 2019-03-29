package web;

import dao.TeacherDAO;
import entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 添加教师
 * @author ZYZ
 *
 */
public class AddTeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String tnumber= request.getParameter("tnumber");
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
			dao.save(tea);
			request.setAttribute("teacher", tea);
			request.getRequestDispatcher("addusertea").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("服务器繁忙，请稍后重试！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
