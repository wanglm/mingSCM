<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="javascript:void(0)">Manchester
				united</a>
		</div>
		<form class="navbar-form navbar-left" role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
			<button type="button" class="btn btn-default">查询</button>
		</form>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${userid !=null}">
						<li id="dLoginLi"><a href="javascript:void(0)">欢迎${username}登录本系统</a></li>
						<li><a href='javascript:void(0)' onclick='fExit()'>退出登录</a></li>
					</c:when>
					<c:otherwise>
						<li id="dLi"><a id="dLogin" href="javascript:void(0)"></a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="/myWeb">Home</a></li>
				<li><a href="javascript:void(0)">About</a></li>
			</ul>
		</div>
	</div>
</div>