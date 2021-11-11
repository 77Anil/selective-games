<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
	<iframe style="height: 100vh; width: 100%;" src="${game.gameurl}"
		width="100%" height="100vh" frameborder="0" scrolling="no"></iframe>
</body>
</html>