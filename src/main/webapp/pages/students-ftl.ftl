<!DOCTYPE HTML>
<html>
  <head>
    <title>example-spring-jetty</title>
   	<link rel="stylesheet" type="text/css" href="css/example.css"></link>
  </head>
  <body>
  	<p>Freemarker</p>
  
    <img src="img/spring_logo.png"></img>
    
    <#assign now = .now>
    <p>${now?string["yyyy-MM-dd"]}</p>
    
  	<table>
	    <tr>
	        <th>Name</th><th>Number</th>
	    </tr>
		<#list students as student>
	    <tr>
	        <td>${student.firstAndLastName}</td> <td>${student.id}</td>
	    </tr>
    	</#list>
  	</table>
  </body>
</html>