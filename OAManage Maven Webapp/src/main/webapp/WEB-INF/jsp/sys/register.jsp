<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>OA系统管理后台--注册页面</title>
    
  </head>
  <body>
  
  	<h1 class="page-header">用户注册</h1>
	<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-8">
	<form class="form-horizontal" action="signin.do" method="post" enctype="multipart/form-data">
	
  	  <div class="form-group">
	    <label class="col-sm-2 control-label">UserName</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" placeholder="userName" name="userName">
	    </div>
	  </div>
	  
  	  <div class="form-group">
	    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="inputPassword3" placeholder="password" name="password">
	    </div>
	  </div>
	  
  	  <div class="form-group">
	    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
	    <div class="col-sm-10">
	      <input type="email" class="form-control" id="inputEmail3" placeholder="Email" name="email">
	    </div>
	  </div>
	  
	  
  	  <div class="form-group">
	    <label class="col-sm-2 control-label">姓</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" placeholder="姓" name="firstName">
	    </div>
	  </div>
	  
   	  <div class="form-group">
	    <label class="col-sm-2 control-label">名字</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" placeholder="名字" name="lastName">
	    </div>
	  </div>
	  
	  <div class="form-group">
	  <label class="col-sm-2 control-label">选择身份</label>
	   <div class="col-sm-10">
	  <select class="form-control success" name="groupId">
	  	<c:forEach var="data" items="${groups }">
		    <option value="${data.id }">${data.name }</option>
	   	</c:forEach>
		</select>
		</div>
	  </div>
	  
    <div class="form-group">
		    <label class="col-sm-2 control-label" for="exampleInputFile">File input</label>
		    <input type="file"  name="file">
		    <a class="help-block">上传</a>
	  </div>
	
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">确认</button>
	    </div>
	  </div>
	</form>
	</div>
	<div class="col-sm-2"></div>
	</div>
  </body>
  
  </html>