<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>

<head>
<jsp:include page="head.jsp"></jsp:include>
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
					<div class="staff-slider tiles-row">
						<div class="cus-heading">${games.name}</div>
						<div class="swiper-wrapper1">
							<c:forEach var="gameItem" items="${games.games}">
								<div class="swiper-slide">
									<a href="/play/${gameItem.id }" class="column-center-image">
										<img class="col-img-2 img" src="${gameItem.imgurl }" alt="img">
									</a>
									<p class="video_title">${gameItem.name }</p>
								</div>

							</c:forEach>
						</div>
					</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
		<div class="clear"></div>
	</div>
	<!-- <script>
		var swiper = new Swiper('.cusslides', {
			spaceBetween : 30,
			autoplay : 4000,
			slidesPerView : 1,
			// autoplay: {
			//     delay: 2500,
			//     disableOnInteraction: false,
			// },
			pagination : {
				el : '.swiper-pagination',
				clickable : true,
			},
		});
	</script> -->
</body>