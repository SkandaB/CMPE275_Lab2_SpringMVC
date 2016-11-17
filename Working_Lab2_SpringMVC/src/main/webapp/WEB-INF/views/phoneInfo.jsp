<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
	<script>
		function deleteFunction() {
			alert("in delete function");
			
			
			 var xmlhttp;
			 var deleteurl = "/phone/${phone.id}";
			 
			 alert(deleteurl);
		    xmlhttp = new XMLHttpRequest();
		    xmlhttp.open("DELETE", deleteurl,true);
		    
		    xmlhttp.send(); 
			
		}
	</script>

	<script>
		function updateFunction() {
			
			var number =  document.getElementById("number").value;
			var description =  document.getElementById("description").value;
			
			var city =  document.getElementById("city").value;
			var state =  document.getElementById("state").value;
			var street =  document.getElementById("street").value;
			var zip =  document.getElementById("zip_code").value;
			var users = document.getElementById("users").value;
			alert(users);
			
			
			 var xmlhttp;
			 var updateurl = "/phone/${phone.id}?number="+ number +
					 "&description=" + description +
					 "&city="+ city+
					 "&state="+state +
					 "&street="+street+
					 "&zip_code="+zip+
					 "&uid="+users;

		    xmlhttp = new XMLHttpRequest();
		    xmlhttp.open("POST", updateurl,true);
		    
		    xmlhttp.send(); 
			
		}
	</script>

	<form action="/phone" method="POST">
		ID : <input name="ID" type="text" value=${phone.id } disabled>
		</br> Number : <input id="number" name="number" type="text"
			value=${phone.number}> </br> Description : <input id="description"
			name="description" type="text" value=${phone.description} > </br>

		Address </br> City : <input id="city" name="city" type="text"
			value=${phone.address.city} > State : <input id="state"
			name="state" type="text" value=${phone.address.state}> Street
		: <input id="street" name="street" type="text"
			value=${phone.address.street}> Zip code : <input
			id="zip_code" name="zip_code" type="text" value=${phone.address.zip}>
		</br>
		<form:select path="users" items="${users}" multiple="true" />

		<select id="users" name="users" multiple="true">
			<c:forEach var="user" items="${users}">
				<option value="${user.id}"> select </option>

			</c:forEach>
		</select> <input type="hidden" name="users" value="1" />
	</form>



	<button type="button" name="update" onclick="updateFunction();">Update</button>

	<button type="button" name="delete" onclick="deleteFunction();">Delete</button>

</body>
</html>