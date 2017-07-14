
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common.jsp"%>
<!DOCTYPE h1 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h1 class="page-header">流程实例</h1>
<div class="table-responsive">
  <table class="table table-striped table-bordered">
    <thead>
      <tr>
      	<th>#</th>
        <th>流程标识</th>
        <th>流程名字</th>
        <th>状态</th>    
        <th>操作</th> 
      </tr>
    </thead>
    <tbody>
    	<c:forEach var="datas" items="${processInstances }" varStatus="varStatus">
    		 <tr>
    		 	<td>${varStatus.index + 1}</td>
		        <td>${datas.processInstanceId }</td>
		        <td>${datas.processDefinitionName }</td>
	          	<td><c:if test="${datas.suspended}">已停止</c:if>
	          	<c:if test="${!datas.suspended}">已激活</c:if></td>
		        <td><a href="javascript:window.open('../activiti/viewShow.do?deploymentId=${datas.deploymentId }')">查看流程图</a>&nbsp;
		         <a href="deleteProcessInstance.do?processInstanceId=${datas.id }">删除</a>&nbsp;
	          	 <a href="suspendProcessInstance.do?processInstanceId=${datas.id }">挂起（停止）</a>&nbsp;
	          	 <a href="activateProcessInstance.do?processInstanceId=${datas.id }">激活</a>&nbsp;
	          	 <a href="comment.do?processInstanceId=${datas.id }">查看动态留言</a>&nbsp;
		         </td>
		      </tr>
    	</c:forEach>
    </tbody>
  </table>
</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"></h4>
      </div>
      <div class="modal-body">
			
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Save changes</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
      
    </div>
  </div>
</div>

</body>
<script type="text/javascript">
	$('#myModal').on('show.bs.modal', function (event) {  
        var label = $(event.relatedTarget) // 触发事件的标签 
        var processInstanceId = label.data('whatever') // 解析出whatever内容  
         $.ajax({
             type: "post",
             url: "comment.do",
             data: {processInstanceId:processInstanceId},
             dataType: "JSON",
             success: function(data){             
            			 console.log(data);
                     }
         });
        
    })  
</script>
	
</html>
