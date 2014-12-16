 <%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'edituser.jsp' starting page</title>
  </head>
  
  <body> 
    <form action="search">
    <table> 
       <tr>
          <td>输入查询商品名：</td><td><input type="text" name="baobeiname" <c:if test="${! empty Curd }"> value="${Curd.}" </c:if> ></td>
       </tr>
       <tr>
          <td><input type="submit" value="查询"></td>
       </tr>
    </table>
    </form>
    <h1>商品列表</h1>
     <table>
        <tr>
           <td>订单号</td><td>订单日期</td><td>订单总价</td><td>商品名称</td><td>商品单价</td><td>商品数量</td>
        </tr>
        <c:forEach var="Curd" items="${Curdlist}">
            <tr>
               <td>${Curd.ordernumber}</td>
               <td>${Curd.date}</td>
               <td>${Curd.pricesum}</td>
               <td>${Curd.baobeiname}</td>
               <td>${Curd.price}</td>
               <td>${Curd.quantity}</td>
            </tr>
        </c:forEach>
     </table>
  </body>
</html>