<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>财务确认页面</title>
     <script type="text/javascript">
  $(function() {
		<%=request.getAttribute("json")%>
		$("#dg").datagrid({
			url:'<%=path%>/insController/selectInsAllzf',    
		    columns:[[ 
		        {field:'customName',title:'姓名',width:100,align:'center'},    
		        {field:'customSex',title:'性别',width:100,align:'center'},    
		        {field:'customAge',title:'年龄',width:100,align:'center'},
		        {field:'addr',title:'地址',width:100,align:'center'}, 
		        {field:'idcard',title:'身份证号',width:100,align:'center'}, 
		        {field:'bankcard',title:'银行卡号',width:100,align:'center'}, 
		        {field:'pid',title:'产品',width:100,align:'center',formatter:function(value,row,index){
		        
		        	var msg = toProduct(value); //处理状态
	                  return msg;
	           }}, 
		        {field:'inputDate',title:'录入时间',width:100,align:'center'}, 
		        {field:'phone',title:'电话',width:100,align:'center'},
		        {field:'userId',title:'员工',width:100,align:'center'}, 
		        {field:'isMarry',title:'婚否',width:100,align:'center',formatter:function(value,row,index){
		        
		        	var msg = toFreeInsisMarry(value); //处理状态
	                  return msg;
	           }
		        }, 
		        {field:'status',title:'状态',width:100,align:'center',formatter:function(value,row,index){
		        	var msg = toFreeInsStatus(value); //处理状态
		                  return msg;
		           }
		        	}, 
		        {field:'remark',title:'备注',width:100,align:'center'}
		    ]],
		    singleSelect:true,//设置单选
		  	fitColumns:true,//自适应
		    pagination:true,//展示分页工具
		    rownumbers:true,//显示行号			
		    toolbar:[{   //提交给提交给财务
				text:'支付',
				iconCls:'icon-edit',
				handler:function(){
					
					//判断是否选中免险
					var row=$('#dg').datagrid('getSelected');

					if(row==null){//没有选中   
						msg("请选择要支付的保险用户的信息！");
					}else{
						//选中了   改变这个表的信息把状态从分配并提交提交变为已经确认
						var id = row.id;//获取保险客户信息的id
					
						$("#id").val(id);//将保险信息id放入隐藏域中
						//去查询看保险的信息
							//异步去后台更改这个用户的状态为5 已分配并提交
						$.post("<%=path%>/insController/updataStatuszf",{"id":id},
								function(data){
							if(data==true){
								//重新加载数据
				  				$("#dg").datagrid("reload");
								msg("确认支付成功！");
							}else{
								msg("确认支付失败！");
							}
							
						},"json");
					}
			
				}
		    
			},{
					text:'打回',
					iconCls:'icon-help',
					handler:function(){
						var row = $("#dg").datagrid("getSelected");
						//没选中行
						if(row == null){
							alert("请点击要打回的客户");
						}else{
							$.messager.confirm('确认对话框','您确定要打回吗？',function(r){
							if(r){
								//选中行 之后拿到这个角色的id 之类的属性
							var id = row.id;
							alert(id);
							//异步去后台更改这个用户的状态为5 已分配并提交
							$.post("<%=path%>/insController/updataInsStatuss",{"id":id},
									function(data){
								if(data==true){
									//重新加载数据
					  				$("#dg").datagrid("reload");
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
  </head>
  
  <body>
	  <table id="dg">		
  	      </table>
  	  <div id="dd"></div>
  </body>
</html>
