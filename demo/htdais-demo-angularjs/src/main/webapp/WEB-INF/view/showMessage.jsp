<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h2>${message}</h2>
	</body>
</html>
 --%>

<html ng-app="phonecatApp">
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.7/angular.min.js"></script>
</head>
<body ng-controller="PhoneListCtrl">
	<h2>${message}</h2>
	<ul>
		<li ng-repeat="phone in phones">{{phone.name}}
			<p>{{phone.snippet}}</p>
		</li>
	</ul>
	<script>
		var ss = new Array();
		<c:forEach items="${students}" var="student" varStatus="status">
			ss.push({
				'name' : "${student.name}",
				'snippet' : "${student.snippet}"});
		</c:forEach> 
		var phonecatApp = angular.module('phonecatApp', []);

		phonecatApp.controller('PhoneListCtrl', function($scope) {
			/* $scope.phones = [ {
				'name' : "${student.name}",
				'snippet' : 'Fast just got faster with Nexus S.'
			}, {
				'name' : 'Motorola XOOM™ with Wi-Fi',
				'snippet' : 'The Next, Next Generation tablet.'
			}, {
				'name' : 'MOTOROLA XOOM™',
				'snippet' : 'The Next, Next Generation tablet.'
			} ]; */
			
			/* $scope.phones = ss; */
			
			$scope.phones = [
				<c:forEach items="${students}" var="student" varStatus="status">
				{
					'name' : "${student.name}",
					'snippet' : "${student.snippet}",
					},
				</c:forEach> 
				];
		});
	</script>
</body>
</html>