<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EDIT PAGE</h1>
	<form action="update.action" method="post">
		<div>
			<label for="sabun">sabun</label> ${bean.sabun }
			<input type="hidden" name="sabun" id="sabun" value="${bean.sabun }" />
		</div>
		<div>
			<label for="name">name</label>
			<input type="text" name="name" id="name" value="${bean.name }" />
		</div>
		<div>
			<label for="nalja">nalja</label> ${bean.nalja }
			<input type="hidden" name="nalja" id="nalja" value="" disabled="disabled" />
		</div>
		<div>
			<label for="pay">pay</label>
			<input type="text" name="pay" id="pay" value="${bean.pay }" />
		</div>
		<div><button type="submit">수정</button></div>
	</form>
</body>
</html>