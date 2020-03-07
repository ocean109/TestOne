<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="../include.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-easyui-1.3.4/jquery.min.js"></script>
	  <script type="text/javascript" src="js/jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
	  <link rel="stylesheet" href="js/jquery-easyui-1.3.4/themes/metro/easyui.css" type="text/css"></link>
	  <link rel="stylesheet" href="js/jquery-easyui-1.3.4/themes/icon.css" type="text/css"></link>
	  <script type="text/javascript" src="js/jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>
	  <script type="text/javascript" src="js/extEasyUI.js"></script>
	  <script type="text/javascript" src="js/util.js"></script>
</head>
<body>
 <form action="MyController/selectAll?id=2" method="post"> 
  	<table>
  		<tr>
  			<td>
  				姓名：<input type="text" id="customName" name="customName" size="20px"/>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				性别：<input type="text" id="customSex" name="customSex"/>
  			</td>
  		</tr>
  		<tr>
  			<td>
  			        年龄：<input type="text" id="customAge" name="customAge"/>
  			</td>
  		</tr>	
  			<td>
  				地址：<input type="text" id="addr" name="addr"/>
  			</td>
  		<tr>	
  			<td>
  				点化：<input type="text" id="phone" name="phone"/>
  			</td>
  		</tr>	
  			<td>
  				状态：<input type="text" id="status" name="status"/>
  			</td>
  		<tr>	
  			<td>
  				员工Id:<input type="text" id="userId" name="userId"/>
  			</td>
  		</tr>	
  		<tr>
  			<td>
  				<input type = "submit" >
  			</td>
  		</tr>
  	</table>
  	</form> 
  	
  	<div id="tb" style="padding:3px">
        <span>Item ID:</span>
        <input id="itemid" style="line-height:26px;border:1px solid #ccc">
        <span>Product ID:</span>
        <input id="productid" style="line-height:26px;border:1px solid #ccc">
        <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">Search</a>
    </div>
</body>
</html>