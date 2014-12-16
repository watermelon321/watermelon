<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
     <title></title>
  </head>
  <body>
     <h1><center><em>List</em></center></h1><br>
     <table border="1" bordercolor="#000000" width="1000" align="center">
        
        <c:forEach var="Curd_S" items="${Curdlist}">
            <tr>
               <td>${Curd_S.str1}</td>
               
               <td><a href="delete2?str1=${Curd_S.str1}">删除</a></td>
               
            </tr>
        </c:forEach>
     </table>
     <a href="edituser.jsp">添加商品</a>
     <a href="search.jsp">查询商品</a>
  </body>
</html>
