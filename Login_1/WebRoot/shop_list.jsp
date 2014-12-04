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
				<td>${Curd.str2}</td>
				<td>${Curd.str3}</td>
				<td>${Curd.str4}</td>
				<td>${Curd.str5}</td>
				<td>${Curd.str6}</td>
				<td>${Curd.str7}</td>
				<td>${Curd.str8}</td>
				<td>${Curd.str9}</td>
				<td>${Curd.str10}</td>

				<td><a href="delete?str1=${Curd.str1}">删除</a>
				</td>

			</tr>
		</c:forEach>
		<td><a href="delete_col?str1=1aaa">删除</a>
			<td><a href="delete_col?str1=2aaa">删除</a>
			<td><a href="delete_col?str1=3aaa">删除</a>
			<td><a href="delete_col?str1=4aaa">删除</a>
			<td><a href="delete_col?str1=5aaa">删除</a>
			<td><a href="delete_col?str1=6aaa">删除</a>
			<td><a href="delete_col?str1=7aaa">删除</a>
			<td><a href="delete_col?str1=8aaa">删除</a>
			<td><a href="delete_col?str1=9aaa">删除</a>
			<td><a href="delete_col?str1=10aaa">删除</a>

		
	</table>
	<a href="edituser.jsp">添加商品</a>
	<a href="search.jsp">查询商品</a>
</body>
</head>
</html>
