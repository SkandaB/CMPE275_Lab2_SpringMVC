<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Yahoo!!</title>
</head>
<body>

	<table id="Users " border="1">
		<tr>
			<td>ID</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Title</td>
			<td>Street</td>
		</tr>
		  <c:forEach items="${AllUsers}" var="user">    
		<tr>
			<td>${user.id}</td>
			<td>${user.firstname}</td>
			<td>${user.lastname}</td>
			<td>${user.title}</td>
			<td>${user.address.state}</td>
		</tr>
		</c:forEach>
	</table>
	</body>
	</html>