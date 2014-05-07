<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Create an animated card layout that let you flip to see
	the content</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/default.css" />" />
<!-- Edit Below -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.tip_cards.js" />"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/tip_cards.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/elusive-webfont.css" />" />
<title>Insert title here</title>
</head>
<body>
	<%-- <img src="<c:url value="/resources/image.jpg" />"> --%>
	<div class="page_container">
		<ul class="tips">
			<c:forEach var="news" items="${newses}" varStatus="theCount">
			   <li><a href="#tip${theCount.count}">${news.summary}</a>

				<div id="tip${theCount.count}" class="tip">
					<h1>${news.title}</h1>
					<p>${news.mainbody}</p>
				</div></li>
			</c:forEach>
			<!-- <li><a href="#tip1">Tip 1: See What videos your friends are
					posting and adjust friendships accordingly.</a>

				<div id="tip1" class="tip">
					<h1>See What videos your friends are posting</h1>
					<p>Whether you're browsing youtube.com or its mobile app, when
						you're signed in with your Google Account, you can see videos
						recommended for you.</p>
				</div></li>
			<li><a href="#tip2">Tip 1: See What videos your friends are
					posting and adjust friendships accordingly.</a>

				<div id="tip2" class="tip">
					<h1>See What videos your friends are posting</h1>
					<p>Whether you're browsing youtube.com or its mobile app, when
						you're signed in with your Google Account, you can see videos
						recommended for you.</p>
				</div></li>
			<li><a href="#tip3">Tip 1: See What videos your friends are
					posting and adjust friendships accordingly.</a>

				<div id="tip3" class="tip">
					<h1>See What videos your friends are posting</h1>
					<p>Whether you're browsing youtube.com or its mobile app, when
						you're signed in with your Google Account, you can see videos
						recommended for you.</p>
				</div></li>
			<li><a href="#tip4">Tip 1: See What videos your friends are
					posting and adjust friendships accordingly.</a>

				<div id="tip4" class="tip">
					<h1>See What videos your friends are posting</h1>
					<p>Whether you're browsing youtube.com or its mobile app, when
						you're signed in with your Google Account, you can see videos
						recommended for you.</p>
				</div></li>
			<li><a href="#tip5">Tip 1: See What videos your friends are
					posting and adjust friendships accordingly.</a>

				<div id="tip5" class="tip">
					<h1>See What videos your friends are posting</h1>
					<p>Whether you're browsing youtube.com or its mobile app, when
						you're signed in with your Google Account, you can see videos
						recommended for you.</p>
				</div></li>
			<li><a href="#tip6">Tip 1: See What videos your friends are
					posting and adjust friendships accordingly.</a>

				<div id="tip6" class="tip">
					<h1>See What videos your friends are posting</h1>
					<p>Whether you're browsing youtube.com or its mobile app, when
						you're signed in with your Google Account, you can see videos
						recommended for you.</p>
				</div></li>
			<li><a href="#tip7">Tip 1: See What videos your friends are
					posting and adjust friendships accordingly.</a>

				<div id="tip7" class="tip">
					<h1>See What videos your friends are posting</h1>
					<p>Whether you're browsing youtube.com or its mobile app, when
						you're signed in with your Google Account, you can see videos
						recommended for you.</p>
				</div></li>
			<li><a href="#tip8">Tip 1: See What videos your friends are
					posting and adjust friendships accordingly.</a>

				<div id="tip8" class="tip">
					<h1>See What videos your friends are posting</h1>
					<p>Whether you're browsing youtube.com or its mobile app, when
						you're signed in with your Google Account, you can see videos
						recommended for you.</p>
				</div></li>
			<li><a href="#tip9">Tip 1: See What videos your friends are
					posting and adjust friendships accordingly.</a>

				<div id="tip9" class="tip">
					<h1>See What videos your friends are posting</h1>
					<p>Whether you're browsing youtube.com or its mobile app, when
						you're signed in with your Google Account, you can see videos
						recommended for you.</p>
				</div></li>
			<li><a href="#tip10">Tip 1: See What videos your friends are
					posting and adjust friendships accordingly.</a>

				<div id="tip10" class="tip">
					<h1>See What videos your friends are posting</h1>
					<p>Whether you're browsing youtube.com or its mobile app, when
						you're signed in with your Google Account, you can see videos
						recommended for you.</p>
				</div></li> -->
		</ul>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".tips").tip_cards({
			      navigation: false
			    });
		});
	</script>
</body>
</html>