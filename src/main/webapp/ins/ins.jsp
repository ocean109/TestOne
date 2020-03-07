<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../include.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>保险日常业务</title>
  <script type="text/javascript">
  $(function() {
		<%=request.getAttribute("json")%>
		$("#dg").datagrid({
			url:'<%=path%>/insController/selectInsAll',    
		    columns:[[ 
		        {field:'customName',title:'姓名',width:100,align:'center'},    
		        {field:'customSex',title:'性别',width:100,align:'center'},    
		        {field:'customAge',title:'年龄',width:100,align:'center'},
		        {field:'addr',title:'地址',width:100,align:'center'}, 
		        {field:'idcard',title:'身份证号',width:100,align:'center'}, 
		        {field:'bankcard',title:'银行卡号',width:100,align:'center'}, 
		        {field:'pid',title:'产品',width:100,align:'center'}, 
		        {field:'inPutDate',title:'录入时间',width:100,align:'center'}, 
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
		    toolbar:[{
				text:'购买保险',
				iconCls:'icon-edit',
				handler:function(){
					
					//判断是否选中免险
					var row=$('#dg').datagrid('getSelected');

					if(row==null){//没有选中   
						msg("请选择要确认的免险信息！");
					}else{
						//选中了   改变这个表的信息把状态从已经提交变为已经确认
						var id = row.id;//获取免险信息的id
					
						$("#id").val(id);//将免险信息id放入隐藏域中
						//去查询看保险的信息
						
						$.post("<%=path %>/ProductController/selectAll",
						    	function(data){
							
						    		if(data!=null){
						    			
						    			var dom = "";
						    			//遍历后台返回过来的json字符串(list)集合
						    			$.each(data,function(i,n){
						    				
						    				dom+="<input type='radio' name = 'userName' value='"+n.id+"'/>"	+n.pname;  	
						    			});
						    			//把dom存放到 div中
						    			$("#insUsersDiv").html(dom);
						    		}
						    		
						    }, "json");	
						$("#ddd").dialog("open");
						
					}
			
				}
		    
			},{
				text:'编辑',
				iconCls:'icon-help',
				handler:function(){
					var row = $("#dg").datagrid("getSelected");
					//没选中行
					if(row == null){
						alert("请选择要编辑的行");
					}else{
						//选中行 之后拿到这个角色的id 之类的属性
						var id = row.id;
						var customName = row.customName;
						var customSex = row.customSex;
						var customAge = row.customAge;
						var addr = row.addr;
						var idcard = row.idcard;
						var bankcard =row.bankcard;
						var phone = row.phone;
						var isMarry = row.isMarry;
						var remark = row.remark;
						
						
						//将拿到的数据存放到编辑框的 value中
				
						$("#id").val(id);
						$("#customName").val(customName);
						$("#dd1 input[type='radio'][value='"+customSex+"']").prop("checked",true);
						$("#customAge").val(customAge);
						$("#phone").val(phone);
						$("#dd1 input[type='radio'][value='"+isMarry+"']").prop("checked",true);
						$("#idcard").val(idcard);
						$("#bankcard").val(bankcard);
						$("#addr").val(addr);
	  			 		$("#remark").val(remark);
	  			 		$("#dd1").dialog("open");
					}		
			
					
				}
				
				},{
					text:'提交',
					iconCls:'icon-help',
					handler:function(){
						var row = $("#dg").datagrid("getSelected");
						//没选中行
						if(row == null){
							alert("请点击要提交的客户");
						}else{
							var aaa=row.pid;
							alert(aaa);
							if(aaa == null){
								alert("请购买保险");
							}else{
							$.messager.confirm('确认对话框','您确定要提交吗？',function(r){
							if(r){
								//选中行 之后拿到这个角色的id 之类的属性
							var id = row.id;
							alert(id);
							//异步去后台更改这个用户的状态为5 已分配并提交
							$.post("<%=path%>/insController/updataStatus",{"id":id},
									function(data){
								if(data==true){
									//重新加载数据
					  				$("#dg").datagrid("reload");
									msg("提交成功");
								}
								
							},"json");
							
							}
							})
							}
						}		
					}
					}]
		});
	});
  
  </script>
  <script type="text/javascript">
  	/**********************给回访的保存按钮添加单机事件***************************/
  	$(function(){
  		$("#saveBtn").click(function(){
  	  		 var row = $("#dg").datagrid('getSelected'); 
  	  		 if(row==null){
  	  			 msg("请选择要回访的保险客户信息!");
  	  			 return;
  	  		 }/*拿到这个用户的id和回访的记录*/
  	  		var insId=row.id;
  			var recorddate=$("#recorddate").val();
  			var recordText=$("#recordText").val();
  			var nextdate=$("#nextdate").val();
  			/****异步发送到后台的insfollow表中存储**/
  			$.post("<%=path%>/insFollowController/insertInsfollow",{"insId":insId,"recorddate":recorddate,"recordText":recordText,"nextdate":nextdate},
  					function(data){
  				if(data==true){
  					////重新加载数据
  					$('#dg').datagrid('reload');
  					$('#dg2').datagrid('reload');
				    alert("保存回访信息成功!");
				    	
  				}else{
  					msg("保存回访信息失败!");
  				}
  				
  			},"json")
  	       });
  	}) ;
  	
  </script>
<script type="text/javascript">
	/*************给购买保险的保存按钮添加保存事件************/
			$(function(){
				$("#freeInsAssignBtnSave").click(function(){
					var id1 = $("#id").val();//拿到对应的客户id;
					var id2 = $("#insUsersDiv input:checked").val();//获取对应保险的id     
					alert(id1+"---"+id2);
					$.post("<%=path%>/insController/updateProduct",{"id1":id1,"id2":id2},
							function(data){
						alert(data);
						if(data==true){
							$("#dg").datagrid("reload");
							$("#ddd").dialog("close");
							msg("提交成功！");
						}else{
							msg("提交失败！");
						}
						
					},"json");
				})
			});
</script>
      
  </head>
  
  <body>
  
  	<table id="dg">		
  	</table>
  	<div id="dd"></div>
  	
    <div id="tt" class="easyui-tabs" style="width:1330px;"> 
		    <div title="保险回访" style="padding:20px;"> 
		    	<!-- 加载保险回访信息 -->
    	        <table id="dg2"></table>    
		       	<div>
		       		<table>
		       			<tr>
		       				<td>
		       					回访日期
		       				</td>
		       				<td>
		       					<input type="date" id="recorddate"/>
		       				</td>
		       				</tr>
		       				
		       				<tr>
		       				<td>
		       					回访内容
		       				</td>
		       				<td>
		       					<textarea id="recordText" style="width:1033px;height:65px"></textarea>
		       				</td>
		       				</tr>
		       				<tr>
		       				<td>
		       					下次回访日期
		       				</td>
		       			
		       				<td>
		       					<input type="date" id="nextdate"/>&nbsp;&nbsp;<input type="button" value="保存" id="saveBtn"/>
		       				</td>
		       				
		       			   </tr>
		       		</table>
		       		
		       	</div>
		    </div>   
		</div>
		
		<!-- 编辑保险信息的弹出框框 -->
		<div id="dd1" class="easyui-dialog" title="编辑保险" style="width:310px;height:480px;"   
	        data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
					$('#insForm').form('submit', {    
					    url:'<%=path%>/insController/updateInsfollow',    
					    onSubmit: function(data){   
					    
					      alert(data);  
					    
					        // do some check    
					        // return false to prevent submit;    
					    },    
					    success:function(datas){ 
					   alert('111111');
					        var data = eval('(' + datas + ')');
					        if(data==true){
					        	//重新加载数据
				  				$('#dg').datagrid('reload');
				  				//关闭添加框框
				  				$('#dd1').dialog('close');
					        	msg('保险编辑成功!');
					        }else{
					        	msg('保险编辑失败!');
					        }       
					    }    
					});  
					
				}
			},{
				text:'关闭',
				handler:function(){
					$('#dd1').dialog('close');
				}
			}]">   
			<form id="insForm" method="post">
				<table>
	    			<!-- 保险信息的id隐藏域 -->
	    			<input type="hidden" id="id" name="id"/>
	    			<tr>
	    				<td>姓名<br/><br/></td>
	    				<td>
	    					<input type="text" id="customName" name="customName"/><br/><br/>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>性别<br/><br/></td>
	    				<td>
	    					<input type="radio" name="customSex" value="男"/>男&nbsp;&nbsp;<input type="radio" name="customSex" value="女"/>女<br/><br/>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>年龄<br/><br/></td>
	    				<td>
	    					<input type="text" id="customAge" name="customAge"/><br/><br/>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>婚否<br/><br/></td>
	    				<td>
	    					<input type="radio"  name="isMarry" value="1"/>已婚&nbsp;&nbsp;<input type="radio" name="isMarry" value="2"/>未婚<br/><br/>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>电话<br/><br/></td>
	    				<td>
	    					<input type="text" id="phone" name="phone"/><br/><br/>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>身份证<br/><br/></td>
	    				<td>
	    					<input type="text" id="idcard" name="idcard"/><br/><br/>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>银行卡<br/><br/></td>
	    				<td>
	    					<input type="text" id="bankcard" name="bankcard"/><br/><br/>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>地址<br/><br/></td>
	    				<td>
	    					<input type="text" id="addr" name="addr"/><br/><br/>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>备注<br/><br/></td>
	    				<td>
	    					<input type="text" id="remark" name="remark"/><br/><br/>
	    				</td>
	    			</tr>
	    			
	    		</table>
				</table>
				
			</form>
	</div>
	 <!--分配保险的弹出框框 -->
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
