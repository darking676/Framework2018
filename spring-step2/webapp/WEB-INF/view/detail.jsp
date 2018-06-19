<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/spring-step2/css/bootstrap.min.css">
<style type="text/css">
	form{
		display: inline;
	}
</style>
<script type="text/javascript" src="/spring-step2/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/spring-step2/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$('#myModal').on('shown.bs.modal', function () {
			  $('#myInput').focus()
			});
		$('.collapse').collapse();
	});
</script>
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
		<h1>DETAIL PAGE</h1>
	</div>
<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="false">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
          사번 ${bean.sabun }번의 정보
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
        <p>이름 : ${bean.name }</p>
        <p>날짜 : ${bean.nalja }</p>
        <p>금액 : ${bean.pay }</p>
      </div>
    </div>
  </div>
  
</div>
<a href="edit.bit?idx=${bean.sabun }" role="btn" class="btn btn-default">수정</a>

<form action="delete.bit" method="post">
	<input type="hidden" name="idx" value="${bean.sabun }">
	<button class="btn btn-danger">삭제</button>
</form>

</body>
</html>










