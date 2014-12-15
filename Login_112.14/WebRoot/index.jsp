<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Blactro Template</title>
<meta name="keywords"
	content="blactro template, free html css template, jquery, templatemo" />
<meta name="description"
	content="Blactro is free template by templatemo.com" />

<link href="templatemo_style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.scrollTo-min.js"></script>
<script type="text/javascript" src="js/jquery.localscroll-min.js"></script>
<script type="text/javascript" src="js/init.js"></script>
<style type="text/css">
.content {
	width: 180px;
	height: 100px;
	margin: 150px auto;
	padding: 30px 30px;
	background: rgba(255, 255, 255, 0) !important;
	filter: Alpha(opacity =         60);
	background: #fff; /*　使用IE专属滤镜实现IE背景透明*/
}
</style>

<link rel="stylesheet" href="css/slimbox2.css" type="text/css"
	media="screen" />
<script type="text/JavaScript" src="js/slimbox2.js"></script>


<!-- Timestamp: 1236819900 -->
</head>
<body>
	<div id="templatemo_header" div style="color:#000">
		<div id="site_title" div style="color:#000">
			<a href="#home"><span>WaterMelon</span> </a>
		</div>
		<a class="site_bg" href="http://cn.mystockphoto.com"
			title="cn.mystockphoto.com"></a>
	</div>
	<div id="templatemo_main">
		<div id="content">
			<div id="home" class="section">

				<div class="box home_box2 color1">
					<div class="padding_30">
						<h2>
							<a href="#about">Login Or Register</a>
						</h2>
						<p>If u have an account,or it's the first time u visit our
							website, click here!</p>
					</div>
				</div>

				<div class="box home_box1 color3 no_mr">
					<p></p>
					<p></p>
					<p></p>
					<p></p>
					<h2>
						<a href="#quiry">Obtain The
						<p>          </p> 
						Historical Records</a>
					</h2>
					</a>
				</div>

				<div class="box home_box1 color2">
					<p></p>
					<p></p>
					<p></p>
					<p></p>
					<h2>
						<a href="#portfolio"> Shopping List</a>
					</h2>

				</div>

				<div class="box home_box1 color8">
					<p></p>
					<p></p>
					<p></p>
					<p></p>
					<h2>
						<a href="#services"> Communication
						<p>          </p>
						List</a>
					</h2>

				</div>

				<div class="box home_box1 color6 no_mr">
					<div class="padding_10">
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<h2>
							<a href="#testimonial">Score List</a>
						</h2>

					</div>
				</div>

				<div class="box home_box1 color7">
					<div id="s">
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<h2>
							<a href="#portfolio"> Amazon</a>
						</h2>

					</div>
				</div>

				<div class="box home_box1 color9">
					<p></p>
					<p></p>
					<p></p>
					<p></p>
					<h2>
						<a href="#Taobao"> Taobao</a>
					</h2>
				</div>

				<div class="box home_box1 color5 no_mr">
					<a href="welcome_test.jsp"><img src="images/contact.jpg" alt="Contact" />
					</a>
				</div>

			</div>
			<!-- END of home -->

			<div class="section section_with_padding" id="about">
				<h2>
					<em>Login and Register</em>
				</h2>
				<div class="img_border img_fl">
					<a href="welcome_test.jsp"><img src="images/Login.jpg"
						alt="image 1" /> </a>
				</div>
				<div class="half right">
					<p>
						<em>Tips:</em>
					</p>
					<p>
						<em>1.If you don't have an account,you should register first.</em>
					</p>
					<p>
						<em>2.The account must be consist of letters and numbers.</em>
					</p>
					<p>
						<em>3.The code must be not less than seven numbers or letters
							or both </em>
					</p>
					<p>
						<em>Now!Click the pattern below to register</em>
					</p>
				</div>
				<div class="clear h40"></div>
				<div class="img_border img_fr">
					<a href="http://www.templatemo.com/page/1" target="_parent"
						rel="nofollow"> <a href="welcome.jsp"><img
							src="images/Registor.jpg" alt="image 2" /> </a>
				</div>
				<div class="half left">
					<p>
						<em>Tips:</em>
					</p>
					<p>
						<em>1.The user name must consist of letters and numbers.</em>
					</p>
					<p>
						<em>2.The code must be not less than seven numbers or letters
							or both </em>
					</p>
					<p>
						<em>Now!Click the pattern above to register! </em>
					</p>
				</div>

				<a href="#home" class="slider_nav_btn home_btn">home</a> <a
					href="#home" class="slider_nav_btn previous_btn">Previous</a> <a
					href="#services" class="slider_nav_btn next_btn">Next</a>

			</div>

			<div class="section section_with_padding" id="quiry">


				<img src="images/jilu.jpg" alt="image 2" /> <a href="#home"
					class="slider_nav_btn home_btn">home</a> <a href="#home"
					class="slider_nav_btn previous_btn">Previous</a> <a
					href="#services" class="slider_nav_btn next_btn">Next</a>

			</div>


			<div class="section section_with_padding" id="services">
				<div class="warp">
					<div class="content">
						<s:form action="Upload_communication" method="post"
							enctype="multipart/form-data">
							<p>services</p>
							<p></p>
							<p></p>
							<s:file label="上传" theme="simple" name="upload" />
							<s:submit value="上传" />
						</s:form>
					</div>
				</div>
				<a href="#home" class="slider_nav_btn home_btn">home</a> 
				<a href="#home" class="slider_nav_btn previous_btn">Previous</a>
				<a href="#amazon" class="slider_nav_btn next_btn">Next</a>
			</div>

			<div class="section section_with_padding" id="Taobao">
				<div class="warp">
					<div class="content">
						<s:form action="UploadAction" method="post"
							enctype="multipart/form-data">
							<p></p>
							<p></p>
							<p></p>
							<s:file label="上传" theme="simple" name="upload" />
							<s:submit value="上传" />
						</s:form>
					</div>
				</div>
                    <img src="images/click.jpg" alt="image" /></a>	 
			</div>

			<div class="section section_with_padding" id="amazon">
				<div class="warp">
					<div class="content">
						<s:form action="UploadAction" method="post"
							enctype="multipart/form-data">
							<p></p>
							<p></p>
							<p></p>
							<s:file label="上传" theme="simple" name="upload" />
							<s:submit value="上传" />
						</s:form>
					</div>
				</div>
			</div>

			<div class="section section_with_padding" id="portfolio">
				<ul id="gallery">
					<div class="warp">
						<div class="content">
							<s:form action="Uploadshop" method="post"
								enctype="multipart/form-data">
								<p></p>
								<p></p>
								<p></p>
								<s:file label="上传" theme="simple" name="upload" />
								<s:submit value="上传" />
							</s:form>
						</div>
					</div>

				</ul>

				<a href="#home" class="slider_nav_btn home_btn">home</a> <a
					href="#home" class="slider_nav_btn previous_btn">Previous</a> <a
					href="#testimonial" class="slider_nav_btn next_btn">Next</a>

			</div>
			<div class="section section_with_padding" id="testimonial">
				<div class="warp">
					<div class="content">
						<s:form action="UploadS" method="post"
							enctype="multipart/form-data">
							<p></p>
							<p></p>
							<p></p>
							<s:file label="上传" theme="simple" name="upload" />
							<s:submit value="上传" />
						</s:form>
					</div>
				</div>
				<a href="#home" class="slider_nav_btn home_btn">home</a> <a
					href="#home" class="slider_nav_btn previous_btn">Previous</a>
				<a href="#contact" class="slider_nav_btn next_btn">Next</a>
			</div>

	<div id="templatemo_footer">
		<p>
			Copyright © SE-Watermelon | <a rel="nofollow"
				href="http://www.templatemo.com/preview/templatemo_381_blactro"
				target="_parent">Blacktro</a> by <a rel="nofollow"
				href="http://www.templatemo.com" target="_parent">SunZhen</a>
		</p>
	</div>

</body>
<script type='text/javascript' src='js/logging.js'></script>
</html>