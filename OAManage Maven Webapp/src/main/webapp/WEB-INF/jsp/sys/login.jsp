<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>OA系统管理后台</title>
    <link rel="StyleSheet" type="text/css" href="<%=basePath %>css/signin.css">
  </head>
  <body>
<div class="container">
      <form class="form-signin" action="<%=basePath %>sign/login.do">
        <h2 class="form-signin-heading">登录我的1OA系统</h2>
        <label  class="sr-only">UserName</label>
        <input  class="form-control" placeholder="UserName" required="" autofocus="" name="userName">
        <label for="inputPassword" class="sr-only">Password</label>
        <input id="inputPassword" class="form-control" placeholder="Password" required="" type="password" name="password">
        
        <div class="dropdown">
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
		</div>
        
        <div class="checkbox">
          <label>
            <input value="remember-me" type="checkbox"> Remember me
          </label>
        </div>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <a class="btn btn-lg btn-primary btn-block" href="sign/register.do">注册</a>
      </form>
    </div>
  </body>