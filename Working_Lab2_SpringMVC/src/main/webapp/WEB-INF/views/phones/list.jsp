<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../../fragments/header.jsp" />

<body>

	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>All Phones</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Number</th>
					<th>Description</th>
					<th>Address</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="phone" items="${phones}">
				<tr>
					<td>
						${phone.ID}
					</td>
					<td>${phone.NUMBER}</td>
					<td>${phone.DESCRIPTION}</td>
					<td><c:forEach var="addr" items="${phone.address}" varStatus="loop">
						${addr}
    					<c:if test="${not loop.last}">,</c:if>
						</c:forEach></td>
					<td>
						<spring:url value="/users/${phone.ID" var="phoneUrl" />
						<spring:url value="/users/${phone.ID}/delete" var="deleteUrl" /> 
						<spring:url value="/users/${phone.ID}/update" var="updateUrl" />

						<button class="btn btn-info" onclick="location.href='${phoneUrl}'">Query</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="../../fragments/footer.jsp" />

</body>
</html>