<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="<%=request.getContextPath()%>">비트 교육센터</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.jsp">Home</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Guest <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="list.action">list</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="add.action">Add</a></li>
          </ul>
        </li>
      </ul>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container">
  <div class="row">
  <div class="col-md-12">
  	<div class="jumbotron">
	  <h1>환영합니다!</h1>
	  <p>이곳은 스트럿츠 연습용 사이트 입니다.</p>
	  <p><a class="btn btn-primary btn-lg" href="list.action" role="button">게시판 이동</a></p>
	</div>
  </div>
</div>

<div class="row">
  <div class="col-md-12">
  	<!-- content start -->
  	<div class="page-header">
	  <h1>입력페이지</h1>
	</div>
<form class="form-horizontal" action="insert.action" method="post">
  <div class="form-group">
    <label for="sabun" class="col-sm-2 control-label">sabun</label>
    <div class="col-sm-10">
      <input type="text" value="${sabun }" name="sabun" class="form-control" id="sabun" placeholder="사번" />
    </div>
  </div>
  <div class="form-group">
    <label for="name" class="col-sm-2 control-label">name</label>
    <div class="col-sm-10">
      <input type="text" value="${name }" name="name" class="form-control" id="name" placeholder="이름" />
    </div>
  </div>
  <div class="form-group">
    <label for="pay" class="col-sm-2 control-label">pay</label>
    <div class="col-sm-10">
      <input type="text" value="${pay }" name="pay" class="form-control" id="pay" placeholder="금액" />
    	<div class="edit">${pay }</div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">전 송</button>
      <button type="reset" class="btn btn-default">취 소</button>
    </div>
  </div>
</form>
  	<!-- content end -->
  </div>
</div>
<div class="row">
  <div class="col-md-12 text-center">
  	Copyright &copy; 비트캠프 All rights reserved.
  </div>
</div>
</div>

</body>
</html>













