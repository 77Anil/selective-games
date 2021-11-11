<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<head>
<jsp:include page="head.jsp"></jsp:include>
<style>
.heading {
	display: flex;
	justify-content: space-between;
}
</style>
</head>

<body>
	<div id="page-transitions">
		<div class="page-preloader page-preloader-dark">
			<div class="spinner"></div>
		</div>
		<jsp:include page="nav.jsp" />
		<!-- Main Small Icon Sidebar -->
		<div class="sidebar-menu sidebar-dark">
			<jsp:include page="siderbar.jsp" />
		</div>
		<div id="page-content" class="header-clear-large">
			<div id="page-content-scroll">
				<!--Enables this element to be scrolled -->
				<div class="container">
					<c:forEach var="item" items="${cats}">
						<div class="staff-slider">
							<div class="heading">
								<div class="cus-heading">
									<a href="/cat/${item.id}">${item.name}</a>
								</div>
								<div class="read-more">
									<a href="/cat/${item.id}">More </a>
								</div>
							</div>
							<div class="swiper-wrapper">
								<c:forEach var="gameData" items="${item.games}">
									<div class="swiper-slide">
										<a href="/play/${gameData.id}" class="column-center-image">
											<img class="col-img-2 img" src="${gameData.imgurl}" alt="img">
										</a>
										<p class="video_title">${gameData.name}</p>
									</div>
								</c:forEach>
							</div>
						</div>
					</c:forEach>
					<jsp:include page="footer.jsp" />
					<div class="clear"></div>
				</div>
			</div>
			<a href="#" class="back-to-top-badge"><i
				class="ion-android-arrow-dropup"></i>Back to Top</a>
		</div>
		<script type="text/javascript" src="/scripts/jquery.js"></script>
		<script type="text/javascript" src="/scripts/plugins.js"></script>
		<script type="text/javascript" src="/scripts/custom.js"></script>
		<script>
			var swiper = new Swiper('.cusslides', {
				spaceBetween : 30,
				autoplay : 4000,
				slidesPerView : 4,
				pagination : {
					el : '.swiper-pagination',
					clickable : true,
				},
			});
			var swiper = new Swiper('.playwin .swiper-container', {
				slidesPerView : 4,
				centeredSlides : true,
				spaceBetween : 5,
				autoplay : 10000,
				pagination : {
					el : '.swiper-pagination',
					clickable : true,
				},
				navigation : {
					nextEl : '.swiper-button-next',
					prevEl : '.swiper-button-prev',
				},
			});
		</script>
</body>