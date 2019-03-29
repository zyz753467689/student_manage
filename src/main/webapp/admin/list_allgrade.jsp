<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询成绩</title>
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
		<jsp:include page="menu_admin.jsp"></jsp:include>
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
						所有成绩
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								学号
							</td>
							<td>
								姓名
							</td>
							<td>
								课程名
							</td>
							<td>
								专业
							</td>
							<td>
								成绩
							</td>
						</tr>
						<c:forEach items="${all_grades }" var="ag">
							<tr class="row1">
								<td>${ag.key.snumber }</td>
								<td>${ag.key.sname }</td>
								<td>${ag.value.course }</td>
								<td>${ag.key.profession }</td>
								<td>${ag.value.grade }</td>
							</tr>
						</c:forEach>
						
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