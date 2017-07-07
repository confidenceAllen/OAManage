<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common.jsp"%>
<!DOCTYPE h1 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h1 class="page-header">请假信息</h1>
<h2 class="sub-header">Section title</h2>

<form action="startProcessInstance.do" method="post">

<div class="input-group">
  <span class="input-group-addon" id="sizing-addon2">KEY</span>
  <input type="text" class="form-control" placeholder="请输入姓名" aria-describedby="sizing-addon2" name="processDefinitionKey" value="${processDefinition.key }">
</div>

<div class="input-group">
  <span class="input-group-addon" id="sizing-addon2">请假人</span>
  <input type="text" class="form-control" placeholder="请输入姓名" aria-describedby="sizing-addon2" name="username">
</div>

<div class="input-group">
  <span class="input-group-addon" id="sizing-addon2">请假天数</span>
  <input type="text" class="form-control" placeholder="请输入天数" aria-describedby="sizing-addon2" name="dates">
</div>

<div class="input-group">
  <span class="input-group-addon" id="sizing-addon2">请假原因</span>
  <input type="text" class="form-control" placeholder="请输入原因" aria-describedby="sizing-addon2" name="reason">
</div>

<button class="btn btn-default" type="submit">确认</button>
</form>

</body>
</html>