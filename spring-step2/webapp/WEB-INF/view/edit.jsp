<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script type="text/javascript" src="/spring-step2/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/spring-step2/js/bootstrap.min.js"></script>
</head>
<%
java.util.Enumeration<String> attr=request.getAttributeNames();
while(attr.hasMoreElements()){
	System.out.println(">>>"+attr.nextElement());
}
%>
<body>
<c:if test="${errMsg ne null }">
	<div class="alert alert-danger alert-dismissible" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>Error!</strong> ${errMsg }
	</div>
</c:if>

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
      <a class="navbar-brand" href="index.bit">비트교육센터</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.bit">Home <span class="sr-only">(current)</span></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">게시판 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="list.bit">리스트</a></li>
            <li><a href="add.bit">입력</a></li>
          </ul>
        </li>
      </ul>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<!-- content start -->
	<div class="page-header">
		<h1>EDIT PAGE</h1>
	</div>
	<form action="update.bit" method="post">
		<div class="form-group">
			<label for="sabun">sabun</label>
			<div class="well well-sm">${bean.sabun }</div>
			<input type="hidden" value="${bean.sabun }" name="sabun" id="sabun" class="form-control" />
		</div>
		<div class="form-group">
			<label for="name">name</label>
			<input type="text" value="${bean.name }" name="name" id="name" class="form-control" />
		</div>
		<div class="form-group">
			<label for="nalja">nalja</label>
			<div class="well well-sm">${bean.nalja }</div>			
			<input type="hidden" name="nalja" id="nalja" class="form-control" disabled="disabled" />
		</div>
		<div class="form-group">
			<label for="pay">pay</label>
			<input type="text" value="${bean.pay }" name="pay" id="pay" class="form-control" />
		</div>
		<button type="submit">수정</button>
		<button type="reset">취소</button>
	</form>
</body>
</html>










