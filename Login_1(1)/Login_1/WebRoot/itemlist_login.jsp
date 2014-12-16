<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Tessellate 1.0 by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->

<html>
<head>
<title>WaterMelon</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link
	href="http://fonts.googleapis.com/css?family=Roboto:100,100italic,300,300italic,400,400italic"
	rel="stylesheet" type="text/css" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="js/jquery.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/init.js"></script>
<noscript>
	<link rel="stylesheet" href="css/skel-noscript.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-wide.css" />
</noscript>
<style>
table { table-layout:fixed; word-break: break-all; word-wrap: break-word; }
.btn {
	background-color: #FFF;
	border: 1px solid #CDCDCD;
	height: 30px;
	width: 70px;
	border-radius: 6px;
	color : #fff;
	background: rgba(255, 255, 255, 0.3) !important;
}
.txt {
	background-color: #FFF;
	border: 1px solid #CDCDCD;
	height: 30px;
	width: 200px;
	border-radius: 6px;
	color : #fff;
	background: rgba(255, 255, 255, 0.3) !important;
}
</style>
</head>
<body>
	<section id="third" class="main">
		<div class="content dark style2">
			<div class="container"></div>
				<a href="refresh">返回上一页</a>
				<form action = "search_login">  
			请输入关键字：
				<input type="text" class = "txt " name="searchname">
				<input type="submit" class="btn" value="查询">
				</form>
				<p>		</p>
			<div class="button strolly" align="center" font-size :3pt>
			<h1>
		<em><center>List</center></em>
	</h1>
	<br>
	<table border="1" bordercolor="#000000" width="1500px" margin="0px atuto" style="font-size:12px">
		<c:forEach var="Curd" items="${Curdlist}">
			<tr>
			  <c:if test="${Curd.str1=='col1'}">  
				<c:if test="${Curd.str1!=NULL}">
                 <td><a href="delete_collog?str1=${Curd.str1}"></a></td>
               </c:if>
               <c:if test="${Curd.str2<=judge}">
                 <td><a href="delete_collog?str1=${Curd.str2}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str3<=judge}">
                 <td><a href="delete_collog?str1=${Curd.str3}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str4<=judge}">
                 <td><a href="delete_collog?str1=${Curd.str4}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str5<=judge}">
                 <td><a href="delete_collog?str1=${Curd.str5}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str6<=judge}">
                 <td><a href="delete_collog?str1=${Curd.str6}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str7<=judge}">
                 <td><a href="delete_collog?str1=${Curd.str7}">删除</a></td>
               </c:if>
				<c:if test="${Curd.str8<=judge}">
                 <td><a href="delete_collog?str1=${Curd.str8}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str9<=judge}">
                 <td><a href="delete_collog?str1=${Curd.str9}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str10<=judge}">
                 <td><a href="delete_collog?str1=${Curd.str10}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str11<=judge}">
                 <td><a href="delete_collog?str1=${Curd.str11}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str12<=judge}">
                 <td><a href="delete_collog?str1=${Curd.str12}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str13<=judge}">
                 <td><a href="delete_collog?str1=${Curd.str13}">删除</a></td>
               </c:if>
               <c:if test="${Curd.str14<=judge}">
                 <td><a href="delete_collog?str1=${Curd.str14}">删除</a></td>
               </c:if>
                <c:if test="${Curd.str15<=judge}">
                 <td><a href="delete_collog?str1=${Curd.str15}">删除</a></td>
               </c:if>
				</c:if>
				
				
               <c:if test="${Curd.str1!='col1'}">  
				   <c:if test="${Curd.str1!=''&&Curd.str1!=null}">
                      <td>${Curd.str1}</td>
                   </c:if>
                   <c:if test="${Curd.str2!=''&&Curd.str2!=null}">
                      <td>${Curd.str2}</td>
                   </c:if>
                   <c:if test="${Curd.str3!=''&&Curd.str3!=null}">
                      <td>${Curd.str3}</td>
                   </c:if>
                   <c:if test="${Curd.str4!=''&&Curd.str4!=null}">
                      <td>${Curd.str4}</td>
                   </c:if>
                   <c:if test="${Curd.str5!=''&&Curd.str5!=null}">
                      <td>${Curd.str5}</td>
                   </c:if>
                   <c:if test="${Curd.str6!=''&&Curd.str6!=null}">
                      <td>${Curd.str6}</td>
                   </c:if>
                   <c:if test="${Curd.str7!=''&&Curd.str7!=null}">
                      <td>${Curd.str7}</td>
                   </c:if>
                   <c:if test="${Curd.str8!=''&&Curd.str8!=null}">
                      <td>${Curd.str8}</td>
                   </c:if>
                   <c:if test="${Curd.str9!=''&&Curd.str9!=null}">
                      <td>${Curd.str9}</td>
                   </c:if>
                   <c:if test="${Curd.str10!=''&&Curd.str10!=null}">
                      <td>${Curd.str10}</td>
                   </c:if>
                   <c:if test="${Curd.str11!=''&&Curd.str11!=null}">
                      <td>${Curd.str11}</td>
                   </c:if>
                   <c:if test="${Curd.str12!=''&&Curd.str12!=null}">
                      <td>${Curd.str12}</td>
                   </c:if>
                   <c:if test="${Curd.str13!=''&&Curd.str13!=null}">
                      <td>${Curd.str13}</td>
                   </c:if>
                   <c:if test="${Curd.str14!=''&&Curd.str14!=null}">
                      <td>${Curd.str14}</td>
                   </c:if>
                   <c:if test="${Curd.str15!=''&&Curd.str15!=null}">
                      <td>${Curd.str15}</td>
                   </c:if>
				</c:if>
				<c:if test="${Curd.str1!='col1'}"> 
				<td><a href="deletelogrow?str1=${Curd.str1}">删除此行</a>
				</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</div>
</section>
</body>
</head>
</html>

