package web;

import dao.LoginDAO;
import entity.Role;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
/**
 * 登录
 * @author ZYZ
 *
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取用户输入的信息
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String usertype=request.getParameter("role");
		System.out.println(username+password+usertype);
		request.setAttribute("username", username);
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		/**
		 * 先查看用户是否存在
		 */
		LoginDAO loginDAO=new LoginDAO();	
		try{
			User user=loginDAO.find(username);
			if(user==null) {
				//用户不存在，返回登录页面
				request.setAttribute("msg", "用户不存在");
				request.getRequestDispatcher("login.jsp")
				.forward(request, response);
				System.out.println("用户不存在");
			}else {
				System.out.println("用户存在");
				//用户存在，判断密码是否正确
				String pw=user.getPassword();
				if(pw.equals(password)) {
					//密码正确	
					//再判断登录用户的身份
					Role role=loginDAO.selectrole(user.getRid());
					int rid=role.getRid();
					if("student".equals(usertype)&&rid==1) {					
						//重定向到学生首页
						response.sendRedirect("student");
						System.out.println("进入学生页面");
					}else if("teacher".equals(usertype)&&rid==2) {
						//重定向到老师首页
						response.sendRedirect("teacher");
					}else if("admin".equals(usertype)&&rid==3) {
						//重定向到管理员首页
						response.sendRedirect("admin");
					}else {
						//用户名和密码都正确，但是登录身份选错了
						request.setAttribute("msg", "登录身份选择错误！");
						request.getRequestDispatcher("login.jsp")
						.forward(request, response);
					}
				}else {
					//密码错误，返回到登录页面
					request.setAttribute("msg", "密码错误");
					request.getRequestDispatcher("login.jsp")
					.forward(request, response);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().println("系统繁忙!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
