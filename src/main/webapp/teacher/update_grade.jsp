<%@page import="entity.Grade"%>
<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>添加或修改成绩</title>
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
	<jsp:include page="menu_tea.jsp"></jsp:include>
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
					<h1>添加或修改成绩</h1>
					<form action="<%=request.getServletContext().getContextPath()%>/updategrade2" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<%
								Grade grade=(Grade)request.getAttribute("onegrade");
							%>
							<tr id="tr1">
								<td valign="middle" align="right">信息ID：</td>
								<td valign="middle" align="left"><input type="text"
									class="inputgri" name="gid" value="<%=grade.getGid()%>" readonly="readonly"/>(无修改权限)
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">学号：</td>
								<td valign="middle" align="left"><input type="text"
									class="inputgri" name="snumber" value="<%=grade.getSnumber()%>" readonly="readonly"/>(无修改权限)
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">课程：</td>
								<td valign="middle" align="left"><input type="text"
									class="inputgri" name="course" value="<%=grade.getCourse()%>" readonly="readonly"/>(无修改权限)
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">成绩：</td>
								<td valign="middle" align="left"><input type="text"
									class="inputgri" name="grade" value="<%=grade.getGrade()%>" />
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