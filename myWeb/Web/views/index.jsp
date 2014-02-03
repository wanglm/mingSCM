<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/jsp/Tablib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>登陆界面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="commons/style/bootstrap/bootstrap.min.css" rel="stylesheet">
<link href="commons/style/bootstrap/navbar-fixed-top.css"
	rel="stylesheet">
<link href="commons/style/bootstrap/carousel.css" rel="stylesheet">
</head>
<body class="myBody">
	<%@include file="../commons/jsp/Head.jsp"%>
	<!-- Carousel-->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<img src="commons/img/valenca.jpg" alt="">
				<div class="container">
					<div class="carousel-caption">
						<h1>赛场聚焦</h1>
						<p>上周六曼联3-1击败西汉姆，取得各项赛事4连胜。</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img src="commons/img/old.jpg" alt="">
				<div class="container">
					<div class="carousel-caption">
						<h1>转会传闻</h1>
						<p>土超豪门加拉塔萨雷明星中场斯内德冬季转会期有望来到梦剧场？</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img src="commons/img/champions.jpg" alt="">
				<div class="container">
					<div class="carousel-caption">
						<h1>关注青训</h1>
						<p>随着贾努扎伊的爆发，其在曼联一线队的主力位置日益稳固，林佳德，鲍威尔在租借球队连续闪耀是否能为下赛季进入一线队提供筹码？</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span
			class="glyphicon glyphicon-chevron-left"></span></a> <a
			class="right carousel-control" href="#myCarousel" data-slide="next"><span
			class="glyphicon glyphicon-chevron-right"></span></a>
	</div>
	<!-- /.carousel -->
	<div class="container">

		<!-- Three columns of text below the carousel -->
		<div class="row">
			<div class="col-lg-4">
				<img class="img-circle" src="commons/img/champions2008.jpg" alt=""
					height="300px" width="350px">
				<h2>欧冠之路</h2>
				<p>欧冠十六强抽签结束，曼联的对手奥林匹亚斯堪称十六强对手里面最弱，曼联能否顺利拿下比赛，还需要全体人员的努力。。。</p>
				<p>
					<a class="btn btn-default" href="#" role="button">详细 &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle" src="commons/img/ferge.jpg" alt=""
					height="300px" width="350px">
				<h2>联赛争霸</h2>
				<p>联赛排名第九，后爵爷时代的曼联在联赛举步维艰，莫耶斯该思考下如何让其治下英伦第一豪门延续的辉煌，否则质疑的声音会不绝于耳。。。</p>
				<p>
					<a class="btn btn-default" href="#" role="button">详细 &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle" src="commons/img/little.jpg" alt=""
					height="300px" width="350px">
				<h2>杯赛征程</h2>
				<p>足总杯顺利挺进4强，面对老对手桑德兰，曼联有机会进入决赛，但是面对可能的决赛对手曼城，曼联夺冠似乎无比艰难。。。</p>
				<p>
					<a class="btn btn-default" href="#" role="button">详细 &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
		</div>
		<!-- /.row -->
	</div>
	<div class="modal fade bs-modal-sm" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<form id="dLoginForm">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">用户登录</h4>
					</div>
					<div class="modal-body">
						<p>
						<h2 class="form-signin-heading">填写用户信息</h2>
						<input type="text" name="user.userName" class="form-control"
							placeholder="用户名" required autofocus> <input
							type="password" name="user.userPass" class="form-control"
							placeholder="密码" required> <label class="checkbox">
							<input type="checkbox" value="remember-me"> 记住我
						</label>
						</p>
					</div>
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary btn-block">登录</button>
					<button type="button" class="btn btn-default btn-block"
						data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
</body>
<%@include file="../commons/jsp/JavaScript.jsp"%>
<script type="text/javascript">
	var vHref = $('#dLogin');
	function fIndexLogin() {
		$(vHref).text('请登录');
	}
	$(fIndexLogin());
	vHref.click(function() {
		$('.modal').modal('show');
	});
	$('.btn-primary')
			.bind(
					'click',
					function() {
						$.ajax({
									type : 'POST',
									url : 'LoginAction',
									data : $('#dLoginForm').serialize(),
									success : function(json) {
										if (json.success) {
											var vLi = "<li class='dropdown'><a class='dropdown-toggle'"
													+ "data-toggle='dropdown' href='javascript:void(0)'>个人管理</a>"
													+ "<ul class='dropdown-menu'>"
													+ "<li><a href='javascript:void(0)' onclick='fExcel()'>excel导入</a></li>"
													+ "<li><a href='javascript:void(0)' onclick='fUpdateUser("
													+ json.id
													+ ")'>用户信息修改</a></li>"
													+ "<li><a href='javascript:void(0)' onclick='fSelect()'>用户管理</a></li>"
													+ "</ul>"
													+ "</li><li><a href='javascript:void(0)' onclick='fExit()'>退出登录</a></li>"
											$('#dLi').replaceWith(vLi);
											$('.modal').modal('toggle');
										}
									}
								});
					});
	//获取用户信息
	function fUpdateUser(id) {
		return false;
		$.post('UserAction', id, function(json) {

		});
	}

	//用户管理查询
	function fSelect() {
		location.href = "UserAction?actionType=select";
	}

	function fExcel() {
		$.post("ExcelAction", {
			excelName : "TGSOCWEB_SSH_工作日报_王禄铭_20140103(W1).xls"
		}, function(json) {
			if (json.success) {
				alert("导入成功!");
			}

		});
	}

$('.myBody').css('min-height',0);
</script>
</html>