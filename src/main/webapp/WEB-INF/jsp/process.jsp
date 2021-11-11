<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript" src="/scripts/common.js"></script>
<style>
.cusloader {
	justify-content: center;
	align-items: center;
	display: flex;
	flex-direction: column;
	min-height: calc(100vh - 150px);
}
</style>
</head>
<body>
	<main class="d-flex flex-column min-vh-100">
		<jsp:include page="nav.jsp" />
		<div class="bodyWrapper flex-grow-1">
			<div class="cusloader">
				<c:choose>
					<c:when test="${scope == 1 }">
						<div class="spinner-border" style="width: 3rem; height: 3rem;"
							role="status">
							<span class="sr-only">Loading...</span>
						</div>
						<script type="text/javascript">
							callSubCheck(${ani},`${service}`);
						</script>
					</c:when>
					<c:otherwise>
						<i class="fa fa-exclamation-circle" style="font-size:60px;" aria-hidden="true"></i>
					</c:otherwise>
				</c:choose>
				<h4 class="text-dark text-center px-2 pt-2">${message}</h4>

			</div>

		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</main>
</body>
</html>