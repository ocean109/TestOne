<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript">
  $(function() {
		<%=request.getAttribute("json")%>
		$("#dg").datagrid({
			url:'<%=path%>/UserController/selectAll',    
		    columns:[[    
		        {field:'userName',title:'员工账号',width:100,align:'center'},    
		        {field:'rid',title:'员工编号',width:100,align:'center'},  
		        {field:'isdel',title:'状态',width:100,align:'center',
		        	formatter:function(value,row,index){
	                  var msg = toUserisdel(value); //处理状态
	                  return msg;
	           }
		        },  
		        {field:'level',title:'员工等级',width:100,align:'center',
		        	formatter:function(value,row,index){
	                  var msg = toUserlevel(value); //处理状态
	                  return msg;
	           }
		        },
		        {field:'remark',title:'员工姓名',width:100,align:'center'},
		        {field:'reset',title:'',width:100,align:'center',formatter:function(value,row,index){
		        	 return "<input type='button' id='button' onClick='showValue()' style=' BACKGROUND-COLOR: transparent' value='重置密码'/>"; 
		        }} 
		       
		    ]],
		    singleSelect:true,//设置单选
		  	fitColumns:true,//自适应
		    pagination:true,//展示分页工具
		    rownumbers:true,//显示行号			
		    toolbar:[{
				text:'添加',
				iconCls:'icon-edit',
				handler:function(){//写添加的方法
					$('#dd').dialog({    
					    title: '添加员工',    
					    width: 600,    
					    height: 400,    
					    closed: false,    
					    cache: false,    
					    href:'<%=path %>/user/adduser.jsp',    
					    modal: true   
					});
					
				}
			},{
				text:'删除',
				iconCls:'icon-help',
				handler:function(){
					var row = $("#dg").datagrid("getSelected");
					//没选中行
					if(row == null){
						alert("请选择要删除的行");
					}else{
						//选中行
						var level = row.id;
					
						$.messager.confirm('确认对话框','您确定要删除吗？',function(r){
							if(r){
								//将id传递到后台删除
								alert(level);
								$.post("<%=path%>/UserController/deletUser",{"level":level},
										function(data){
									if(data==true){
										$('#dg').datagrid('reload');     // 重新载入当前页面数据 
										msg("删除成功");	
									}else{
										msg("删除失败");
									}
								},"json");
							}
						})
						
					}
				}
			}]
		});
		
		
	});
  </script>
  <script type="text/javascript">
  function showValue(){
	  alert("1");
	  var row = $("#dg").datagrid("getSelected");
	  var id= row.id;
	 $.post("<%=path%>/UserController/upwpd",{"id":id},function(data){
		 alert(data);
		 if(data==true){
			 msg("重置成功");
		 }else{
			 msg("重置失败");
		 }
	 },"json");
	  
 }
  </script>
  
  </head>
  
  <body>
    <table id="dg">		
  	</table>
  	<div id="dd">
  	</div>
  </body>
</html>
