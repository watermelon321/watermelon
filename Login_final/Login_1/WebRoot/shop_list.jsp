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
<body>
	<h1>
		<em><center>List</center></em>
	</h1>
	<br>
	<table border="1" bordercolor="#000000" width="1000" align="center">

		<c:forEach var="Curd" items="${Curdlist}">
			<tr>
				<td>${Curd.str1}</td>

				<td><a href="delete?str1=${Curd.str1}">删除</a>
				</td>

			</tr>
		</c:forEach>
	</table>
	<a href="edituser.jsp">添加商品</a>
	<a href="search.jsp">查询商品</a>
</body>
</head>
</html>
