
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common.jsp"%>
<!DOCTYPE h1 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h1 class="page-header">用户列表</h1>
<h2 class="sub-header">Section title</h2>
<div style="text-align: right"><a class="btn btn-success" data-toggle="modal" data-target="#gridSystemModal">创建</a></div>
<div class="table-responsive">
  <table class="table table-striped">
    <thead>
      <tr>
      	<th>#</th>
        <th>组标识</th>
        <th>名称</th>
        <th>类型</th> 
      </tr>
    </thead>
    <tbody>
    	<c:forEach var="datas" items="${grouplList }" varStatus="varStatus">
    		 <tr>
    		 	<td>${varStatus.index + 1}</td>
		        <td>${datas.id }</td>
		        <td>${datas.name }</td>
		        <td>${datas.type }</td>
		      </tr>
    	</c:forEach>
    </tbody>
  </table>
</div>

<div id="gridSystemModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridModalLabel" style="display: none;">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
      <form action="createGroup.do">
      	
     	<!-- 头部 -->
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
          <h4 class="modal-title" id="gridModalLabel">Modal title</h4>
        </div>
       <!-- 身体 -->
		  
		  <div class="row">
           <div class="form-group">
		    <label class="col-sm-2 control-label">key</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" placeholder="key" name="groupId">
		    </div>
		  </div>  
		  </div> 
		  
         <div class="modal-body">
         <div class="row">
          <div class="form-group">
		    <label class="col-sm-2 control-label">名称</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" placeholder="名称" name="groupName">
		    </div>
		  </div>
		  </div>
		  
 		  <div class="row">
          <div class="form-group">
		    <label class="col-sm-2 control-label">所属种类</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" placeholder="分类名称" name="type">
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
