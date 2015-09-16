<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>example-spring-jetty</title>
   	<link rel="stylesheet" type="text/css" href="css/example.css"></link>
  </head>
  <body>
  	<p>JSP</p>
  
    <img src="img/spring_logo.png"></img>
    
    <c:set var="now" value="<%=new java.util.Date()%>" />
    <p><fmt:formatDate pattern="yyyy-MM-dd" value="${now}"/></p>
    
  	<table>
	    <tr>
	        <th>Name</th><th>Number</th>
	    </tr>
	    <c:forEach items="${students}" var="student">
	    <tr>
	        <td>${student.firstAndLastName}</td> <td>${student.id}</td>
	    </tr>
    	</c:forEach>
  	</table>
  </body>
</html>