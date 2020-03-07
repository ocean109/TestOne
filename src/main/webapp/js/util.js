//toProduct  购买的保险
function toProduct(status){
	var msg;
	switch (status){
	case 1:
		msg = "少年险"; break;
	case 2:
		msg = "中年险"; break;
	case 3:
		msg = "老年险"; break;
	default:
		msg = "未购买"; break;
	}
	return msg;
	
}

/**
 * 免险状态转换 
 */
function toFreeInsStatus(status){
	var msg;
	switch (status){
	case 1:
		msg = "已保存"; break;   //免险日常页面
	case 2:
		msg = "保存并提交"; break;   //经理的免险确认页面
	case 3:
		msg = "保存并确认"; break;   //经理的免险分配页面
	case 4: 
		msg = "已分配"; break;    //保险日常页面
	case 5:
		msg = "已分配并提交"; break;  //保险确认页面
	case 6:
		msg = "已经确认付款"; break;    //财务页面
	default:
		msg = "不确定"; break;
	}
	return msg;
	
}
//员工等级
function toUserlevel(level){
	var msg;
	switch(level){
	case 1:
		msg = "经理"; break;
	case 2:
		msg = "财务"; break;
	case 3:
		msg = "免险业务员"; break;
	case 4:
		msg = "保险业务员"; break;
	default :
			msg= "buqued" ;break;
	}
	return msg;
}
//保险客户的性别
function toFreeInsisMarry(value){
	var msg;
	switch(value){
	case 1:
		msg = "已婚"; break;
	case 2:
		msg = "未婚"; break;
	default :
			msg= "不确定" ;break;
	}
	return msg;
}
//员工状态显示 
function toUserisdel(isdel){
	var msg;
	switch(isdel){
	case 1:
		msg = "在职"; break;
	case 2:
		msg = "离职"; break;
	default :
			msg= "不确定" ;break;
	}
	return msg;
}
/**
 * 封装提示信息
 */
function msg(msg){
	$.messager.show({
		title:'提示消息',
		msg:msg,
		timeout:3000,
		showType:'slide'
	});
}

//查找
function doSearch(){
    $('#dg').datagrid('load',{
    	freeIns: $('#customSex').val()
    });
}



