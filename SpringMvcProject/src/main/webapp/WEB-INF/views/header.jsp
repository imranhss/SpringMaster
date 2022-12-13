<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${sessionScope.user==null}">
	<%@include file="guest_menu.jsp"%>
</c:if>

<c:if test="${sessionScope.user!=null && sessionScope.role==1}">
	<%@include file="admin_menu.jsp"%>
</c:if>

<c:if test="${sessionScope.user!=null && sessionScope.role==2}">
	<%@include file="user_menu.jsp"%>
</c:if>