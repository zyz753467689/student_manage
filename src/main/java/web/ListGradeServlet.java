package web;

import dao.StuDAO;
import entity.Grade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
/**
 * 显示学生个人成绩
 * @author ZYZ
 *
 */
public class ListGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		String snumber=(String)session.getAttribute("username");
		StuDAO dao=new StuDAO();
		try {
			List<Grade> grades=dao.findgrade(snumber);
			session.setAttribute("grades", grades);
			//2 获得转发
			response.sendRedirect("student/liststugrade.jsp");
			return ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
