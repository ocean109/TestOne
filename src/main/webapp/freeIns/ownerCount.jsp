<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>免险个人统计</title>
     <script type="text/javascript">
 
		$(function() {
			$("#dg").datagrid({
				url:'<%=path%>/MyController/aaa',    
			    columns:[[    
			        {field:'sum',title:'总数',width:100,align:'center'},    
			        {field:'daysum',title:'今日新增',width:100,align:'center'},    
			    ]],
	  		    singleSelect:true,//设置单选
	  		  	fitColumns:true,//自适应
			    pagination:true,//展示分页工具
			    rownumbers:true,//显示行号			
			});
		});
	</script>
 
  </head>
  
  <body>
  	<table id="dg">		
  	</table>
  	<div id="dd"></div>

  </body>
</html>
