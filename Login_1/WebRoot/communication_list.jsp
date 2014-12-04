<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<style type="text/css">
<!--
body {
	background: url(star.jpg);
	background-size: cover;
	background-repeat: repeat-y;
	background-attachment: fixed;
	background-position: 50% 50%;
	background-repeat: no-repeat
}
-->
</style>
<head>
<title></title>
<body>
	<h1>
		<center><em>List</em></center>
	</h1>
	<br>
	<table border="1" bordercolor="#000000" width="1000" align="center">

		<c:forEach var="Curd_communication" items="${Curdlist}">
			<tr>
				<td>${Curd_communication.str1}</td>
				<td>${Curd_communication.str2}</td>
				<td>${Curd_communication.str3}</td>
				<td>${Curd_communication.str4}</td>
				<td>${Curd_communication.str5}</td>
				<td>${Curd_communication.str6}</td>
				<td>${Curd_communication.str7}</td>
				<td>${Curd_communication.str8}</td>
				<td>${Curd_communication.str9}</td>
				<td>${Curd_communication.str10}</td>

				<td><a href="delete1?str1=${Curd_communication.str1}">删除</a>
				</td>

			</tr>
		</c:forEach>
	</table>
	<a href="edituser.jsp">添加商品</a>
	<a href="search.jsp">查询商品</a>
	<a href="login_success.jsp">返回网站选择界面</a>
</body>
</head>
</html>

