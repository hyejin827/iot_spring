<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<div align="center">
<div id="gridbox" style="width:650;height:400px;"></div>
<script>
	var mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath("${dPath}/imgs/");
	mygrid.setHeader("번호,이름,아이디,비밀번호,이메일,관리자모드");
	mygrid.setInitWidths("50,100,100,100,200,100");
	mygrid.setColAlign("left,left,left,left,left,left");
	mygrid.setColTypes("ro,ed,ro,ed,ed,ro");
	mygrid.setColSorting("int,str,str,str,str,str");
	mygrid.setColumnIds("uNo,uName,uId,uPwd,uEmail,admin");
	mygrid.init(); //실행이됨
	
	var au = new AjaxUtil("${root}/userInfo/list",null,"GET","json"); //"json"
	function callback(res){
		mygrid.parse({data:res},"js"); //res.userInfoList
	}
	
	mygrid.attachEvent("onRowSelect", function(id,ind){
		alert(mygrid.getRowData(id).uName);
	});
	
	au.setCallbackSuccess(callback);
	au.send();
	
</script>
</div>
</body>
</html>