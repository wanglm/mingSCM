<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/jsp/Tablib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="commons/style/bootstrap/bootstrap.min.css" rel="stylesheet">
<link href="commons/style/bootstrap/navbar-fixed-top.css"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../commons/jsp/Head.jsp"%>
	<div class="container">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
				<div class="col-xs-4">
				<input
					type="email" class="form-control " id="exampleInputEmail1"
					placeholder="Enter email">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
				<div class="col-xs-4"><input
					type="password" class="form-control" id="exampleInputPassword1"
					placeholder="Password">
				</div>
			</div>
			<button type="submit" class="btn btn-default pull-right">Submit</button>
		</form>
	</div>

</body>
<%@include file="../commons/jsp/JavaScript.jsp"%>
</html>