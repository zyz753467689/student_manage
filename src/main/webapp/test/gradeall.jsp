<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/css/header.css">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/css/footer.css">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/css/main.css">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/css/leftnav.css">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/css/menu.css">
</head>
<body>
		<jsp:include page="../indexpage/header.jsp"></jsp:include>
		<jsp:include page="../admin/menu_admin.jsp"></jsp:include>
		<div class="main">
			<table>
				<tr><th>学生姓名</th><th>课程</th><th>成绩</th></tr>
				<c:forEach items="${grades }" var="grade">
					<tr>
						<td>${grade.key.sname }</td>
						<td>${grade.value.course }</td>
						<td>${grade.value.grade }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<jsp:include page="../indexpage/footer.jsp"></jsp:include>
</body>
</html>