<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common.jsp"%>

<!DOCTYPE h1 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h1 class="page-header">完成任务填写信息</h1>
<h2 class="sub-header">在task中添加的Propertie属性，留言记录是会记录完成的记录。用于后期拼接</h2>
<div class="row">
	<div class="col-md-9" role="main">  
		<form class="form-horizontal" action="completeTask.do" method="post">
		
			<input type="text" class="form-control" style="display:none" name="taskId" value="${taskId }">
			<input type="text" class="form-control" style="display:none" name="processInstanceId" value="${processInstanceId }">
	  		
			<c:forEach var="data" items="${formPropertielList }" varStatus="varStatus">
				 <div class="form-group">
			    	<label  class="col-sm-2 control-label">${data.name }</label>
				     <div class="col-sm-10">
				      <input type="text" class="form-control" placeholder="${data.name }" name="${data.id }">
				    </div>
		  		</div>		
			</c:forEach>
			
			 	<div class="form-group">
			    	<label  class="col-sm-2 control-label">留言记录</label>
				     <div class="col-sm-10">
				      <input type="text" class="form-control" placeholder="留言记录" name="message">
				    </div>
		  		</div>		
		 
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</div>
</body>
</html>