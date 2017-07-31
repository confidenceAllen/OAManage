<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>


  <head>
  
    <title>OA系统管理后台</title>
    <link rel="StyleSheet" type="text/css" href="<%=basePath %>css/signin.css">
    <style type="text/css">
    	.video-player{background-color: rgba(0,0,0,0);
    	min-width: 100%;min-height: 100%;display: block;position: absolute;top:0;}
    	.login{ height:340px;width:260px;padding: 20px;background-color:rgba(0,0,0,0.5);border-radius: 4px;position:absolute;left: 45%;top: 22%; margin:-150px 0 
    	.video_mask{ width:100%; height:100%; position:absolute; left:0; top:0; z-index:90; background-color:rgba(0,0,0,0.5); }
    </style>
  </head>
  
	<video class="video-player" preload="auto" autoplay="autoplay" loop="loop" data-height="1080" data-width="1920" height="1080" width="1920">
	    <source src="<%=basePath %>video/login.mp4" type="video/mp4">
	    <!-- 此视频文件为支付宝所有，在此仅供样式参考，如用到商业用途，请自行更换为其他视频或图片，否则造成的任何问题使用者本人承担，谢谢 -->
	</video>
  <body>
<div class="container">

	<!-- <div class="video_mask"></div> -->
	
      <form class="form-signin" action="<%=basePath %>sign/login.do">
      <div class="login">
        <h2 class="form-signin-heading">登录我的系统</h2>
        <label  class="sr-only">UserName</label>
        <input  class="form-control" placeholder="UserName" required="" autofocus="" name="userName">
        <label for="inputPassword" class="sr-only">Password</label>
        <input id="inputPassword" class="form-control" placeholder="Password" required="" type="password" name="password">
        
<!--         <div class="dropdown">
		  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		    		下拉选择角色
		    <span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
		    <li><a href="#">员工</a></li>
		    <li><a href="#">组长</a></li>
		    <li><a href="#">副经理</a></li>
		    <li><a href="#">总经理</a></li>
		  </ul>
		</div> -->
        
        <div class="checkbox">
          <label>
            <input value="remember-me" type="checkbox"> Remember me
          </label>
        </div>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <a class="btn btn-lg btn-primary btn-block" href="../OAManage/sign/register.do">注册</a>
        
        </div>
      </form>
      
      </div>

  </body>
  