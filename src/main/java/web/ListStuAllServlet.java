package web;

import dao.Stu_InfoDAO;
import entity.Stu_Info;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * 查询所有学生
 * @author ZYZ
 *
 */
public class ListStuAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Stu_InfoDAO dao = new Stu_InfoDAO();
		List<Stu_Info> stu_lists = dao.findAll();
		request.setAttribute("stu_lists", stu_lists);
		request.getRequestDispatcher("admin/list_allstu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
