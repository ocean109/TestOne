<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
$(function(){
	//动态加载树结构
	$("#tt").tree({
		url:"<%=path %>/MyController/men",
		idFiled:"id",
		parentField:"pid",
		textFiled:"text",
		onClick: function(node){
			//alert(node.text);  // 在用户点击的时候提示
			/**
				点击目录的时候，如果是展开的，让其收缩;如果是收缩的让其展开
			**/
			
			var flag=$("#tt").tree('isLeaf', node.target);//判断是否文件
			if(flag){//是文件
				
				//判断点击菜单对应的选项卡是否存在
				var flag1=$("#tabs").tabs('exists',node.text);
				if(flag1){//存在	
					$("#tabs").tabs('select',node.text);//让其选项卡选中
				}else{
					//打开对应的菜单
					$("#tabs").tabs('add',{    
					    title:node.text,//选项卡标题    
					    content:"<iframe src='"+node.attributes+"' width='99.5%' height='500px'/>",//去对应的页面   
					    closable:true
					});  
				}
			}else{//是目录
				if(node.state=="open"){
					$("#tt").tree('collapse', node.target);//折叠
				}else if(node.state=="closed"){
					$("#tt").tree('expand', node.target);//展开
				}
			}
			
			
			
		}

	});
});
</script>

</head>
<body>
	<ul id="tt"></ul>
</body>
</html>