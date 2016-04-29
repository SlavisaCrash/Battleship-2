<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

<title>BattleShip</title>
</head>
<body>
<center>
	  
		<div id="parentbox">
		
			<c:forEach var="i" begin="0" end="9">
				<c:forEach var="j" begin="0" end="9">
					<c:set var="k" value="${i},${j}"></c:set>
							<c:choose>
								<c:when test="${battleship[k] eq 1}">
									<div class="cell" style="background-color: yellow;"></div>
								</c:when>
								<c:when test="${battleship[k] eq 2}">
									<div class="cell" style="background-color: red;"></div>
								</c:when>
								<c:when test="${battleship[k] eq 3}">
									<div class="cell" style="background-color: green;"></div>
								</c:when>
								<c:when test="${battleship[k] eq 4 }">
									<div class="cell" style="background-color: blue;"></div>
								</c:when>
								<c:otherwise>
									<div class="cell"></div>
								</c:otherwise>
							</c:choose>
					
				</c:forEach>
				<br>
			</c:forEach>
			
		</div>
		<br>
		<form action="battleship.do" method="POST">
			<input type="submit" value="Place Ships">
		</form>
		
	</center>
</body>
</html>