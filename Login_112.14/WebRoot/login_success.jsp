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
<title>Tessellate by HTML5 UP</title>
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
<style type="text/css">
input {
	vertical-align: middle;
	margin: 0;
	padding: 0
}

.file-box {
	position: relative;
	width: 340px
}

.txt {
	height: 30px;
	border: 1px solid #cdcdcd;
	width: 180px;
	border-radius: 6px;
	color : #fff;
	background: rgba(255, 255, 255, 0.3) !important;
}

.btn {
	background-color: #FFF;
	border: 1px solid #CDCDCD;
	height: 30px;
	width: 70px;
	border-radius: 6px;
	color : #fff;
	background: rgba(255, 255, 255, 0.3) !important;
}

.file {
	position: absolute;
	top: 0;
	right: 80px;
	height: 24px;
	filter: alpha(opacity : 0);
	opacity: 0;
	width: 260px
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
<!-- Header -->
	<a href="index_final.jsp" class="login">注销</a> <a href="#second"
			class="register">查看历史记录</a>  
	<section id="header" class="dark">	
		<header>
			<h1>Welcome to WaterMelon</h1>
			<p>Click,and get information</p>
		</header>
		<footer>	 
			<a href="#first" class="button scrolly">Upload an HTML</a><br /><br />    
		</footer>
	</section>

	<!-- First -->
	<section id="first" class="main">
		<header>
			<div class="container">
				<h2>抽取你的个人信息，抽了又抽</h2>
				<p>你只需要上传你从个人电脑上保存下来的HTML文件，即可将其中的信息抽出</p>
			</div>
		</header>
		<div class="content dark style1 featured">
			<div class="container">
				<div class="row">
					<div class="4u">
						<section>
							<span class="feature-icon"><span class="fa fa-clock-o"></span>
							</span>
							<header>
								<h3>Efficient</h3>
							</header>
							<p>
								操作简单<br />只需上传HTML文件即可
							</p>
						</section>
					</div>
					<div class="4u">
						<section>
							<span class="feature-icon"><span class="fa fa-bolt"></span>
							</span>
							<header>
								<h3>Qucik Edition</h3>
							</header>
							<p>在Web界面即可直接进行处理</p>
						</section>
					</div>
					<div class="4u">
						<section>
							<span class="feature-icon"><span class="fa fa-cloud"></span>
							</span>
							<header>
								<h3>wCloud</h3>
							</header>
							<p>
								注册账号后即可将相关信息存储至云端<br />方便查看
							</p>
						</section>
					</div>
				</div>
				<div class="row">
					<div class="12u">
						<footer>
						<p> </p>
						<br />
						<br />
						<br />
						<p> </p>
						<div align="center">
							<div class="file-box">
								<form action="UploadAction" method="post" enctype="multipart/form-data">
									<input type='text' name='name' id='textfield' class='txt' />
									<input type='button' class='btn' value='浏览...' /> 
									<input
										type="file" name="upload" class="file" id="fileField"
										size="28"
										onchange="document.getElementById('textfield').value=this.value" />
									<input type="submit" name="submit" class="btn" value="上传" />
								</form>
							</div>
							</div>
						</footer>
					</div>
				</div>
			</div>
		</div>
	</section>
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


							<td><a href="search_history?str1=${Curd.str1}"
								class="button scrolly">${Curd.str1}</a>
							
                           <a href="delete_history?str1=${Curd.str1}"
								class="button scrolly">删除</a>
							</td>
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
				<li>&copy; Untitled. All rights reserved.</li>
				<li>Design: <a href="#/">HTML5 UP</a></li>
				<li>More Templates <a href="http://www.cssmoban.com/"
					target="_blank">f</a></li>
			</ul>
		</div>
	</section>

</body>
</html>