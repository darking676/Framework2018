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
<div class="container">
  <!-- Stack the columns on mobile by making one full-width and the other half-width -->
<div id="menu" class="row">
  <div class="col-md-12">
  	<!-- menu start -->
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
	      <a class="navbar-brand" href="../hello.bit">비트 교육센터</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="../hello.bit">Home <span class="sr-only">(current)</span></a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">게시판 <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="list.bit">List</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="add.bit">Add</a></li>
	          </ul>
	        </li>
	      </ul>
	      
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
  	<!-- menu end -->
  </div>
</div>
<div class="row content">
  <div class="col-md-12">
  	<!-- content start -->
  	<div class="jumbotron">
	  <h1>입력 페이지</h1>
	  <p>H2 DB의 샘플 데이터 추가 입니다.</p>
	  <p><a onclick="window.history.back();"  class="btn btn-primary btn-lg" href="#" role="button">Back</a></p>
	</div>
	
	<form class="form-horizontal" action="insert.bit" method="post">
	  <div class="form-group">
	    <label for="sabun" class="col-sm-2 control-label">sabun</label>
	    <div class="col-sm-10">
	      <input type="text" name="sabun" class="form-control" id="sabun" placeholder="sabun"/>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="name" class="col-sm-2 control-label">name</label>
	    <div class="col-sm-10">
	      <input type="text" name="name" class="form-control" id="name" placeholder="name"/>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="pay" class="col-sm-2 control-label">pay</label>
	    <div class="col-sm-10">
	      <input type="text" name="pay" class="form-control" id="pay" placeholder="pay"/>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">입 력</button>
	    </div>
	  </div>
	</form>
  	<!-- content end -->
  </div>
</div>

<div id="footer" class="row">
  <div class="col-md-12">
  	<!-- footer start -->
  	<p class="text-center">Copyright &copy; 비트캠프 All rights reserved.</p>
  	<!-- footer end -->
  </div>
</div>

</div>
</body>
</html>