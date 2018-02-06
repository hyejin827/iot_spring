<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>

var au =  new AjaxUtil("${root}/user/listb",null,"GET","json");
function callback(res){
	$("#userTable").bootstrapTable('load',{data:res.userList});
}
au.setCallbackSuccess(callback);
au.send();
</script>
<body>
<div class="container">
<table data-toggle="table" id="userTable" data-url="${root}/user/listb">
	<thead>
		<tr>
			<th data-field="uiNo">번호</th>
			<th data-field="uiName">이름</th>
			<th data-field="uiAge">나이</th>
			<th data-field="uiId">아이디</th>
			<th data-field="uiPwd">비밀번호</th>
			<th data-field="address">주소</th>
			<th data-field="ciNo">클래스 넘버</th>
			<th data-field="uiRegdate">가입날짜</th>
		</tr>
	</thead>
</table>
</div>
</body>
</html>