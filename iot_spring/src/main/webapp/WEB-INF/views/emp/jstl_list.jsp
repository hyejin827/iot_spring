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
<br>
<div class="container">
<table class="table table-bordered">
	<thead>
		<tr>
			<th>선택</th>
			<th>번호</th>
			<th>이름</th>
			<th>월급</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
		<c:forEach items="${empList}" var="emp">
		<form action="${root}/emp/delete" method="get">
			<tr>
				<td><input type="checkbox"></td>
				<td>${emp.empNo}</td>
				<td><input type="text" name="empName" id="empName" value="${emp.empName}"></td>
				<td><input type="text" name="empSal" id="empSal" value="${emp.empSal}"></td>
				<td><button>수정</button></td>
				<td><button>삭제</button></td>
			</tr>
			</form>
		</c:forEach>
</table>
</div>
<div align="center">
<a href="${pPath}/emp/write"><button>사원정보추가</button></a>
<a href="${pPath}/emp/view"><button>상세정보보기</button></a>
</div>
</body>
</html>