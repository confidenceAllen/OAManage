
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common.jsp"%>
<!DOCTYPE h1 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h1 class="page-header">部署流程</h1>
<h2 class="sub-header">Section title</h2>
<div class="table-responsive">
  <table class="table table-striped">
    <thead>
      <tr>
      	<th>#</th>
        <th>部署ID</th>
        <th>部署名字</th>
        <th>部署时间</th> 
        <th>操作</th> 
      </tr>
    </thead>
    <tbody>
    	<c:forEach var="datas" items="${deployments }" varStatus="varStatus">
    		 <tr>
    		 	<td>${varStatus.index + 1}</td>
		        <td>${datas.id }</td>
		        <td>${datas.name }</td>
		        <td><fmt:formatDate value='${datas.deploymentTime }' pattern='yyyy-MM-dd HH:mm:ss'/></td>
		        <td><a href="javascript:window.open('viewShow.do?deploymentId=${datas.id }')">查看流程图流程</a>&nbsp;
		        <a href="processInstanceDetail.do?deploymentId=${datas.id }">开始请假流程</a></td>
		      </tr>
    	</c:forEach>
    </tbody>
  </table>
</div>

</body>
<script type="text/javascript">
	
</script>
	
</html>
