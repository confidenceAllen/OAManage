<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<link rel="StyleSheet" type="text/css" href="<%=basePath %>js/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="StyleSheet" type="text/css" href="<%=basePath %>js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="StyleSheet" type="text/css" href="<%=basePath %>js/bootstrap-3.3.7-dist/css/bootstrap-theme.css">

<script type="text/javascript" src="<%=basePath %>js/jquery-2.1.3.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
