<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common.jsp"%>
<!DOCTYPE h1 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h1 class="page-header">全部任务</h1>
<h2 class="sub-header">全部的历史task,只有task。不包括流程线</h2>
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
    	<c:forEach var="datas" items="${historicTaskInstances }" varStatus="varStatus">
    		 <tr>
    		 	<td>${varStatus.index + 1}</td>
		        <td>${datas.id }</td>
		        <td>${datas.processInstanceId }</td>
		        <td>${datas.name }</td>
		        <td>${datas.assignee }</td>
		        <td><fmt:formatDate value='${datas.createTime }' pattern='yyyy-MM-dd HH:mm:ss'/></td>
		        <td><a href="startCompleteTask.do?taskId=${datas.id }&processInstanceId=${datas.processInstanceId }">完成任务</a>&nbsp;
		        <a href="javascript:window.open('../activiti/viewShowHight.do?taskId=${datas.id }&processDefinitionId=${datas.processDefinitionId}&processInstanceId=${datas.processInstanceId }')">查看流程图</a>&nbsp;
		        </td>
		      </tr>
    	</c:forEach>
    </tbody>
  </table>
</div>
    
<ul id='paper'></ul>
</body>
<script type="text/javascript">
$(function(){
        var element = $('#paper');
        options = {
            bootstrapMajorVersion:3, //对应的bootstrap版本
            currentPage: ${pager.currentPage }, //当前页数，这里是用的EL表达式，获取从后台传过来的值
            numberOfPages: 5 , //每页页数
            totalPages: ${pager.totalPages }, //总页数，这里是用的EL表达式，获取从后台传过来的值
            shouldShowPage:true,//是否显示该按钮
            pageUrl: function(type, page, current){                
            	return "${page.url }?page=" + page;  
            } ,
            //点击事件
            onPageClicked: function (event, originalEvent, type, page) {
	            if(${pager.currentPage }==1&&${pager.currentPage }==page){
	            	alert("这已经是首页!");
	            	return false;
	            }
	            if(${pager.currentPage }==${pager.totalPages }&&${pager.currentPage }==page){
	            	alert("这已经是尾页!");
	            	return false;
	            }
               
            }
        };
        element.bootstrapPaginator(options);
});
</script>
</html>
