<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员角色</title>
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/css/header.css">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/css/footer.css">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/css/main.css">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/css/leftnav.css">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/css/menu.css">
</head>
<body>
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="../admin/menu_admin.jsp"></jsp:include>
		<jsp:include page="../admin/welcome_admin.jsp"></jsp:include>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>