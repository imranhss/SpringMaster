<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="template.jsp"%>

<c:if test="${sessionScope.userId==null}">
	<%@include file="guest_menu.jsp"%>
	<h1 class="text-center">Welcome Guest</h1>
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.role==1}">
	<!-- guest menu -->
	<%@include file="admin_menu.jsp"%>	
	<h1 class="text-center">Welcome Admin</h1>
	
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.role==2}">

	
	<%@include file="user_menu.jsp"%>	
	<h1 class="text-center">Welcome User</h1>

</c:if>