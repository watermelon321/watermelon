<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>WaterMelon</title> 
<script type="text/javascript">
function insertManager() {
	var username =document.managerForm.username.value;
         var password = document.managerForm.Password.value;
         var newpassword = document.managerForm.re_Password.value;
  
   if(! /^\w+$/.test( username ) ){
       alert("用户名只能包含英文字母，数字");
       managerForm.username.focus();
       return false;
   }
   else if(password.length<6 || password.length>18){
   	   alert("密码合法长度为6-18个字符");
   	   managerForm.password.focus();
   	   return false;
   }   	
   
   else if(newpassword==""){
	   window.alert("请输入确认密码");
	   managerForm.newpassword.focus();
	   return false;
	   }
	   
   else if(password!=newpassword){
	  window.alert("您输入的新密码与确认密码确认不一致");
	  managerForm.newpasswod.focus();
	  return false;  
   }
return true;
}

</script>
<style type="text/css">
.warp{ background:  border:1px solid #ccc;}
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

.wrap {
	width:360px; height:200px; margin:250px auto; padding:30px 30px; background:rgba(255, 255, 255, 0.6)!important;
filter:Alpha(opacity=60); background:#fff; /*　使用IE专属滤镜实现IE背景透明*/ }

.loginForm {
	z-index: 0;
	background-color: #000;
	height: 200px;
	width: 380px;
}
 
.content { width:360px; height:150px; margin:380px auto; padding:30px 30px; background:rgba(255, 255, 255, 0.6)!important;
filter:Alpha(opacity=60); background:#fff; /*　使用IE专属滤镜实现IE背景透明*/ }
.content p{ position:relative;} /*实现IE文字不透明*/

.loginForm:before {
	content: '';
	position: absolute;
	z-index: -1;
	border: 1px dashed #CCC;
	top: 5px;
	bottom: 5px;
	left: 5px;
	right: 5px;
	box-shadow: 0 0 0 1px #FFF;
}

.loginForm h1 {
	text-shadow: 0 1px 0 rgba(255, 255, 255, .7), 0px 2px 0
		rgba(0, 0, 0, .5);
	text-transform: uppercase;
	text-align: center;
	color: #666;
	line-height: 3em;
	margin: 16px 0 20px 0;
	letter-spacing: 4px;
	font: normal 26px/1 Microsoft YaHei, sans-serif;
}

fieldset {
	border: none;
	padding: 10px 10px 0;
}

fieldset input[type=text] {
	background: url(style/default/images/user.png) 4px 5px no-repeat;
}

fieldset input[type=password] {x 5px no-repeat;
	background: url(style/default/images/password.png) 4p
}

fieldset input[type=text],fieldset input[type=password] {
	width: 100%;
	line-height: 2em;
	font-size: 12px;
	height: 30px;
	border: none;
	padding: 3px 4px 3px 2.2em;
	width: 300px;
}

fieldset input[type=submit] {
	text-align: center;
	padding: 2px 20px;
	line-height: 2em;
	border: 1px solid #000;
	border-radius: 3px;
	background: rgba(255, 255, 255, 0.6);
	background: -moz-linear-gradient(top, #FF6900, #FF9800 0, #FF6900 24px);
	background: -o-linear-gradient(top, #FF6900, #FF9800 0, #FF6900 24px);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FF9800',
		endColorstr='#FF6900' );
	-ms-filter:
		"progid:DXImageTransform.Microsoft.gradient(startColorstr='#FF9800', endColorstr='#FF6900')";
	height: 30px;
	cursor: pointer;
	letter-spacing: 4px;
	margin-left: 10px;
	color: #000;
	font-weight: bold;
}


.inputWrap {
	background: -webkit-gradient(linear, left top, left 24, from(#FFFFFF),
		color-stop(4%, #EEEEEE), to(#FFFFFF) );
	background: -moz-linear-gradient(top, #FFFFFF, #EEEEEE 1px, #FFFFFF 24px);
	background: -o-linear-gradient(top, #FFFFFF, #EEEEEE 1px, #FFFFFF 24px);
	border-radius: 3px;
	border: 1px solid #CCC;
	margin: 10px 10px 0;
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#EEEEEE',
		endColorstr='#FFFFFF' );
	-ms-filter:
		"progid:DXImageTransform.Microsoft.gradient(startColorstr='#EEEEEE', endColorstr='#FFFFFF')";
}

fieldset input[type=checkbox] {
	margin-left: 10px;
	vertical-align: middle;
}

fieldset a {
	color: #000;
	font-size: 12px;
	margin: 6px 0 0 10px;
	text-decoration: none;
}

fieldset a:hover {
	text-decoration: underline;
}

fieldset span {
	font-size: 12px;
}
</style>
<style type="text/css">
<!--
body {
	background: url(header.jpg);
	background-size: cover;
	background-repeat : no-repeat;
	background-attachment: fixed;
	background-position: 50% 50%;
	background-repeat: no-repeat 
}
-->

</style>
</head> 
<body> 
<div align ="center">
<div class="wrap"> 

  <form action="register" method="post" name="managerForm" onsubmit="return insertManager()">

    <section class="registerForm"> 
      <div class="loginForm_content"> 
        <fieldset> 
          <div class="inputWrap"> 
			
            <input type="text" name="username" placeholder="请输入用户名，用户名仅可由英文字母与数字构成" autofocus required> 

         
          </div>

          <div class="inputWrap"> 

            <input id= "Password" type="password" name="Password" placeholder="请输入密码（7位以上）" required> 

          </div> 
          <div class="inputWrap"> 

            <input id= "re_Password" type="password" name="re_Password" placeholder="请再次确认密码" required> 

          </div> 

        </fieldset> 
        
      

        <fieldset> 

           <input type="submit" name = "Submit2" " value="注册"> 
            <a href = "welcome_test.jsp">已有账号？直接登录吧</a>

        </fieldset> 

      </div> 

    </section> 

  </form> 

</div> 
</div> 
</div> 
</body> 
</html> 

 