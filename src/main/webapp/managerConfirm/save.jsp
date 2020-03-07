<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
  $(function() {
		<%=request.getAttribute("json")%>
		$("#dg").datagrid({
			url:'<%=path%>/MyController/selectStatus',    
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
		        {field:'inputDate',title:'录入时间',width:100,align:'center'}
		    ]],
		    singleSelect:true,//设置单选
		  	fitColumns:true,//自适应
		    pagination:true,//展示分页工具
		    rownumbers:true,//显示行号			
		    toolbar:[{
				text:'分配',
				iconCls:'icon-edit',
				handler:function(){
					//判断是否选中免险
					var row=$('#dg').datagrid('getSelected');
					if(row==null){//没有选中   
						msg("请选择要确认的免险信息！");
					}else{//选中了   改变这个表的信息把状态从已经提交变为已经确认
						var id = row.id;//获取免险信息的id
					
						$("#id").val(id);//将免险信息id放入隐藏域中
						//加载保险员工放入弹出框中
						$.post("<%=path%>/UserController/selectUserRole",
  						    	function(data){
  						    	var dom = "";
  						    	//遍历后台返回过来的json字符串(list)集合
  						    	$.each(data,function(i,n){

  						    		dom+="<input type='radio' name = 'userName' value='"+n.id+"'/>"	+n.userName;  	
  						    	});
  						    	
						$("#insUsersDiv").html(dom);
  						    }, "json");	
						$("#ddd").dialog("open");
					}	
				}
			},{ //打回到免险人员
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
						alert(id);
						$.messager.confirm('确认对话框','您确定要打回吗？',function(r){
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
		/***********************************给分配免险种框框保存按钮添加单击事件************************************/
		
	});
  
  </script>
  <script type="text/javascript">
  $(function(){
	  $("#freeInsAssignBtnSave").click(function(){
		 
			var id1 = $("#id").val();//获取免险信息的id
			var id2 = $("#insUsersDiv input:checked").val();//获取保险员工的id	
			//将免险id和保险员工的id发送到后台进行处理
		alert(id1+"---"+id2);
			$.post("<%=path%>/insController/addIns",{"id1":id1,"id2":id2},
					function(data){
				alert(data);
				if(data==true){//分配成功
					$("#dg").datagrid("reload");
					$("#ddd").dialog("close");
					msg("分配免险成功!");
				}else{
					msg("分配免险失败!");
				}    
			},"json");
		}); 
  });
  </script>
</head>
<body>
	<table id="dg">		
  	</table>
  	<div id="dd"></div>
  	<!-- 存储免险信息的id -->
  	<input type="hidden" id = "id" name = "id"/>
  	 <!--分配免险的弹出框框 -->
	<div id="ddd" class="easyui-dialog" title="分配免险" style="width:300px;height:200px;"   
	      data-options="iconCls:'icon-save',resizable:true,closed:true,modal:true,buttons:'#bb'">
	        <!-- 存放免险信息的id-->
	      	<input type="hidden" id="id"/>
	      	
	      	<div id="insUsersDiv"></div>
	 </div> 
	 <div id="bb">
	   <a id="freeInsAssignBtnSave" class="easyui-linkbutton">保存</a>
	   <a id="freeInsAssignBtnClose" class="easyui-linkbutton">关闭</a>
	 </div>
  
  	
</body>
</html>