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
		<div class="panel panel-default">
			<div class="panel-heading">编辑用户信息</div>
			<div class="panel-body">
				<form class="form-horizontal" role="form">
					<input type="hidden" name="user.id">
					<div class="form-group">
						<label for="userName" class="col-sm-2 control-label">用户名称</label>
						<div class="col-xs-4">
							<input type="email" class="form-control " id="userName" name="user.userName"
								placeholder="User name">
						</div>
					</div>
					<div class="form-group">
						<label for="userPass" class="col-sm-2 control-label">用户密码</label>
						<div class="col-xs-4">
							<input type="password" class="form-control" name="user.userPass"
								id="userPass" placeholder="Pass word">
						</div>
					</div>
					<div class="form-group">
						<label for="userType" class="col-sm-2 control-label">用户类型</label>
						<div class="col-xs-4">
							<input type="text" class="form-control" name="user.userType"
								id="userType" placeholder="User type">
						</div>
					</div>
					<div class="form-group">
						<label for="userOrg" class="col-sm-2 control-label">用户所属组织</label>
						<div class="col-xs-4">
							<input type="text" class="form-control" name="user.userOrg"
								id="userOrg" placeholder="User org">
						</div>
					</div>
					<div class="btn-group">
					    <button type="button" class="btn btn-success">确定</button>
					    <button type="button" class="btn btn-default">取消</button>
				    </div>
				</form>
			</div>
		</div>
	</div>

</body>
<%@include file="../commons/jsp/JavaScript.jsp"%>
<script>
$('.btn-success').on('click',function(){
	$.post('UserMgAction',$('.form-horizontal').serialize(),function(json){
        if(json.success){
        	location.href="UserAction?actionType=select";
        }else{
        	alert('保存失败！');
        }
	});
});
</script>
</html>