<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common.jsp"%>
<!DOCTYPE h1 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h1 class="page-header">${processDefinition.name }</h1>

<div class="row">
	<div class="col-md-9" role="main">  
		<form class="form-horizontal" action="beginProcessInstance.do" method="post">
		
		 	<div class="form-group" style="display:none">
		    	<label  class="col-sm-2 control-label">ID</label>
			     <div class="col-sm-10">
			      <input type="text" class="form-control" name="processDefinitionId" value="${processDefinition.id }">
			    </div>
	  		</div>	
	  		
			<c:forEach var="data" items="${formPropertielList }" varStatus="varStatus">
				 <div class="form-group">
			    	<label  class="col-sm-2 control-label">${data.name }</label>
				     <div class="col-sm-10">
				      <input type="text" class="form-control" placeholder="${data.name }" name="${data.id }">
				    </div>
		  		</div>		
			</c:forEach>
		 <div style="text-align: center">
		  <button type="submit" class="btn btn-default">Submit</button>
		  </div>
		</form>
	</div>
</div>

</body>
</html>