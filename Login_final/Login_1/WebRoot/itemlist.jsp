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
		<tr>
			<td><center>订单号</center></td>
			<td><center>订单日期</center></td>
			<td><center>订单总价</center></td>
			<td><center>商品名称</center></td>
			<td><center>商品单价</center></td>
			<td><center>商品数量</center></td>
		</tr>
		<c:forEach var="Curd" items="${Curdlist}">
			<tr>
				<td>${Curd.tordernumber}</td>
				<td>${Curd.tdate}</td>
				<td>${Curd.tpricesum}</td>
				<td>${Curd.tbaobeiname}</td>
				<td>${Curd.tprice}</td>
				<td>${Curd.tquantity}</td>
				<td><a href="deletet?tbaobeiname=${Curd.tbaobeiname}">删除</a></td>
				
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
