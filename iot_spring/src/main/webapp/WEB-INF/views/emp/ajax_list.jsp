<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>

var au =  new AjaxUtil("${root}/emp/lista",null,"GET","json");
function callback(res){
	$("#empTable").bootstrapTable('load',{data:res.empList});
}
au.setCallbackSuccess(callback);
au.send();
</script>
<body>
<div class="container">
<table data-toggle="table" id="empTable" data-url="${root}/emp/lista">
	<thead>
		<tr>
			<th data-field="empNo">번호</th> 
			<th data-field="empName">이름</th>
			<th data-field="empSal">월급</th>
		</tr>
	</thead>
</table>
<a href="${pPath}/emp/write"><button>사원정보추가</button></a>
<a href="${pPath}/user/user_list"><button>유저리스트로 이동</button></a>
</div>
</body>
</html>