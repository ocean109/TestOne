<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../include.jsp" %>
<!DOCTYPE html>
<html>
<head>
	  <style type="text/css">
	  	.div{
	  	width: 200px;
	  	height: 200px;
	  	}
	  </style>
<meta charset="UTF-8">
		<script type="text/javascript">
		$(function(){
	
			$("#span1").html("");
			
			//添加鼠标移出事件1 去后台查找看此用户名是存在
			$("#userName").blur(function(){
				var userName = $("#userName").val();
				if(userName!=""){
					//异步发送到后台验证登录  url   参数 ，返回值
					$.post("<%=path %>/MyController/userPwd",{"userName":userName},
							function(data){
						if(data==true){
							$("#span1").html("用户名可用");
						}else{
							$("#span1").html("用户名不可用");
						}
						
					},"json");
				}else{
					$("#span1").html("用户名不能为空");
				}
				
			});
		
		});
		</script>
		<script type="text/javascript">
		$(function(){
			
			$("#span2").html("");
			
			//添加鼠标移出事件1 去后台查找看此用户名是存在
			$("#rid").blur(function(){
				var rid = $("#rid").val();
				if(rid!=""){
					//异步发送到后台验证登录  url   参数 ，返回值
					$.post("<%=path %>/UserController/selectRid",{"rid":rid},
							function(data){
						if(data==true){
							$("#span2").html("可用");
						}else{
							$("#span2").html("不可用");
						}	
					},"json");
				}else{
					$("#span2").html("此项不能为空");
				}
				
			});
		});
		</script>
		<script type="text/javascript">
			$(function(){
				$("#button1").click(function(){
					var userName= $("#userName").val();
					var rid= $("#rid").val();
					var level= $("#level").val();
					var remark= $("#remark").val();
					var f = true;
					if(userName==""){
						f= false;
					}
					if(rid==""){
						f = false;
					}
					if(level==""){
						f = false;
					}
					if(remark==""){
						f = false;
					}
					if(f == true){
						$.post("<%=path%>/UserController/addUser",{"userName":userName,"rid":rid,"level":level,"remark":remark},
								function(data){
							if(data==true){
								msg("添加成功");
								window.location.href="user/userManager.jsp";
								alert("1");
							}else{
								msg("添加失败");
							}
							
						},"json");
					}else{
						msg("填写信息不完整无法提交！")
					}
					
				});
			});
		</script>

</head>
<body>
<div>
		<table>
			<tr>
				<td>
				员工账号：
				</td>
				<td>
					<input type="text" id="userName" name="userName"/>
					<span id="span1" style="color :red"></span>
				</td>
			</tr>
			<tr>
				<td>
				员工编号：
				</td>
				<td>
					<input type="text" id="rid" name="rid"/>
					<span id="span2" style="color :red"></span>
				</td>
			</tr>
			<tr>
				<td>
				员工等级：
				</td>
				<td>
					<input type="text" id="level" name= "level">
				</td>
			</tr>
			<tr>
				<td>
				员工姓名：
				</td>
				<td>
					<input type="text" id="remark" name="remark"/>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="button" id="button1" value="提交内容"/>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>