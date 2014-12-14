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
			  <c:if test="${Curd.str1=='col1'}">  
				<c:if test="${Curd.str1!=NULL}">
                 <td><a href="delete_col?str1=${Curd.str1}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str2<=judge}">
                 <td><a href="delete_col?str1=${Curd.str2}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str3<=judge}">
                 <td><a href="delete_col?str1=${Curd.str3}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str4<=judge}">
                 <td><a href="delete_col?str1=${Curd.str4}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str5<=judge}">
                 <td><a href="delete_col?str1=${Curd.str5}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str6<=judge}">
                 <td><a href="delete_col?str1=${Curd.str6}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str7<=judge}">
                 <td><a href="delete_col?str1=${Curd.str7}">删除</a></td>
               </c:if>
				<c:if test="${Curd.str8<=judge}">
                 <td><a href="delete_col?str1=${Curd.str8}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str9<=judge}">
                 <td><a href="delete_col?str1=${Curd.str9}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str10<=judge}">
                 <td><a href="delete_col?str1=${Curd.str10}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str11<=judge}">
                 <td><a href="delete_col?str1=${Curd.str11}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str12<=judge}">
                 <td><a href="delete_col?str1=${Curd.str12}">删除</a></td>
               </c:if>
				</c:if>
				
				
               <c:if test="${Curd.str1!='col1'}">  
				   <c:if test="${Curd.str1!=NULL}">
                      <td>${Curd.str1}</td>
                   </c:if>
                   <c:if test="${Curd.str2!=NULL}">
                      <td>${Curd.str2}</td>
                   </c:if>
                   <c:if test="${Curd.str3!=NULL}">
                      <td>${Curd.str3}</td>
                   </c:if>
                   <c:if test="${Curd.str4!=NULL}">
                      <td>${Curd.str4}</td>
                   </c:if>
                   <c:if test="${Curd.str5!=NULL}">
                      <td>${Curd.str5}</td>
                   </c:if>
                   <c:if test="${Curd.str6!=NULL}">
                      <td>${Curd.str6}</td>
                   </c:if>
                   <c:if test="${Curd.str7!=NULL}">
                      <td>${Curd.str7}</td>
                   </c:if>
                   <c:if test="${Curd.str8!=NULL}">
                      <td>${Curd.str8}</td>
                   </c:if>
                   <c:if test="${Curd.str9!=NULL}">
                      <td>${Curd.str9}</td>
                   </c:if>
                   <c:if test="${Curd.str10!=NULL}">
                      <td>${Curd.str10}</td>
                   </c:if>
                   <c:if test="${Curd.str11!=NULL}">
                      <td>${Curd.str11}</td>
                   </c:if>
                   <c:if test="${Curd.str12!=NULL}">
                      <td>${Curd.str12}</td>
                   </c:if>
				</c:if>
				<td><a href="delete?str1=${Curd.str1}">删除此行</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="edituser.jsp">添加商品</a>
	<a href="search.jsp">查询商品</a>
</body>
</head>
</html>
