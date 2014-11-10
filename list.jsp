<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
     <title></title>
  </head>
  <body>
     <h1>商品列表</h1>
     <table>
        <tr>
           <td>订单号</td><td>订单日期</td><td>订单总价</td><td>商品名称</td><td>商品单价</td><td>商品数量</td>
        </tr>
        <c:forEach var="student" items="${studentlist}">
            <tr>
               <td>${student.ordernumber}</td>
               <td>${student.date}</td>
               <td>${student.pricesum}</td>
               <td>${student.baobeiname}</td>
               <td>${student.price}</td>
               <td>${student.quantity}</td>
               <td><a href="delete?baobeiname=${student.baobeiname}">删除</a></td>
               <td><a href="amenduser.jsp?baobeiname=${student.baobeiname}">修改</a></td>
            </tr>
        </c:forEach>
     </table>
     <a href="edituser.jsp">添加商品</a>
     <a href="search.jsp">查询商品</a>
  </body>
</html>
