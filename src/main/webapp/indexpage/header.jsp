<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
<div id=header-top>
<h2 align="left">学生信息管理系统</h2>
<img  src="<%=request.getServletContext().getContextPath() %>/images/h.jpg">
<span><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %></span>
<span id="username">欢迎${username }<a href="<%=request.getServletContext().getContextPath()%>/logout">注销</a></span>
</div>
</header>
</body>
</html>