<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page contentType="text/html;charset=gbk"%>
<%@ page language="java" import="javax.servlet.jsp.jstl.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="a" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><center>
<h4>��ѡ����վ��</h4>
			<form action="list">
			
                <select value="cars"> 
                <option value="h">--</option> 
                <option value="taobao">�Ա�</option> </select>
               <input type="submit" value="�ύ">
                
</form></center>
	
</html>
