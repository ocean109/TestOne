<%@ page language="java" contentType="text/html; charset=UTF-8"
	
    pageEncoding="UTF-8"%>
       <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/jquery-easyui-1.3.4/jquery.min.js"></script>
	  <script type="text/javascript" src="js/jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
	  <link rel="stylesheet" href="js/jquery-easyui-1.3.4/themes/metro/easyui.css" type="text/css"></link>
	  <link rel="stylesheet" href="js/jquery-easyui-1.3.4/themes/icon.css" type="text/css"></link>
	  <script type="text/javascript" src="js/jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>
	  <script type="text/javascript" src="js/extEasyUI.js"></script>
<title>修改页面</title>
</head>
<body>
	<form action="MyController/updatafreeIns" method="post">
		<table>
			<tr>
				<td>客户名字
				</td>
				<td>
					<input type="text" id= "customName"  name = "customName"  value="<%=session.getAttribute("customName") %>" />
					<input type="hidden" id="id" name= "id" value="<%=session.getAttribute("id") %>">
				</td>
			</tr>
			<tr>
				<td>客户性别
				</td>
				<td>
					<input type="text" id= "customSex" name = "customSex" value="<%=session.getAttribute("customSex") %>"/>
				</td>
			</tr>
			<tr>	
				<td>客户年龄
				</td>
				<td>
					<input type="text" id= "customAge" name = "customAge" value="<%=session.getAttribute("customAge") %>"/>
				</td>
			</tr>
			<fmt:formatDate value="<%=session.getAttribute("addr") %>" type="date"/>
			<tr>
				<td>客户地址
				</td>
				<td>
					<input type="text" id= "addr" name = "addr"  value="<%=session.getAttribute("addr") %>"/>
				</td>
			</tr>
			<tr>
				<td>客户电话
				</td>
				<td>
					<input type="text" id= "phone" name= "phone" value="<%=session.getAttribute("phone") %>"/>
				</td>
			</tr>
			<tr>
				<td>录入时间
				</td>
			
				<td>
					<input type="date" id= "inPutDate" name= "inPutDate" value='<%=session.getAttribute("inputDate") %>'/>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="提交内容"/>
				</td>
			</tr>
			
			
		</table>
		
	</form>

</body>
</html>