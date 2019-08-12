<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ninja Gold Game</title>
	<style><%@include file="/WEB-INF/css/style.css"%></style>
	<script type="text/javascript" src="/WEB-INF/js/app.js"></script>
</head>
<body>

	<div class='container'>
		
		<div class="score">
			<h2>Your Gold: <input class="goldBox" type="text" name="myGold" placeholder="<c:out value="${ninjaGold}"/>"></h2>
			
		</div>	
		
		<div class="prospects">
			
			<div class="box">
				<h3>Farm</h3>
				<p>(earn 10 - 20 gold)</p>
				
				<form method="POST" action="/director">
					<input class="button" type="submit" value="Find Gold!">
					<input type="hidden" name="location" value="farm">
					<input type="hidden" name="min" value="10">
					<input type="hidden" name="max" value="20">
				</form>
				
			</div>
			<div class="box">
				<h3>Cave</h3>
				<p>(earn 5 - 10 gold)</p>
				
				<form method="POST" action="/director">
					<input class="button" type="submit" value="Find Gold!">
					<input type="hidden" name="location" value="cave">
					<input type="hidden" name="min" value="5">
					<input type="hidden" name="max" value="10">
				</form>
				
			</div>
			<div class="box">
				<h3>House</h3>
				<p>(earn 2 - 5 gold)</p>
				
				<form method="POST" action="/director">
					<input class="button" type="submit" value="Find Gold!">
					<input type="hidden" name="location" value="house">
					<input type="hidden" name="min" value="2">
					<input type="hidden" name="max" value="5">
				</form>
				
			</div>
			<div class="box">
				<h3>Casino</h3>
				<p>(earn/takes 0 - 50 gold)</p>
				
				<form method="POST" action="/director">
					<input class="button" type="submit" value="Find Gold!">
					<input type="hidden" name="location" value="casino">
					<input type="hidden" name="min" value="0">
					<input type="hidden" name="max" value="50">
				</form>
				
			</div>
			
		</div>
		
		<div class="activities">
			<h2>Activities:</h2>
			<div id="log">
    			<% Map<String, String> activitiesLog = (HashMap<String, String>) session.getAttribute("activitiesLog");%>
    			<table>
    				<TH>Activity</TH>
    				<TH>Timestamp</TH>
    				<c:forEach items="${activitiesLog}" var="entry">
    					<tr>
    						<td><c:out value="${entry.key}" /></td>
    						<td><c:out value="${entry.value}" /></td>
    					</tr>
    				</c:forEach>
    			</table>
</div>
			</div>
		</div>
	</div>
	
</body>
</html>