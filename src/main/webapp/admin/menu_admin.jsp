<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员菜单</title>
</head>
<body>
	<div class="menu">
		<div class="account-l fl">
			<a class="list-title" style="color: black">学生信息管理</a>
			<ul id="accordion" class="accordion">
				<li>
					<div class="link">
						<i class="fa fa-lock"></i>学生管理<i
							class="fa fa-chevron-down"></i>
					</div>
					<ul class="submenu">
						<li id="shop"><a href="<%=request.getServletContext().getContextPath()%>/admin/add_stu.jsp">添加学生</a></li>
						<li id="shop"><a href="<%=request.getServletContext().getContextPath()%>/liststuall">查询学生</a></li>
					</ul>
				</li>
				<li>
					<div class="link">
						<i class="fa fa-lock"></i>教师管理<i
							class="fa fa-chevron-down"></i>
					</div>
					<ul class="submenu">
						<li id="buyerxunpanlist"><a href="<%=request.getServletContext().getContextPath()%>/admin/add_tea.jsp">添加教师</a></li>
						<li id="buyerxunpanlist"><a href="<%=request.getServletContext().getContextPath()%>/listteaall">查询教师</a></li>
					</ul>
				</li>
				<li>
					<div class="link">
						<i class="fa fa-lock"></i>成绩管理<i
							class="fa fa-chevron-down"></i>
					</div>
					<ul class="submenu">
						<li id="buyerxunpanlist"><a href="<%=request.getServletContext().getContextPath()%>/listgradeall">成绩查询</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>

</body>
<script src="<%=request.getServletContext().getContextPath() %>/js/jquery.js"></script>
<script src='<%=request.getServletContext().getContextPath() %>/js/leftnav.js'></script>
</html>