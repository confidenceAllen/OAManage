<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common.jsp"%>


<!DOCTYPE html>
<html lang="en">
<head>

	<title>流程列表</title>
	
    <script type="text/javascript">
    </script>
</head>
<body>
<h1 class="page-header">Dashboard</h1>
<h2 class="sub-header">Section title</h2>

<div style="text-align: right"><a class="btn btn-success" data-toggle="modal" data-target="#gridSystemModal">创建</a></div>
<div class="table-responsive">
  <table class="table table-striped">
    <thead>
      <tr>
      	<th>ID</th>
				<th>KEY</th>
				<th>Name</th>
				<th>Version</th>
				<th>所属种类</th>
				<th>创建时间</th>
				<th>最后更新时间</th>
				<th>元数据</th>
				<th>操作</th> 
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${list }" var="model">
				<tr>
					<td>${model.id }</td>
					<td>${model.key }</td>
					<td>${model.name}</td>
					<td>${model.version}</td>
					<th>${model.category}</th>
					<td>${model.createTime}</td>
					<td>${model.lastUpdateTime}</td>
					<td>${model.metaInfo}</td>
					<td>
						<a href="modeler.do?modelId=${model.id}" target="_blank">编辑</a>
						<a href="deploy.do?modelId=${model.id}&category=${model.category}">部署</a>
						导出(<a href="export/${model.id}/bpmn.do" target="_blank">BPMN</a>
						|&nbsp;<a href="export/${model.id}/json.do" target="_blank">JSON</a>)
                        <a href="delete/${model.id}.do">删除</a>
					</td>
				</tr>
			</c:forEach>
    </tbody>
  </table>
</div>


	<div id="gridSystemModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridModalLabel" style="display: none;">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
      <form action="create.do" target="_blank" method="post">
      	
     	<!-- 头部 -->
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
          <h4 class="modal-title" id="gridModalLabel">Modal title</h4>
        </div>
       <!-- 身体 -->
        <div class="modal-body">
         <div class="row">
          <div class="form-group">
		    <label class="col-sm-2 control-label">名称</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" placeholder="名称" name="name">
		    </div>
		  </div>
		  </div>
		  
		  <div class="row">
           <div class="form-group">
		    <label class="col-sm-2 control-label">key</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" placeholder="key" name="key">
		    </div>
		  </div>  
		  </div> 
		  
 		  <div class="row">
          <div class="form-group">
		    <label class="col-sm-2 control-label">所属种类</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" placeholder="分类名称" name="category">
		    </div>
		  </div> 
		  </div>
		  
 		  <div class="row">
          <div class="form-group">
		    <label class="col-sm-2 control-label">分布人</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" placeholder="tenantId" name="tenantId">
		    </div>
		  </div> 
		  </div>
		  
		  <div class="row">
          <div class="form-group">
		    <label class="col-sm-2 control-label">描述</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" placeholder="description" name="description">
		    </div>
		  </div> 
		  </div>
		  		          
        </div>
        <!--尾部 -->
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Save changes</button>
        </div>
        </form>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  	</div>
  
 

</body>
</html>