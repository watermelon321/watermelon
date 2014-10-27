<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>fileTag</title>
</head>
  
  <body>
    文件路径:<s:property value="savePath" />/images/<br> 
               <s:property value="#request.onload" /> <br>
               <img src="<s:property value='#request.onload'/>\0010.jpg.gif"> 
       <!-- 根据上传文件的文件名，在页面上显示上传的图片 -->   
         文件为：<s:property value="uploadFileName"/><br>
  </body>
</html>
