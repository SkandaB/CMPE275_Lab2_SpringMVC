<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../../fragments/header.jsp" />

<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">�</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>Phone Detail</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${phone.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Number</label>
		<div class="col-sm-10">${phone.number}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Description</label>
		<div class="col-sm-10">${phone.description}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Address</label>
		<div class="col-sm-10">${phone.address.street} ${phone.address.city} ${phone.address.state} ${phone.address.zip} </div>
	</div>
	
</div>

<jsp:include page="../../fragments/footer.jsp" />

</body>
</html>