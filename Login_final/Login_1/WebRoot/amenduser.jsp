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
    <h2>  修改商品 </h2>
    <form action="edit">
    <table>
       <tr>
          <td>商品名称</td>

             <td>

               <c:if test="${ empty Curd }"> <input type="text" name="baobeiname"></c:if>

               <c:if test="${! empty Curd }"> <input type="hidden" name="baobeiname" value="${Curd.baobeiname}">${Curd.baobeiname} </c:if>  

            </td>
       </tr>
       <tr>
          <td>订单号</td><td><input type="text" name="ordernumber" <c:if test="${! empty Curd }"> value="${Curd.ordernumber}" </c:if> ></td>
       </tr>
       <tr>
          <td>订单日期</td><td><input type="text" name="date" <c:if test="${! empty Curd }"> value="${Curd.date}" </c:if> ></td>
       </tr>
       <tr>
          <td>订单总价</td><td><input type="text" name="pricesum" <c:if test="${! empty Curd }"> value="${Curd.pricesum}" </c:if> ></td>
       </tr>
       
       <tr>
          <td>商品单价</td><td><input type="text" name="price" <c:if test="${! empty Curd }"> value="${Curd.price}" </c:if>></td>
       </tr>
       <tr>
          <td>商品数量</td><td><input type="text" name="quantity" <c:if test="${! empty Curd }"> value="${Curd.quantity}" </c:if>></td>
       </tr>
       <tr>
          <td><input type="submit" value="确定"></td><td><input type="reset" value="重置"></td>
       </tr>
    </table>
    </form>
  </body>
</html>