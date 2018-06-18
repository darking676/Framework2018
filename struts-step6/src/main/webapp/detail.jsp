<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>DETAIL PAGE</h1>
	<table>
		<tr>
			<td>사번</td>
			<td>${bean.sabun }</td>			
		</tr>
		<tr>
			<td>이름</td>
			<td>${bean.name }</td>			
		</tr>
		<tr>
			<td>날짜</td>
			<td>${bean.nalja }</td>			
		</tr>
		<tr>
			<td>금액</td>
			<td>${bean.pay }</td>			
		</tr>
	</table>
	<a href="edit.action?sabun=${bean.sabun }">[수정]</a>
	<a href="delete.action?sabun=${bean.sabun }">[삭제]</a>
</body>
</html>