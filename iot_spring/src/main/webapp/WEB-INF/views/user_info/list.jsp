<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<div align="center">
<div id="gridbox" style="width:550;height:400px;"></div>
<script>
	var mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath("${dPath}/imgs/");
	mygrid.setHeader("번호,이름,아이디,비밀번호,이메일");
	mygrid.setInitWidths("50,100,100,100,200");
	mygrid.setColAlign("left,left,left,left,left");
	mygrid.setColTypes("ro,ed,ro,ed,ed");
	mygrid.setColSorting("int,str,str,str,str");
	mygrid.setColumnIds("uNo,uName,uId,uPwd,uEmail");
	mygrid.init(); //실행이됨
	
	var au = new AjaxUtil("${root}/userInfo/list",null,"GET","json");
	function callback(res){
		alert(res);
		mygrid.parse({data:res.userInfoList},"js");
	}
	au.setCallbackSuccess(callback);
	au.send();
	
</script>
</div>
</body>
</html>