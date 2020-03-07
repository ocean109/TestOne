<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	$(function(){
		$("#button1").click(function(){
			////从jsp中取radio的id或radio的name
			var customSex="";
			var flag = false;
			var radios = document.getElementsByName("customSex");
			for(var i = 0;i<radios.length;i++){
				//如果没选中
				if(radios[i].checked==true){
					//赋值
					customSex = radios[i].value;
					//赋值
					flag = true;
					break;
				}
			}
			var customName = $("#customName").val();
			var customAge = $("#customAge").val();
			var addr = $("#addr").val();
			var phone = $("#phone").val();
			var inPutDate = $("#inPutDate").val();
			//alert(customSex+"-"+customName+"-"+customAge+"-"+addr+"-"+phone+"-"+inPutDate);
			var fals = true;
			if(customName==""){
				fals = false;
			}
			if(customSex==""){
				fals = false;		
			}
			if(phone==""){
				fals = false;		
			}
			if(fals==false){
				alert("基本信息不能为啊 兄die");
			}else{
			$.post("<%=path%>/MyController/addFreeIns",
					{"customName":customName,"customSex":customSex,"customAge":customAge,"addr":addr,"phone":phone,"inPutDate":inPutDate},
					function(data){
						if(data==true){
							alert("添加成功！");
							window.location.href="<%=path%>/freeIns/freeIns.jsp";
						}else{
							alert("添加失败！");
						}
					},"json");
			}
		});
	})
</script>

<title>添加免费险</title>
</head>
<body >
	<div id= "div">
	<form action="/MyController/addFreeIns" method="post">
		<table>
			<tr>
				<td>客户名字
				</td>
				<td>
					<input type="text" id= "customName" name = "customName"/>
				    <span id="span1" style="color :red"></span>
				</td>
			</tr>
			<tr>
				<td>客户性别
				</td>
				<td>
					<input type="radio" name="customSex" value="男"/>男&nbsp;&nbsp;<input type="radio" name="customSex" value="女"/>女<br/><br/>
				</td>
			</tr>
			<tr>	
				<td>客户年龄
				</td>
				<td>
					<input type="text" id= "customAge" name = "customAge"/>
				</td>
			</tr>
			<tr>
				<td>客户地址
				</td>
				<td>
					<input type="text" id= "addr" name = "addr"/>
				</td>
			</tr>
			<tr>
				<td>客户电话
				</td>
				<td>
					<input type="text" id= "phone" name= "phone"/>
				</td>
			</tr>

			<tr>
				<td>录入时间
				</td>
				<td>
					<input type="date" id= "inPutDate" name= "inPutDate"/>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="button"  id="button1" value="提交内容"/>
				</td>
			</tr>
			
			
		</table>
		
	</form>
	</div>

</body>
</html>