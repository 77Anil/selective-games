<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <div class="header header-dark">
            <a href="/" class="header-logo">
                <img src="/images/lol.png" alt=" Games" class="img-fluid"/>
            </a>
            <c:if test="${cats != null }">
            <a href="#" class="header-icon header-icon-1 close-sidebar-mask"></a>
            <a href="#" class="header-icon header-icon-1 open-sidebar">
                <em class="line-1"></em>
                <em class="line-2"></em>
                <em class="line-3"></em>
            </a>
      		 </c:if>
        </div>
