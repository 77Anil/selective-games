<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sidebar-menu-scroll">
	<a class="current-menu" href="/"><img
		src="http://gameninja.in/html/icons/home.png" /><em>Home</em></a>

	<c:forEach var="item" items="${cats}">
		<a href="/cat/${item.id}"><img src="${item.icon }" /><em>${item.name }</em></a>
	</c:forEach>
</div>