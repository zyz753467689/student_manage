package web;

import dao.Stu_InfoDAO;
import dao.Stu_TeaDAO;
import entity.Stu_Info;
import entity.Stu_Tea;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * 显示教师所带学生
 * @author ZYZ
 *
 */
public class ListStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Stu_Info> stu_infos = new ArrayList<Stu_Info>();
		HttpSession session = request.getSession();
		String tnumber = (String) session.getAttribute("username");
		Stu_TeaDAO dao = new Stu_TeaDAO();
		Stu_InfoDAO dao2=new Stu_InfoDAO();
		List<Stu_Tea> sts=new ArrayList<Stu_Tea>();
		try {
			sts = dao.findStu(tnumber);
			for(Stu_Tea stu : sts) {
				Stu_Info stu_info = dao2.find(stu.getSnumber());
				stu_infos.add(stu_info);
			} 
			System.out.println("sts:"+sts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("stu_infos", stu_infos);
		request.getRequestDispatcher("teacher/list_stu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
