package web;

import dao.StuDAO;
import entity.Stu_Info;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateStuinfo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取用户输入的信息
		String sid=request.getParameter("sid");
		String snumber=request.getParameter("snumber");
		String sname=request.getParameter("sname");
		String gender=request.getParameter("gender");
		String age=request.getParameter("age");
		String profession=request.getParameter("profession");
		//创建用户信息对象
		Stu_Info user=new Stu_Info();
		user.setSid(Integer.parseInt(sid));
		user.setSnumber(snumber);
		user.setSname(sname);
		user.setGender(gender);
		user.setAge(age);
		user.setProfession(profession);
		//创建dao
		StuDAO dao=new StuDAO();
		try {
			dao.updatestuinfo(user);
			System.out.println("修改成功");
			//重定向到用户列表
			request.getRequestDispatcher("liststuinfo").forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
