<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des acteurs</title>
</head>
<body>
	<h1>Hello</h1>
	
	<c:forEach var="item" items="${ liste }">
		<p>
			<c:out value="${ item.getNom() } -- ${ item.getPrenom() }"/>
		</p>
	</c:forEach>
	
</body>
</html>