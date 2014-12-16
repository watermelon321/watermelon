<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
<style type="text/css">
a {
	display: block;
	position: absolute;
	right: 1%;
	top: 1%;
}
</style>
<noscript>
	<link rel="stylesheet"
		href="../../h5c3_127_tessellate/css/skel-noscript.css" />
	<link rel="stylesheet" href="../../h5c3_127_tessellate/css/style.css" />
	<link rel="stylesheet"
		href="../../h5c3_127_tessellate/css/style-wide.css" />
</noscript>

</head>
<body>
	<!-- Second -->
	<section id="second" class="main">
		<header>
			<div class="container">
				<h2>查看云端消息</h2>
				<p>
					登陆后抽取过的信息都会存储在您账号的云端<br /> 下面即您曾经抽取过的网站信息，假如您还没有使用过我们，请在上面上传HTML文件<br />
					完成您的第一次信息抽取
				</p>
			</div>
		</header>
		<div class="content dark style2">
			<div class="container">
				<div class="row">
					<div class="4u">
						<h2>
							<p>
								查看历史记录<br />
							</p>
						</h2>
						右侧是你曾经抽取过的网站信息记录<br /> 点击即可查看存储在云端的信息 <br />
					</div>
					<div class="8u">

						<a href="#third" class="button scrolly">淘宝</a>
						<p>
							<br />
						</p>
		<c:forEach var="Curd" items="${Curdlist}">
			
			   
				 <td><a href="search_history?str1=${Curd.str1}" class="button scrolly">${Curd.str1}</a></td>
				 
				 <p>
							<br />
						</p>
                 
			
		</c:forEach>
					</div>
	</section>

	<!-- Footer -->
	<section id="footer">
		<div class="copyright">
			<ul class="menu">
				<li>&copy; WaterMelon: All rights reserved.</li>
				<li>Design: SunZhen
				</li>
				<li>Thank You <a href="http://www.cssmoban.com/"
					target="_blank">f</a>
				</li>
			</ul>
		</div>
	</section>

</body>
</html>