<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Hot Topics</title>
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
								<a href="http://${carousel.uri}" target="_blank"><img src="${carousel.image}" width="600" height="400" alt=""></a>
							</li>
						</c:forEach>
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
				entrance: "bottom", // This option let you determine the direction of the fly in entrance animation when all the cards appears. Available options are "bottom", "left", "right", and "top". The default value is "bottom".
			    column: 4, // The plugin also let you define how the card will be displayed and aligned. You can set the column of cards here. The default value is 4. 
			    margin: "1%", // You can define the margins between each cards here. Percentage is currently support at this point. The default is "1%".
			    selector: "> li", // You can define a custom selector if you do not want to use ul and li tags. This option accepts the normal CSS selector. The default value is "> li" 
			    hoverTilt: "right", // Define the tilt direction when cards are hovered here. Available options are "right", "left", "up", and "down". The default value is "right".
			    triggerSelector: "> li a", // You can also define a custom selector for the trigger button here. The default value is "> li a" which will use the link inside a list as a trigger to activate the card. 
			    cardFlyDirection: "all", // You can define the card fly animation when the modal appears here. Available options are "all", "top", "bottom", "left", and "right". The default value is "all" which will have the cards fly in from all direction and stack up under the opened modal
			    closeButton: "X", // You can define the content of the close button here. Change this to false to prevent the plugin from automatically generating the close button. The default string is "X".
			    flipButton: "Flip", // You can define the content of the flip button here. Change this to false to prevent the plugin from automatically generating the flip button. The default string is "Flip".
			    navigation: true, // Set this to true to allow users to navigate from one card to another when modal is opened. Change it to false to disable it. The default value is true.
			    beforeOpen: null, // A callback function that will be executed before the modal opens.
			    afterOpen: null // A callback function that will be executed after the modal opens.
			});
		});
	</script>
</body>
</html>