<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common.jsp"%>
<!DOCTYPE h1 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h1 class="page-header">进行任务</h1>
<h2 class="sub-header">Section title</h2>
${tasks }
<div class="table-responsive">
  <table class="table table-striped">
    <thead>
      <tr>
      	<th>#</th>
        <th>任务ID</th>
        <th>所属流程ID</th>
        <th>任务名字</th>
        <th>申请人</th>
        <th>开始时间</th> 
        <th>操作</th> 
      </tr>
    </thead>
    <tbody>
    	<c:forEach var="datas" items="${historicTaskInstances }" varStatus="varStatus">
    		 <tr>
    		 	<td>${varStatus.index + 1}</td>
		        <td>${datas.id }</td>
		        <td>${datas.processInstanceId }</td>
		        <td>${datas.name }</td>
		        <td>${datas.assignee }</td>
		        <td><fmt:formatDate value='${datas.createTime }' pattern='yyyy-MM-dd HH:mm:ss'/></td>
		        <td><a href="startCompleteTask.do?taskId=${datas.id }&processInstanceId=${datas.processInstanceId }">完成任务</a>&nbsp;
		        <a href="javascript:window.open('viewShowHight.do?taskId=${datas.id }&processDefinitionId=${datas.processDefinitionId}&processInstanceId=${datas.processInstanceId }')">查看流程图</a>&nbsp;
		        </td>
		      </tr>
    	</c:forEach>
    </tbody>
  </table>
</div>

</body>
<script type="text/javascript">
	
</script>
	
</html>
