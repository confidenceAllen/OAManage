<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common.jsp"%>
<!DOCTYPE h1 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h1 class="page-header">留言记录</h1>
<h2 class="sub-header">一个流程的留言记录</h2>
<div class="table-responsive">
  <table class="table table-striped table-bordered">
    <thead>
      <tr>
      	<th>#</th>
        <th>任务ID</th>
        <th>所属流程ID</th>
        <th>任务名字</th>
        <th>处理人id</th>
        <th>开始时间</th> 

      </tr>
    </thead>
    <tbody>
    	<c:forEach var="datas" items="${comments }" varStatus="varStatus">
    		 <tr>
    		 	<td>${varStatus.index + 1}</td>
		        <td>${datas.id }</td>
		        <td>${datas.processInstanceId }</td>
		        <td>${datas.userId }</td>
		        <td>${datas.message }</td>
		        <td><fmt:formatDate value='${datas.time }' pattern='yyyy-MM-dd HH:mm:ss'/></td>
		      </tr>
    	</c:forEach>
    </tbody>
  </table>
</div>

</body>
<script type="text/javascript">
	
</script>
	
</html>
