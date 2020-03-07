<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>免险日常业务</title>
    

	 <script type="text/javascript">
 
		$(function() {
			<%=request.getAttribute("json")%>
			$("#dg").datagrid({
				url:'<%=path%>/MyController/selectAll',    
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
			        {field:'inputDate',title:'录入时间',width:100,align:'center'}
			    ]],
	  		    singleSelect:true,//设置单选
	  		  	fitColumns:true,//自适应
			    pagination:true,//展示分页工具
			    rownumbers:true,//显示行号			
			    toolbar:[{
					text:'添加',
					iconCls:'icon-edit',
					handler:function(){//写添加的方法
						//添加窗口
						$('#dd').dialog({    
						    title: '添加免费保险用户',    
						    width: 600,    
						    height: 400,    
						    closed: false,    
						    cache: false,    
						    href: 'freeIns/addFreeIns.jsp',    
						    modal: true
						    
						});
						
					}
				},{
					text:'提交',
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
						
									$.post("<%=path%>/MyController/upFreeIns",{"id":id},
											function(data){
										if(data==true){
											$('#dg').datagrid('reload');     // 重新载入当前页面数据 
											msg("提交成功");	
										}else{
											msg("提交失败");
										}
									},"json");
								}
							})
							
						}
				
						
					}
					
				},{
					text:'修改',
					iconCls:'icon-help',
				    closed: false,    
				    cache: false,    
					handler:function(){
						var row = $("#dg").datagrid("getSelected");
					    var id = row.id;
						//没选中行
						if(row == null){
							alert("请选择要修改的行");
						}else{
							
						$.post("<%=path%>/MyController/updataFreeIns",{"id":id},
								function(data){
						
							if(data!=null){
								
								$('#dd').dialog({    
								    title: '修改免费保险用户',    
								    width: 600,    
								    height: 400,    
								    closed: false,    
								    cache: false,    
								    href: 'freeIns/updata.jsp',
								    modal: true   
								});
							
							}
						},"json");
								
							
						}
							
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
							
							
							var id = row.id;
							$.messager.confirm('确认对话框','您确定要删除吗？',function(r){
								if(r){
									//将id传递到后台删除
						
									$.post("<%=path%>/MyController/deleteFreeIns",{"id":id},
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
		
  </head>
  
  
  
  
  
  <body>
<!--   <form action="MyController/select" method="post"> 
  	<table>
  		<tr>
  			<td>
  				姓名：<input type="text" id="customName" name="customName" size="20px"/>
  			</td>
  		 </tr>
  		<tr> 
  			<td>
  				性别：<input type="text" id="customSex" name="customSex"/>
  			</td>
  		</tr>
  		<tr>
  			<td>
  			        年龄：<input type="text" id="customAge" name="customAge"/>
  			</td>
  		</tr>	
  			<td>
  				地址：<input type="text" id="addr" name="addr"/>
  			</td>
  		<tr>	
  			<td>
  				点化：<input type="text" id="phone" name="phone"/>
  			</td>
  		</tr>	
  			<td>
  				状态：<input type="text" id="status" name="status"/>
  			</td>
  		<tr>	
  			<td>
  				员工Id:<input type="text" id="userId" name="userId"/>
  			</td>
  		</tr>	
  		<tr>
  			<td>
  				<input type = "submit" >
  			</td>
  		</tr>
  	</table>
  	</form> -->
  
  	<table id="dg">		
  	</table>
  	<div id="dd"></div>
   
  </body>
</html>
