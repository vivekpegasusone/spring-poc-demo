<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="demotag" uri="demotag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Word Counter</title>
	</head>
	<body>
		<c:choose>
    		<c:when test="${empty result.wordOccurrence}">
        		<c:out value="Please provide input string."/>
    		</c:when>
    		<c:otherwise>
        		<demotag:words value="${result.wordOccurrence}"/>	
    		</c:otherwise>
		</c:choose>
	</body>
</html>
