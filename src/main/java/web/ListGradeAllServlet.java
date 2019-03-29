package web;

import dao.GradeDAO;
import dao.Stu_InfoDAO;
import entity.Grade;
import entity.Stu_Info;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 查询所有成绩
 * @author ZYZ
 *
 */
public class ListGradeAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<Stu_Info, Grade> stu_grades=new HashMap<Stu_Info, Grade>();
		GradeDAO dao1=new GradeDAO();
		Stu_InfoDAO dao2=new Stu_InfoDAO();
		try {
			List<Grade> grades= dao1.find();
			System.out.println("gradeList:"+grades);
			for (Grade grade : grades) {
				String snumber= grade.getSnumber();
				Stu_Info stu=dao2.find(snumber);
				stu_grades.put(stu, grade);
			}
			System.out.println(stu_grades);
			request.setAttribute("all_grades", stu_grades);
			request.getRequestDispatcher("admin/list_allgrade.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
