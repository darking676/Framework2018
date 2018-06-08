<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script> 
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>비트교육센터</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-3"><a href="." >HOME</a></div>
			<div class="col-md-3"><a href="./list.do">LIST</a></div>
			<div class="col-md-3"></div>
		</div>
		<div class="row">
			<div class="col-md-12">
			<!-- content start -->
			<div class="jumbotron">
	 			<h2>입력 페이지</h2>
			 	<p>입력하실 내용을 작성해주세요</p>
			</div>
			<form action="insert.do" class="form-horizontal">
				<div class="form-group">
				<label for="sabun" class="col-sm-2 control-label">sabun</label>
				<div class="col-sm-10">
				<input placeholder="사번을 입력" class="form-control" type="text" name="sabun" id="sabun" />
				</div>
				</div>
				<div class="form-group">
				<label for="name" class="col-sm-2 control-label">name</label>
				<div class="col-sm-10">
				<input placeholder="이름을 입력" class="form-control" type="text" name="name" id="name" />
				</div>
				</div>
				<div class="form-group">
				<label for="pay" class="col-sm-2 control-label">pay</label>
				<div class="col-sm-10">
				<input placeholder="금액을 입력" class="form-control" type="text" name="pay" id="pay" />
				</div>
				</div>
				<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10">
				<button class="btn btn-default">입력</button>
				</div>
				</div>
			</form>
			<!-- content end -->
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
			<address>
			  <strong>비트캠프.</strong><br>
			  비트캠프 서울시 서초구 서초동 1327-15 비트아카데미빌딩<br>
			  <abbr title="Phone">P:</abbr> 02-3486-9600
			</address>
			<p class="text-center">
			Copyright &copy; 비트캠프 All rights reserved.
			</p>
			</div>
		</div>
	</div>
</body>
</html>



















