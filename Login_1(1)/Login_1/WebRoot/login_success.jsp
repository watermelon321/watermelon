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
	width: 250px;
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
.div_show
{
   display:block;
}
.div_hide
{
   display:none;
}
</style>
<script language="javaScript">
function showHideText()
{
  document.getElementById("div_text").className="div_show";
}
</script>
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
	

	<!-- First -->
	<section id="first" class="main">
		<div class="content dark style1 featured">
			<div class="container">
				<div class="row">
					<div class="4u">
						<section>
						<a href="index_final.jsp" class="login">退出</a> <a href="#second"
			class="register">查看历史记录</a>  	
						</section>
					</div>
			
					
				</div>
				<div class="row">
					<div class="12u">
						<div align="center">
							<div class="file-box">
								<form action="UploadAction_login_origin" method="post" enctype="multipart/form-data">
									<input type='button' class='btn' value='浏览...' /> 
									<input type='text' name='name' id='textfield' class='txt' required oninvalid="setCustomValidity('请选择要上传的文件');" oninput="setCustomValidity('');"/>						
									<input
										type="file" name="upload" class="file" id="fileField"
										size="28"
										onchange="document.getElementById('textfield').value=this.value" />
										<br />
										<P>  </p>
									<input  type="submit" id="submit" name="submit" class="btn" value="上传" />
								</form>
								<div id="load666" class="load6" style="visibility:hidden">
  									<div class="bounce1"></div>
  									<div class="bounce2"></div>
 									<div class="bounce3"></div>
								</div>
							</div>
							</div>
					
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Second -->
	<section id="second" class="main">
		<header>
			<div class="container">
				<h2>使用说明</h2>
				<p>在想抽取信息的网页上右键,选择“网页另存为”,得到HTML文件,点击“浏览”,选择上传文件,点击“上传”就可以咯！</p>
				<p>点击页面右上角“查看历史消息”或向下滑动页面都可以查看您的历史记录</p>
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