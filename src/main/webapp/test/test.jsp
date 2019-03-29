<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/footer.css">
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/font-awesome.min.css">
<link rel="stylesheet" href="../css/leftnav.css">
<link rel="stylesheet" href="../css/menu.css">
</head>
<body>
	<jsp:include page="../indexpage/header.jsp"></jsp:include>
	<jsp:include page="../admin/menu_admin.jsp"></jsp:include>
	<div class="main" align="center">
		<h2>添加教师</h2>
		<form action="<%=request.getServletContext().getContextPath()%>/addtea" method="post">
			<table>
				<tr>
					<td>职工号：</td>
					<td><input name="tnumber" type="text"></td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><input name="tname" type="text"></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><input name="gender" type="text"></td>
				</tr>
				<tr>
					<td>类型：</td>
					<td><input name="type" type="text"></td>
				</tr>
			</table>
			<input type="submit" value="添加"> 
		</form>
	</div>
	<jsp:include page="../indexpage/footer.jsp"></jsp:include>
</body>
</html>