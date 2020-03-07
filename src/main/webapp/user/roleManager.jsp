<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     <script type="text/javascript">
  $(function() {
		<%=request.getAttribute("json")%>
		$("#dg").datagrid({
			url:'<%=path%>/RoleController/selectAll',    
		    columns:[[    
		        {field:'rname',title:'角色名称',width:100,align:'center'},    
		        {field:'rid',title:'等级',width:100,align:'center'},  
		        {field:'remark',title:'备注',width:100,align:'center'}
		    ]],
		    singleSelect:true,//设置单选
		  	fitColumns:true,//自适应
		    pagination:true,//展示分页工具
		    rownumbers:true,//显示行号			
		    toolbar:[{
				text:'更改权限',
				iconCls:'icon-help',
			    closed: false,    
			    cache: false,    
				handler:function(){
					var row = $("#dg").datagrid("getSelected");
				
			
					//没选中行
					if(row == null){
						alert("请选择要授权的角色");
					}else{
						//那到所选行角色的id
					    var id = row.id;
						//把角色的id存放到一个隐藏域中 待会向后台发送的时候再取出来
						//展示所有的菜单目录
						$("#hidden").val(id);
					
					
					    $("#tt").tree({
							url:"<%=path %>/MyController/men?idd="+id,
							idFiled:"id",
							parentField:"pid",
							textFiled:"text",
							checkbox:true,
							checked:"checked"	
						});	
					    $("#dd2").dialog("open");
					}
						
					}
			},{
				text:'增加职位',
				iconCls:'icon-help',
			    closed: false,    
			    cache: false,    
				handler:function(){
					$('#dd').dialog({    
					    title: '增加职位',    
					    width: 600,    
					    height: 400,    
					    closed: false,    
					    cache: false,    
					    href:'<%=path %>/user/addrole.jsp',    
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
						var id = row.id;
						$.messager.confirm('确认对话框','您确定要删除吗？',function(r){
							if(r){
								//将id传递到后台删除
					
								$.post("<%=path%>/RoleController/delete",{"id":id},
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
		/**********给角色授权弹出框 保存按钮事件*************/
		$("#grantSave").click(function(){
		
			//获取选中的菜单节点    checked 表示选中的    indeterminate 表示的是不确定的
  			var nodes = $('#tt').tree('getChecked',['checked','indeterminate']);
  			//获取所有选中菜单的菜单编号
  			var menuNums="";
  			//从隐藏域中获取角色的id
  			var rid = $("#rid").val();
  			var size = nodes.length;
  			$.each(nodes,function(i,node){
  				//确定遍历的是最后一个元素
  				if(i==(size-1)){
  					menuNums+=node.id;
  				}else{
  					menuNums+=node.id+",";
  				}
  			});
  			//异步把选中菜单的id数组和对应角色的id发送到后台并且存储到数据库中去
  			//拿出来隐藏域中的角色id和菜单id数组一起传送给后台
  			
  			var idd= $("#hidden").val();
  			$.post("<%=path%>/RoleController/inserRole",{"menuNums":menuNums,"idd":idd},
  					function(data){
  			
  				if(data==true){	
  					alert("授权成功");
  					window.location.href="user/roleManager.jsp";
  					
  				}else{
  					msg("授权失败");
  				}
  				
  			},"json");
		});
			
		
	});
  </script>
  </head>
  
  
  <body>
    <table id="dg">		
  	</table>
  	<div id="dd">
  	</div>
  			   <!--角色授权框框 -->
	      <div id="dd2" class="easyui-dialog" title="角色授权" style="width:300px;height:480px;"   
	        data-options="iconCls:'icon-save',resizable:true,closed:true,modal:true,buttons:'#bb2'">
	        	<!-- 角色id的隐藏域 -->
	        	<input type="hidden" id="rid"/>  
	        	<!-- 加载所有菜单用于授权 -->
	        	<ul id="tt"></ul>       	
		  </div>  	
		  <div id="bb2">
			<a id="grantSave" class="easyui-linkbutton">保存</a>
			<a id="grantClose" class="easyui-linkbutton">关闭</a>
		  </div>
  				<!-- 创建一个隐藏域  存取授权角色的id -->
  			<input type="hidden" id="hidden"/>
  </body>
</html>
