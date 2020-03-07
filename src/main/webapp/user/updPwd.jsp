<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改密码</title>
<script type="text/javascript">
 //添加鼠标移出事件2 判断第二次输入密码是否与第一次的相同
 $(function(){
	//添加鼠标移出事件比较两次密码输入是否一样
	$("#pwd3").blur(function(){
		$("#span2").html("");
	//获取第一次输入密码的值
	var  pwd2 = $("#pwd2").val();
	//获取第二次输入密码的值
	var  pwd3 = $("#pwd3").val();
	if(pwd2!=pwd3){
		$("#span2").html("两次密码不一样");
	}
	});
 });
</script>
<script type="text/javascript">
//添加鼠标点击事件发送新密码和旧密码和用户名去后台
	$(function(){
		$("#but1").click(function(){
		
			//拿到用户名和新密码 去数据库更新
			var userName = $("#userName").val();
			var pwd = $("#pwd3").val();
			var pwdj = $("#pwd1").val();
			$.post("<%=path %>/MyController/updata",{"userName":userName , "pwd":pwd , "pwdj":pwdj},
				function(data){
				if(data==true){
					alert("密码修改成功，请成功登陆");
					  parent.location.href="<%=path %>/UserController/exit";
					
					<%-- window.location.href="<%=path %>/UserController/exit"; 
					../Login.jsp
					--%>
				}
			},"json");
		});
	});
</script>
  </head>
  
  <body>
  			<table>
  				<tr>
  					<td>输入账号</td>
  					<td>
  						<input type="text" size="200px" id="userName"/>	
  						<span id="span1" style="color :red"></span>
  					</td>
  					
  			
  				</tr>
  				<tr>
  					<td>输入密码</td>
  					<td>
  						<input type="password" size="200px" id="pwd1"/>
  					</td>
  					<td>
  						
  					</td>
  				</tr>
  				<tr>
  					<td>输入新密码</td>
  					<td>
  						<input type="password" size="200px" id="pwd2"/>
  					</td>
  				</tr>
  				<tr>
  					<td>再次输入</td>
  					<td>
  						<input type="password" size="200px" id="pwd3"/>
  						<span id="span2" style="color :red"></span>
  					</td>
  				</tr>
  				<tr>
  					<td>
  						<input type="button" value="确认" id="but1">
  					</td>
  				</tr>
  			</table>  			
  			
  			
  </body>
</html>
