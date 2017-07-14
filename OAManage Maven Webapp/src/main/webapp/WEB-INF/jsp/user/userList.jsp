
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common.jsp"%>
<!DOCTYPE h1 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h1 class="page-header">用户列表</h1>
<div style="text-align: right"><a class="btn btn-success" data-toggle="modal" data-target="#gridSystemModal">创建</a></div>
<div class="table-responsive">
  <table class="table table-striped table-bordered">
    <thead>
      <tr>
      	<th>#</th>
        <th>用户账号</th>
        <th>姓名</th>
        <th>邮箱地址</th> 
      </tr>
    </thead>
    <tbody>
    	<c:forEach var="datas" items="${userList }" varStatus="varStatus">
    		 <tr>
    		 	<td>${varStatus.index + 1}</td>
		        <td>${datas.id }</td>
		        <td>${datas.firstName }${datas.lastName }</td>
		        <td>${datas.email }</td>
		      </tr>
    	</c:forEach>
    </tbody>
  </table>
</div>


<div id="gridSystemModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridModalLabel" style="display: none;">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
      <form action="create.do" class="form-horizontal">
      	
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
<script type="text/javascript">
	
</script>
	
</html>
