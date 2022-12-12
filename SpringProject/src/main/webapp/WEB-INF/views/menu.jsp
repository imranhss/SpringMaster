<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="template.jsp" %>

<c:if test="${sessionScope.userId==null}">
	<!-- guest menu -->
	
	
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.role==1}">
	<!-- guest menu -->
	<%@include file="admin_menu.jsp" %>	
	Admin Menu
	
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.role==2}">
	<!-- guest menu -->
	<%@include file="user_menu.jsp" %>	
	USer Menu
	
</c:if>