<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/demo.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
		<title>Home Page</title>
	</head>
	<body>
		<form:form action="processSentence" modelAttribute="sentence">
			Sentence : <form:input path="text" placeholder="Enter a sentence to count words and their occurrences" class="width"/>
			<br/><br/>
			Sort Words By : Alphabetically<form:radiobutton path="sortedBy" value="alphabetically" checked="checked"/>
					        By Occurrence<form:radiobutton path="sortedBy" value="occurrence"/>
			<br/><br/>
			<input type="submit"/>
		</form:form>
	</body>
</html>