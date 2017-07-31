
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common.jsp"%>
<!DOCTYPE h1 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h1 class="page-header">进行中任务</h1>
<h2 class="sub-header">进行中的任务，区别在于查询出所有任务，不包括历史任务</h2>

<div class="table-responsive">
  <table class="table table-bordered table-hover">
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
    	<c:forEach var="datas" items="${task }" varStatus="varStatus">
    		 <tr>
    		 	<td>${varStatus.index + 1}</td>
		        <td>${datas.id }</td>
		        <td>${datas.processInstanceId }</td>
		        <td>${datas.name }</td>
		        <td>${datas.processVariables }</td>
		        <td><fmt:formatDate value='${datas.createTime }' pattern='yyyy-MM-dd HH:mm:ss'/></td>
		        <td><a href="startCompleteTask.do?taskId=${datas.id }&processInstanceId=${datas.processInstanceId }">完成任务</a>&nbsp;
		        <a href="javascript:window.open('viewShowHight.do?taskId=${datas.id }&processDefinitionId=${datas.processDefinitionId}&processInstanceId=${datas.processInstanceId }')">查看流程图</a>&nbsp;
		        <%-- <a data-toggle="modal" data-target="#myModal" data-whatever="${datas.id }">分配任务</a> --%>
                  <a data-toggle="modal" data-target="#myModal"  
                    data-whatever="${datas.id }">分配任务  
            </a>  
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
    
    <form action="allotTask.do" method="post">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"></h4>
      </div>
      <div class="modal-body">
   	  	<div class="form-group">
		  <label class="col-sm-2 control-label">选择人</label>
		  <input type="text" id="taskId" style="display:none" name="taskId">
		   <div class="col-sm-10">
		  <select class="form-control success" name="userId">
		  	<c:forEach var="data" items="${users }">
			    <option value="${data.id }">${data.firstName }${data.lastName }</option>
		   	</c:forEach>
			</select>
			</div>
	  	</div>
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-primary">Save changes</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
     </form>
      
    </div>
  </div>
</div>

</body>
<script type="text/javascript">
	 $('#myModal').on('show.bs.modal', function (event) {  
        var label = $(event.relatedTarget) // 触发事件的标签 
        var recipient = label.data('whatever') // 解析出whatever内容  
        var modal = $(this)  //获得模态框本身
        modal.find('.modal-title').text('选择分配的人' + recipient)  //			
        modal.find('.modal-body input').val(recipient)  
    })  
</script>
	
</html>
