<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
      div.controls {
         margin: 0px 10px;
         font-size: 14px;
         font-family: Tahoma;
         color: #404040;
         height: 80px;
      }
      div#winVP {
         position: relative;
         height: 350px;
         border: 1px solid #dfdfdf;
         margin: 10px;
      }
</style>
<script>
	var winF, popW;
	$(document).ready(function(){
		winF = new dhtmlXWindows(); //A base for a set of new windows
		winF.attachViewportTo("winVP"); //attaches a viewport to an existing object on the page
		popW = winF.createWindow("win1",20,30,300,300);//(id,x,y,width,height)
		popW.setText("로그인!");
		
		var formObj = [
			{type:"input", name:"uId", label:"아이디", required : true},
			{type:"password", name:"uPwd", label:"비밀번호", required : true},
			{type:"block", blockOffset:0, list:[
				{type:"button", name:"loginBtn", value:"로그인"},
				{type:"newcolumn"},
				{type:"button", name:"cancelBtn", value:"취소"}
			]}
		];
		
		var form = popW.attachForm(formObj,true);
		
		form.attachEvent("onButtonClick", function(id){
			if(id=="loginBtn"){
				if(form.validate()){
					form.send("${root}/userInfo/login", "post", callback);
				}
			} else if(id=="cancelBtn"){
				form.clear();
			}
		});
	})
	
	function callback(loader, res){
		var res = JSON.parse(res);
		alert(res.msg);
	}
	
	function setPopW(onOff){
		if(onOff){
			popW.show();
			return;
		}
		popW.hide();
	}
</script>
<body>
	<div id="winVP"></div>
	<div class="controls">
		<button onclick="setPopW(true)">떠라 창</button>
		<button onclick="setPopW(false)">숨어라 창</button>
	</div>
</body>
</html>