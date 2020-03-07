<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

 <script type="text/javascript" src="js/jquery-easyui-1.3.4/jquery.min.js"></script>
	  <script type="text/javascript" src="js/jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
		  <link id="proThemes" rel="stylesheet" href="<%=path %>/js/jquery-easyui-1.3.4/themes/metro/easyui.css" type="text/css"></link>
	  <link rel="stylesheet" href="js/jquery-easyui-1.3.4/themes/icon.css" type="text/css"></link>
	  <script type="text/javascript" src="js/jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>
	  <script type="text/javascript" src="js/extEasyUI.js"></script>
<meta charset="UTF-8">
<title>啥啥啥啥啥</title>
<script type="text/javascript">
$(function(){
	//动态加载树结构
	var idd= 0;
	$("#tt").tree({
		url:"<%=path %>/MyController/men?idd="+idd,
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
	/**
	更换主题方法
	 */
	 $("#themes").change(function(){
		 var v = this.value;
		 //替换主题的风格
		 var start = "<%=path %>/js/jquery-easyui-1.3.4/themes/";
		 var end="/easyui.css";
		 var theme=start+v+end;
		 $("#proThemes").attr("href",theme);
	 });
});
</script>
<script type="text/javascript">
	$(function(){
		var pwd = <%=session.getAttribute("pwd")%>;
		
		if(pwd=="123456"){
			alert("请重置密码!");
		}
	});
</script>
<head>
</head>
<body class="easyui-layout" >
	<div data-options="region:'north',split:true" style="height: 100px">
		<h1><%=session.getAttribute("remark") %>,欢迎欢迎啊！</h1>
		<a href="<%=path %>/UserController/exit">退出登陆</a>
		 更换主题<select id="themes">
				<option value="black">包青天黑</option>
    			<option value="bootstrap">清香迷人</option>
    			<option value="default">经典</option>
    			<option value="gray">淡淡清灰</option>
    			<option value="metro">馍馍白</option>
    			<option value="metro-red">馍馍红</option>												
			    </select>        
	</div>
	<div data-options="region:'west',title:'主菜单',split:true"
		style="width: 180px;">
		<!-- 从后台加载树结构 -->
		<ul id="tt"></ul>

	</div>

	<div data-options="region:'center',title:'工作区域'"
		>
		<!-- 展示对应菜单的选项卡 -->
		<div id="tabs" class="easyui-tabs"></div>
	</div>

	<div data-options="region:'south',split:true"
		style="height: 50px; text-align: center">
		关于天猫 帮助中心 开放平台 诚聘英才 联系我们 网站合作 法律声明 隐私权政策 知识产权 廉正举报 规则意见征集<br />
		<br /> 阿里巴巴集团| 淘宝网 | 天猫 | 聚划算 | 全球速卖通 | 阿里巴巴国际交易市场| 阿里妈妈 | 飞猪 | 阿里云计算
		| 钉钉 | 支付宝 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@版权归兆隆所有,犯我者,虽远必诛
	</div>

</body>
</html>