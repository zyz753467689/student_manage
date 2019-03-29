package web;

import dao.StuDAO;
import entity.Stu_Info;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
/**
 * 显示学生信息
 * @author ZYZ
 *
 */
public class ListStuInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		StuDAO dao=new StuDAO();
		HttpSession session=request.getSession();
		String snumber=(String)session.getAttribute("username");
		try {
			List<Stu_Info> stus=dao.findAll(snumber);
			//1 绑定数据
			session.setAttribute("stus", stus);
			//2 获得转发
			response.sendRedirect("student/liststu_info.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
