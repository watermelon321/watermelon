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
        <tr>
           <td><center>ordernumber</center></td><td><center>date</center></td><td><center>price</center></td><td><center>buyer</center></td><td><center>shipmentStatus</center></td><td><center>name</center></td>
        <td><center>author</center></td><td><center>seller</center></td>
        </tr>
        <c:forEach var="Curd" items="${Curdlist}">
            <tr>
               <td>${Curd.ordernumber}</td>
               <td>${Curd.date}</td>
               <td>${Curd.price}</td>
               <td>${Curd.buyer}</td>
               <td>${Curd.shipmentStatus}</td>
               <td>${Curd.name}</td>
               <td>${Curd.author}</td>
               <td>${Curd.seller}</td>
               <td><a href="delete3?name=${Curd.name}">删除</a></td>
              
            </tr>
        </c:forEach>
     </table>
     <a href="edituser.jsp">添加商品</a>
     <a href="search.jsp">查询商品</a>
     <a href="login_success.jsp">返回网站选择界面</a>

</body>
</head>
</html>

