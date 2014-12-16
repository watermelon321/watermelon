<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
	width: 200px;
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
.load6 {
  margin: 50px auto 0;
  width: 150px;
  text-align: center;
}
.load6 > div {
  width: 30px;
  height: 30px;
  background-color: rgba(255, 255, 255, 0.3) ;
  border-radius: 100%;
  display: inline-block;
  -webkit-animation: bouncedelay 1.4s infinite ease-in-out;
  animation: bouncedelay 1.4s infinite ease-in-out;
  -webkit-animation-fill-mode: both;
  animation-fill-mode: both;
}
.load6 .bounce1 {
  -webkit-animation-delay: -0.32s;
  animation-delay: -0.32s;
}
.load6 .bounce2 {
  -webkit-animation-delay: -0.16s;
  animation-delay: -0.16s;
}
@-webkit-keyframes bouncedelay {
  0%, 80%, 100% { -webkit-transform: scale(0.0) }
  40% { -webkit-transform: scale(1.0) }
}
@keyframes bouncedelay {
  0%, 80%, 100% {
    transform: scale(0.0);
    -webkit-transform: scale(0.0);
  } 40% {
    transform: scale(1.0);
    -webkit-transform: scale(1.0);
  }
}
</style>
<noscript>
	<link rel="stylesheet" href="css/skel-noscript.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-wide.css" />
</noscript>
</head>
<body>
	<!-- Header -->
	<a href="welcome_test.jsp" class="login">登录</a>
		  <a href="welcome.jsp" class="register">注册</a>
		  
	<section id="header" class="dark">
		
		<header>
			<h1>Welcome to WaterMelon</h1>
			<p>Click,and get information</p>
			<p>从今以后，查看个人信息不再繁琐</p>
		</header>
		<footer>
		 
			<a href="#first" class="button scrolly">开启旅程</a><br /><br />
                  
                  
		</footer>
	</section>

	<!-- First -->
	<section id="first" class="main">
		<header>
			<div class="container">
				<h2>使用说明</h2>
				<p>在您想抽取信息的网页上右键，选择“网页另存为”，得到一个HTML文件</p>
				<p>现在滑向下方的界面，点击“浏览”，选择上传文件，点击“上传”就可以咯！</p>
				<p>注册账号后，还可查看您的历史抽取记录</p>
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
								只需上传HTML文件即可<br />操作简单
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
							<p>在Web界面即可直接进行处理 　<br /> 更加直接</p>
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
						<div align="center">
							<div class="file-box">
								<form action="UploadAction" method="post" enctype="multipart/form-data">
								<input type='button' class='btn' value='浏览...' /> 
									<input type='text' name='name' id='textfield' class='txt'  required oninvalid="setCustomValidity('请选择要上传的文件');" oninput="setCustomValidity('');"/>
									<input
										type="file" name="upload" class="file" id="fileField"
										size="28"
										onchange="document.getElementById('textfield').value=this.value" />
										<p>		</p>
									<input  type="submit" id="submit" name="submit" class="btn" value="上传" />
								</form>
								<div id="load666" class="load6" style="visibility:hidden">
  									<div class="bounce1"></div>
  									<div class="bounce2"></div>
 									<div class="bounce3"></div>
								</div>
							</div>
							</div>
						</footer>
					</div>
				</div>
			</div>
		</div>
	</section>
	
		<!-- Footer -->
	<section id="footer">
		<div class="copyright">
			<ul class="menu">
				<li>&copy; Watermelon. All rights reserved.</li>
				<li>Design: Sun Zhen </li>
				<li>Thank You <a href="http://www.cssmoban.com/"
					target="_blank">f</a></li>
			</ul>
		</div>
	</section>
	
	
	<script language="javaScript">
		
		document.getElementById("submit").addEventListener('click',function(event){
			//event.preventDefault();
			if(document.getElementById("textfield").value){	
				document.getElementById("load666").style.visibility = 'visible';
			}
		});
	</script>

</body>
</html>
