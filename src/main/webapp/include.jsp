<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <!-- 引入前端所需页面的支持 -->
	  <script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.3.4/jquery.min.js"></script>
	  <script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
	  <link rel="stylesheet" href="<%=path %>/js/jquery-easyui-1.3.4/themes/default/easyui.css" type="text/css"></link>
	  <link rel="stylesheet" href="<%=path %>/js/jquery-easyui-1.3.4/themes/icon.css" type="text/css"></link>
	  <script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>
	  <script type="text/javascript" src="<%=path %>/js/util.js"></script>
	  <script type="text/javascript" src="<%=path %>/js/extEasyUI.js"></script>
</head>
<body>

</body>
</html>