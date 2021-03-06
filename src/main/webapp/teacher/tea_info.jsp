<%@page import="entity.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
    <link rel="stylesheet" href="<%=request.getServletContext().getContextPath()%>/css/header.css">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath()%>/css/footer.css">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath()%>/css/main.css">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath()%>/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath()%>/css/leftnav.css">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath()%>/css/menu.css">
<link rel="stylesheet" type="text/css" href="<%=request.getServletContext().getContextPath()%>/css/style.css" />
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
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						个人信息
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								信息ID
							</td>
							<td>
								职工号
							</td>
							<td>
								姓名
							</td>
							<td>
								性别
							</td>
							<td>
								类型
							</td>
							<td>
								操作
							</td>
						</tr>
						<%
						Teacher users=(Teacher)request.getAttribute("teacher");
							%>
							<tr class="row1">
								<td><%=users.getTid()%></td>
								<td><%=users.getTnumber()%></td>
								<td><%=users.getTname()%></td>
								<td><%=users.getGender()%></td>
								<td><%=users.getType()%></td>
								<td><a href="<%=request.getServletContext().getContextPath()%>/updatetea?tnumber=<%=session.getAttribute("username")%>">修改信息</a></td>
							</tr>
					</table>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				</div>
			</div>
		</div>	
		</div>
		<jsp:include page="../indexpage/footer.jsp"></jsp:include>
</body>
</html>