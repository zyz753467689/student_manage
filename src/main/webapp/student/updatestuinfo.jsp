<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@page import="entity.Stu_Info"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改个人信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getServletContext().getContextPath()%>/css/header.css">
<link rel="stylesheet"
	href="<%=request.getServletContext().getContextPath()%>/css/footer.css">
<link rel="stylesheet"
	href="<%=request.getServletContext().getContextPath()%>/css/main.css">
<link rel="stylesheet"
	href="<%=request.getServletContext().getContextPath()%>/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getServletContext().getContextPath()%>/css/leftnav.css">
<link rel="stylesheet"
	href="<%=request.getServletContext().getContextPath()%>/css/menu.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getServletContext().getContextPath()%>/css/style.css" />
</head>
<body>
	<jsp:include page="../indexpage/header.jsp"></jsp:include>
	<jsp:include page="menu_stu.jsp"></jsp:include>
	<div class="main">
		<div id="wrap">
			<div id="top_content">
				<div id="header">
					<div id="rightheader">
						<p>
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
						</h1>
					</div>
					<div id="navigation"></div>
				</div>
				<div id="content">
					<p id="whereami"></p>
					<h1>修改用户</h1>
					<form action="<%=request.getServletContext().getContextPath()%>/updatestuinfo" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<%
								Stu_Info user=(Stu_Info)session.getAttribute("users");
							%>
							<tr id="tr1">
								<td valign="middle" align="right">信息ID：</td>
								<td valign="middle" align="left"><input type="text"
									class="inputgri" name="sid" value="<%=user.getSid()%>" readonly="readonly"/>(无修改权限)
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">学号：</td>
								<td valign="middle" align="left"><input type="text"
									class="inputgri" name="snomber" value="<%=user.getSnumber()%>" readonly="readonly"/>(无修改权限)
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">姓名：</td>
								<td valign="middle" align="left"><input type="text"
									class="inputgri" name="sname" value="<%=user.getSname()%>" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">性别：</td>
								<td valign="middle" align="left"><input type="text"
									class="inputgri" name="gender" value="<%=user.getGender()%>" readonly="readonly"/>(无修改权限)</td>
							</tr>
							<tr>
								<td valign="middle" align="right">年龄：</td>
								<td valign="middle" align="left"><input type="text"
									class="inputgri" name="age" value="<%=user.getAge()%>" /></td>
							</tr>
							<tr>
								<td valign="middle" align="right">专业：</td>
								<td valign="middle" align="left"><input type="text"
									class="inputgri" name="profession" value="<%=user.getProfession()%>" readonly="readonly"/>(无修改权限)
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" value="确认修改" style="background-color: #74A8F5"
							onclick="return confirm('确认修改吗?')"/>
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
			</div>
		</div>
	</div>
	<jsp:include page="../indexpage/footer.jsp"></jsp:include>
</body>
</html>