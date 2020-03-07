<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
	$(function(){
		$("#button").click(function(){
				var rname = $("#rname").val();
				var level = $("#level").val();
				var remark = $("#remark").val();
				$.post("<%=path%>/RoleController/addRole",{"rname":rname,"level":level,"remark":remark},
						function(data){
					if(data==true){
						msg("添加成功！");
						window.location.href="user/roleManager.jsp";
					}else{
						msg("添加失败！");
					}
					
				},"json")
		});
	});
</script>
</head>
<body>
	<div id = ww>
			<table>
				<tr>
					<td>角色名称</td>
					<td><input type="text" id="rname"/></td>
				</tr>
				<tr>
					<td>等级</td>
					<td><input type = "text" id="level"/></td>
				</tr>
				<tr>
					<td>备注</td>
					<td><input type = "text" id="remark"></td>
				</tr>
				<tr>
				<td align="center" colspan="2">
					<input type="button" id="button" name="button" value="提交内容"/>
				</td>
			</tr>
			</table>
	</div>

</body>
</html>