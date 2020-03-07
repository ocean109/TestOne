<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <script type="text/javascript">
  $(function() {
		<%=request.getAttribute("json")%>
		$("#dg").datagrid({
			url:'<%=path%>/MyController/selectFreeIns',    
		    columns:[[ 
		        {field:'customName',title:'姓名',width:100,align:'center'},    
		        {field:'customSex',title:'性别',width:100,align:'center'},    
		        {field:'customAge',title:'年龄',width:100,align:'center'},
		        {field:'addr',title:'地址',width:100,align:'center'}, 
		        {field:'phone',title:'电话',width:100,align:'center'}, 
		        {field:'status',title:'状态',width:100,align:'center',formatter:function(value,row,index){
		                  var msg = toFreeInsStatus(value); //处理状态
		                  return msg;
		           }
		        	}, 
		        {field:'userId',title:'参考员工表id',width:100,align:'center'}, 
		        {field:'inPutDate',title:'录入时间',width:100,align:'center'}
		    ]],
		    singleSelect:true,//设置单选
		  	fitColumns:true,//自适应
		    pagination:true,//展示分页工具
		    rownumbers:true,//显示行号			
		    toolbar:[{
				text:'确认',
				iconCls:'icon-edit',
				handler:function(){
					$.messager.confirm('确认对话框','您确定要执行该操作吗？',function(r){
					//判断是否选中免险
					var row=$('#dg').datagrid('getSelected');
					if(row==null){//没有选中   
						msg("请选择要确认的免险信息！");
					}else{//选中了   改变这个表的信息把状态从已经提交变为已经确认
						var id = row.id;//获取免险信息的id
						$.post("<%=path %>/MyController/updateStatus", {"id":id},
  						    	function(data){
  						    		if(data==true){
  						    			$('#dg').datagrid("reload");//刷新免险数据表格
  						    			msg("确认免险成功!");
  						    		}else{
  						    			msg("确认免险失败!");
  						    		}
  						    }, "json");	
						
					}
				})
				}
		    
			},{
				text:'打回',
				iconCls:'icon-help',
				handler:function(){
					var row = $("#dg").datagrid("getSelected");
					//没选中行
					if(row == null){
						alert("请选择要提交的行");
					}else{
						//选中行
						var id = row.id;
						$.messager.confirm('确认对话框','您确定要提交吗？',function(r){
							if(r){
								//将id传递到后台删除
					
								$.post("<%=path%>/MyController/updateaFreeIns",{"id":id},
										function(data){
									if(data==true){
										$('#dg').datagrid('reload');     // 重新载入当前页面数据 
										msg("打回成功");	
									}else{
										msg("打回失败");
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
  <body>
   	<table id="dg">		
  	</table>
  	<div id="dd"></div>
  </body>
</html>
