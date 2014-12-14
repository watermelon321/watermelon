<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>注册失败</title>
  <body>
    	注册失败、用户名已被占用清更改用户名、！ <br>
    	<a href="welcome.jsp">返回</a> 
  </body>
</html>
