<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/phone" method="POST">
        ID : <input name="id" type="text" disabled/> 
        </br>
        Number : <input name="number" type="text" />
        </br>
        Description : <input name="description" type="text" />
        </br>
        Address 
        </br>
       	City : <input name="city" type="text" />
       	State : <input name="state" type="text" />
       	Street : <input name="street" type="text" />
       	Zip code : <input name="zip_code" type="text" /> 
        
         <input type="submit" />
    </form>
</body>
</html>