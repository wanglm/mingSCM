<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../commons/jsp/Tablib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="commons/style/bootstrap/bootstrap.min.css" rel="stylesheet">
<link href="commons/style/bootstrap/navbar-fixed-top.css"
	rel="stylesheet">
<title>Excel显示</title>
</head>
<body>
	<%@include file="../commons/jsp/Head.jsp"%>
	<div class="container">
		<div class="class=row row-offcanvas row-offcanvas-right">
			<div class="toolbar">
				<span class="add-on glyphicon glyphicon-time"><i class="icon-calendar"></i></span> 
				<input type="text" class="datepicker sd" placeholder="开始时间">
				<span class="icon-minus glyphicon glyphicon-arrow-right"></span>
				<input type="text" class="datepicker ed"placeholder="结束时间">
				<span class="add-on glyphicon glyphicon-user"></span>
				<input type="text" id="user-name" placeholder="用户名称">
				<button class="btn btn-primary" type="submit" id="query">查询</button>
				<a href="UserAction?actionType=insert"><span class="glyphicon glyphicon-plus pull-right"></span></a>
			</div>
			<div class="table-responsive">
				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th>用户ID</th>
							<th>用户名</th>
							<th>用户密码</th>
							<th>用户类别</th>
							<th>用户所属组织</th>
							<th>录入ID</th>
							<th>录入时间</th>
							<th>修改ID</th>
							<th>修改时间</th>
							<th width="5%" class="TAC">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="user">
							<tr id="tr_${user.id}">
								<td>${user.userId}</td>
								<td>${user.userName}</td>
								<td>${user.userPass}</td>
								<td>${user.userType}</td>
								<td>${user.userOrg}</td>
								<td>${user.createId}</td>
								<td><ming:formatDate value="${user.createTime}"
												pattern="yyyy-MM-dd" /></td>
								<td>${user.updateId}</td>
								<td><ming:formatDate value="${user.updateTime}"
												pattern="yyyy-MM-dd"/></td>
								<td><a href="javascript:void(0)"><span
										class="glyphicon glyphicon-wrench" onclick="fUpdate(${user.id})"></span></a> <a
									href="javascript:void(0);" onclick="fDelete(${user.id})"><span
										class="glyphicon glyphicon-trash"></span></a></td>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<%@include file="../commons/jsp/JavaScript.jsp"%>
<script type="text/javascript">
//日期控件
$(".datepicker").datepicker({
        dateFormat:'yy-mm-dd'
    });
function fUpdate(id){
	location.href="UserAction?actionType=update&id="+id;
}
$('.btn-primary').click(function(){
     location.href = "UserAction?actionType=select&sd="+$('.sd').val()+"&ed="+$('.ed').val()+"&userName="+$('#user-name').val(); 
});
</script>
</html>