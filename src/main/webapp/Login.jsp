<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="include.jsp" %>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
body {
	background: #eee url(../img/bg.jpg) no-repeat fixed top;
	background-size: cover;
}

input {
	border: none;
}

div {
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	width: 50%;
	height: 30%;
	margin: auto;
}
</style>
<script type="text/javascript">
	$(function(){
		//鼠标点击登陆
		$("#button").click(function(){
			login();
		});								
		//键盘回车登陆
		$(window).keydown(function(event){ 
			var c = event.which;
			if(c==13){
				login();
			}
		});
	});
	/**
	登陆的公用方法
	*/
	function login(){
		var userName = $("#userName").val();
	 	var pwd = $("#pwd").val();
	 	if(userName!=null && pwd !=null){
	 		$.post("<%=path%>/UserController/User",{"userName":userName,"pwd":pwd},function(data){
	 			if(data==true){
	 				window.location.href="<%=path%>/index.jsp";
	 			}else{
	 				msg("账号或者密码错误！");
	 			}
	 		},"json");
	 	}else{
	 		msg("账号密码不能为空！");
	 	}
	}
	
</script>

</head>
<body >
	
	
	<div id= "div2" align="center">
		<table border="0">
			<tr>
				<td>员工账号：</td>
				<td>
					<input type="text" size="200px" id = "userName" name = "userName" placeholder="请输入用户名" style=" BACKGROUND-COLOR: transparent"/>
				</td>
			</tr>
			<tr>
				<td>员工密码：</td>
				<td>
					<input type="password" size="200px" id = "pwd" name = "pwd" placeholder="请输入密码" style="BACKGROUND-COLOR: transparent"/>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input id="button" type="button" value="登录" style="BACKGROUND-COLOR: transparent"/>
				</td>
			</tr>
			
		</table>
	</div>

</body>
</html>