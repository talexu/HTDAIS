<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Create an animated card layout that let you flip to see
	the content</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/default.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css" />" />

<!-- Edit Below -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.jcarousel.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jcarousel.basic.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.tip_cards.js" />"></script>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/jcarousel.basic.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/tip_cards.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/elusive-webfont.css" />" />
<title>Insert title here</title>
</head>
<body>
	<%-- <img src="<c:url value="/resources/image.jpg" />"> --%>
	<div class="wrapper">
            <div class="jcarousel-wrapper">
                <div class="jcarousel">
                    <ul>
                    	<c:forEach var="carousel" items="${carousels}" varStatus="theCount">
							<li>
								<img src="${carousel.image}" width="600" height="400" alt="">
							</li>
						</c:forEach>
                    	
                        <!-- <li><img src="http://image13-c.poco.cn/mypoco/myphoto/20121007/17/43847200201210071724162935008641488_000_640.jpg" width="600" height="400" alt=""></li>
                        <li><img src="http://image13-c.poco.cn/mypoco/myphoto/20121007/17/43847200201210071724162935008641488_000_640.jpg" width="600" height="400" alt=""></li>
                        <li><img src="http://image13-c.poco.cn/mypoco/myphoto/20121007/17/43847200201210071724162935008641488_000_640.jpg" width="600" height="400" alt=""></li>
                        <li><img src="http://image13-c.poco.cn/mypoco/myphoto/20121007/17/43847200201210071724162935008641488_000_640.jpg" width="600" height="400" alt=""></li>
                        <li><img src="http://image13-c.poco.cn/mypoco/myphoto/20121007/17/43847200201210071724162935008641488_000_640.jpg" width="600" height="400" alt=""></li>
                        <li><img src="http://image13-c.poco.cn/mypoco/myphoto/20121007/17/43847200201210071724162935008641488_000_640.jpg" width="600" height="400" alt=""></li> -->
                    </ul>
                </div>

				<a href="#" class="jcarousel-control-prev">&lsaquo;</a>
				<a href="#" class="jcarousel-control-next">&rsaquo;</a>
                
				<p class="jcarousel-pagination">
					
				</p>
            </div>
        </div>
	
	<div class="page_container">
		<ul class="tips">
			<c:forEach var="news" items="${newses}" varStatus="theCount">
				<li><a href="#tip${theCount.count}">${news.summary}</a>

					<div id="tip${theCount.count}" class="tip">
						<h1>${news.title}</h1>
						<p>${news.mainbody}</p>
					</div></li>
			</c:forEach>
		</ul>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".tips").tip_cards({
				navigation : false
			});
		});
	</script>
</body>
</html>