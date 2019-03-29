<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教师菜单</title>
</head>
<body>
	<div class="menu">
		<div class="account-l fl">
			<a class="list-title" style="color: black">学生信息管理</a>
			<ul id="accordion" class="accordion">
				<li>
					<div class="link">
						<i class="fa fa-book"></i>教师管理<i
							class="fa fa-chevron-down"></i>
					</div>
					<ul class="submenu">
						<li id="shop"><a href="<%=request.getServletContext().getContextPath()%>/listteainfo">个人资料</a></li>
					</ul>
				</li>
				<li>
					<div class="link">
						<i class="fa fa-book"></i>学生管理<i
							class="fa fa-chevron-down"></i>
					</div>
					<ul class="submenu">
						<li id="buyerxunpanlist"><a href="<%=request.getServletContext().getContextPath()%>/liststu">查询学生</a></li>
					</ul>
				</li>
				<li>
					<div class="link">
						<i class="fa fa-book"></i>成绩管理<i
							class="fa fa-chevron-down"></i>
					</div>
					<ul class="submenu">
						<li id="buyerxunpanlist"><a href="<%=request.getServletContext().getContextPath()%>/listpartstugrade">添加成绩</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>

</body>
<script src="<%=request.getServletContext().getContextPath() %>/js/jquery.js"></script>
<script src='<%=request.getServletContext().getContextPath() %>/js/leftnav.js'></script>
</html>