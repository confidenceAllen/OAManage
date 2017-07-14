<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="/common.jsp"%>
    <title>OA后台系统管理</title>
     <link rel="StyleSheet" type="text/css" href="<%=basePath %>css/dashboard.css">
  </head>
  
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="">工作流引擎DEMO</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="logout.do">登出</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input class="form-control" placeholder="Search..." type="text">
          </form>
        </div>
      </div>
    </nav>
    
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="../model/list.do" target='ifram_c'>模型设计</a></li>
            <li><a href="../activiti/list.do" target='ifram_c'>流程部署</a></li>
            <li><a href="../task/queryTask.do" target='ifram_c'>进行的任务</a></li>
            <li><a href="../task/historicTaskList.do" target='ifram_c'>全部任务</a></li>
           	<li><a href="../task/myGroupTask.do" target='ifram_c'>我的组待办任务</a></li>
           	<li><a href="../task/myOwnerTask.do" target='ifram_c'>我的个人任务</a></li>
          </ul>
          <ul class="nav nav-sidebar">           
            <li><a href="../processInstance/processInstanceList.do" target='ifram_c'>查看流程实例</a></li>
            <li><a href="../activemq/main.do" target='ifram_c'>消息中间件</a></li>
            <li><a href="">Another nav item</a></li>
            <li><a href="">More navigation</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="../user/userList.do" target='ifram_c'>用户管理</a></li>
            <li><a href="../user/groupList.do" target='ifram_c'>组管理</a></li>
            <li><a href="">Another nav item</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<iframe name="ifram_c" src="../activiti/main.do" frameborder="0" scrolling="auto" height="100%" width="100%"></iframe>
        </div>
      </div>
    </div>
    
  </body>
  
  <script type="text/javascript">
  		$(document).ready(function () {
				$('ul.nav > li').click(function (e) {
				$('ul.nav > li').removeClass('active'); //所有的li 去除active
				$(this).addClass('active'); //为当前的增加active
				
				});
			
			});
  </script>
  
</html>
