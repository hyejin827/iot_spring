<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
    html, body {
        width: 100%;      /*provides the correct work of a full-screen layout*/ 
        height: 100%;     /*provides the correct work of a full-screen layout*/
        overflow: hidden; /*hides the default body's space*/
        margin: 0px;      /*hides the body's scrolls*/
    }      
    div.controls {
         margin: 0px 10px;
         font-size: 14px;
         font-family: Tahoma;
         color: #404040;
         height: 80px;
      }
</style>
<script>

	var formObj = [
		{type:"settings", offsetTop:12, name:"connectionInfo", labelAlign:"left"},
		{type:"input", name:"ciName", label:"커넥션이름", required:true}, 
		{type:"input", name:"ciUrl", label:"접속URL", required:true},
		{type:"input", name:"ciPort", label:"PORT번호", validate:"ValidInteger", required:true},
		{type:"input", name:"ciDatabase", label:"데이타베이스", required : true}, 
		{type:"input", name:"ciUser", label:"유저", required : true},
		{type:"password", name:"ciPwd", label:"비밀번호", required : true},
		{type:"input", name:"ciEtc", label:"기타"},
		{type:"input", name:"uId", label:"유저아이디", required : true},
		{type:"block", blockOffset:0, list:[
			{type:"button", name:"saveBtn", value:"저장"},
			{type:"newcolumn"},
			{type:"button", name:"cancelBtn", value:"취소"}
		]}
	];
	
	var bodyLayout;
	dhtmlxEvent(window, "load", function(){
		bodyLayout = new dhtmlXLayoutObject(document.body, "5C");
		bodyLayout.cells("a").setWidth(400);
		var aForm = bodyLayout.cells("a").attachForm(formObj,true);
		var cForm = bodyLayout.cells("c").attachEditor();
		
		aForm.attachEvent("onButtonClick", function(id){
			if(id=="saveBtn"){
				if(aForm.validate()){
					aForm.send("${root}/connection/insert", "post", callback);
				}
			}else if(id=="cancelBtn"){
				aForm.clear();
			}
			
			var aLay = bodyLayout.cells("b");
			aLay.setText("Connection Info List");
			var aToolbar = aLay.attachToolbar();
			aToolbar.addButton("adddb",1,"add Connector");
			aToolbar.addButton("condb",2,"Connection");
			aToolbar.attachEvent("onClick",function(id){
				//alert(id);
			})
			var au = new AjaxUtil("${root}/connection/db_list",null,"get");
			au.setCallbackSuccess(callback1);
			au.send(); 
			
		});
	
		function callback(loader, res){
			var res = JSON.parse(res);
			alert(res.msg);
		}
		
		function callback1(res){
			console.log(res);
			dbTree = aLay.attachTreeView({
				items: res.dbList
				});
			dbTree.setImagePath("${rPath}/dx/skins/web/imgs/dhxtree_web/");
			dbTree.enableDragAndDrop(true);
		}
	})
	
		
	
</script>
<body>
	<div id="winVP"></div>
</body>
</html>