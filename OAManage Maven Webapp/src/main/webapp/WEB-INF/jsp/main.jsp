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
          <a class="navbar-brand" href="../sign/login.do">工作流引擎DEMO</a>
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
            <li class="active"><a href="../activiti/list.do" target='ifram_c'>流程部署<span class="sr-only">(current)</span></a></li>
            <li><a href="../activiti/queryTask.do" target='ifram_c'>进行的任务</a></li>
            <li><a href="../activiti/allTask.do" target='ifram_c'>全部任务</a></li>
            <li><a href="../workflow/model/list.do" target='ifram_c'>Export</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item</a></li>
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
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
  </script>
  
</html>
