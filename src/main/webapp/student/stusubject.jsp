<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="dao.StuDAO,entity.Course,java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生选课</title>
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
					<h1>学生选课</h1>
					<form action="<%=request.getServletContext().getContextPath()%>/selectcourse" method="post">
					<c:choose>
						<c:when test="${fn:length(cours)>0 }">
							<table class="table">
								<caption>已选课程</caption>
								<tr class="table_header">
									<td>已选课程名</td>
									<td>教师姓名</td>
								</tr>
								<%
						List<Course> users=(List<Course>)request.getAttribute("cours");
						for(int i=0;i<users.size();i++){
							Course user=users.get(i);
							%>
								<tr class="row<%=i%2+1%>">
									<td><%=user.getCname()%></td>
									<% 
								StuDAO dao=new StuDAO();
								%>
									<td><%=dao.findtname(user.getTnumber())%></td>
								</tr>
								<%
						}
						%>
							</table>
						</c:when>
						<c:otherwise>
						<table class="table">
								<tr class="table_header">
									<td>可选课程名</td>
									<td>教师姓名</td>
								</tr>
							<c:forEach items="${allCourse }" var="all">
								<tr class="row1">
									<td>${all.key }</td>
									<td>
										<c:forEach items="${all.value }" var="teas">
											${teas.tname }<input type="radio" value="${teas.tnumber }" name="${all.key }">
										</c:forEach>
									</td>
								</tr>
							</c:forEach>
						</table>
						<input type="submit" value="确认选课" >
						</c:otherwise>
					</c:choose>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../indexpage/footer.jsp"></jsp:include>
</body>
</html>