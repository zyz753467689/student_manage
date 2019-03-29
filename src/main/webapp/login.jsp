<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="<%=request.getServletContext().getContextPath()%>/css/reign.css">
</head>
<body>
	<header>
		<div id="head">
			<img src="<%=request.getServletContext().getContextPath()%>/images/logo.png"> <span>自强</span> <span>弘毅</span> <span>求是</span>
			<span>创新</span>
		</div>
	</header>
	<article>
		<div id="form_div">
			<div>
				<form action="<%=request.getServletContext().getContextPath()%>/login" method="post">
					<h2>学生信息管理系统</h2>
					<div class="filed">
						<input type="text" name="username" placeholder="请输入您的用户名">
						<img src="<%=request.getServletContext().getContextPath()%>/images/yhm.png">
						<%
				String msg=(String)request.getAttribute("msg");
				%>
			<p style="color: red; font-size: 12px;"> <%=msg==null?"":msg%>
			</p>
					</div>
					<div class="filed">
						<input type="password" name="password" placeholder="请输入您的密码">
						<img src="<%=request.getServletContext().getContextPath()%>/images/mm.png">
					</div>
					<div id="auto_div">
						<input type="radio" name="role" value="admin" checked="checked"
							class="label"><label for="gly">管理员</label> <input
							type="radio" name="role" value="teacher" class="label"> <label
							for="js">教师</label> <input type="radio" name="role"
							value="student" class="label"> <label for="xs">学生</label>
					</div>
					<input type="submit" value="登录">
				</form>
			</div>
		</div>
	</article>
	<footer>
		<div id="foot" align="center">
			<span><a href="#">学生信息管理系统</a></span> <span><a href="#">选修课程</a></span>
			<span><a href="#">个人信息</a></span> <span><a href="#">更新信息</a></span> <span><a
				href="#">联系我们</a></span> <span>@九大代表大会</span>
		</div>
	</footer>
</body>
</html>