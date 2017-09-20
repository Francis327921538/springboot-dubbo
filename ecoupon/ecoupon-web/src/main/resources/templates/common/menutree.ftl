<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style>
body,h1,h2,h3,h4,h5,h6,p,ul,li,a,small,span,label{font-family:'微软雅黑';}
 .nav-list>li .submenu>li a>.menu-icon{
	top:19px
 }
 .open{background-color:#2e4c84;} 
.no-skin .sidebar-toggle{background-color:#284273;}
/* .no-skin .sidebar{border-color:#fff; } */
/* .no-skin .nav-list>li{border-color:#fff; } */
.no-skin .nav-list>li .submenu>li {
    border-top:none;
    background-color: #1a2e55 !important; 
    color: #fff;
}
.nav-list>li:last-child{border:0 !important;}
.no-skin .nav-list>li .submenu>li>a:link,.no-skin .nav-list>li .submenu>li>a:visited,.no-skin .nav-list>li .submenu>li>a:hover,.no-skin .nav-list>li .submenu>li>a:active, .no-skin .nav-list>li .submenu>li>a:focus{
    color: #f6f6f6;
    font-size:14px;
    background-color: #1a2e55 !important; 
    border:none;
}
.no-skin .nav-list>li>.submenu:before, .no-skin .nav-list>li>.submenu>li:before{border:none !important;}
.nav-list>li>.submenu>li:before{border:none !important;}
.no-skin .sidebar{background-color:#223a6a !important;}
.no-skin .nav-list>li>a{background:#2e4c84 !important;} 
.nav-list>li>a>.menu-icon,.nav-list>li a>.arrow,.menu-text{color:#f6f6f6 !important;font-size:16px; background-color: #2e4c84; }
.btn-success, .btn-success.focus, .btn-success:focus{border-radius:4px;backgrund-color:#22b2e9 !important;font-size:16px;}
.mrbot10{margin-bottom:10px;}
.btn-lg>.ace-icon { margin-right: 0px;}
 select.input-lg:focus{border-color:#61b988;} 
select.input-lg{width:210px !important; height: 44px;font-size:14px;}
/* select option:hover, select.form-control option:focus {
    background-color: #61b988;
} */
.no-skin .nav-list>li .submenu{border:#2e4c84 !important;}
</style>
<c:choose>

     <c:when test='${not isChildMenu}'>
				<c:forEach items="${sysMenus}" var="sysmenu" varStatus="status">
					<c:choose>
						<c:when test="${sysmenu.menuId==currentReqMenu.parent.menuId}">
							<li class="active open">
						</c:when>
						<c:otherwise>
							<li class="">
						</c:otherwise>
					</c:choose>
						<a href="<%=basePath %>${sysmenu.backstgUrl}" class="dropdown-toggle"> <i
							class="menu-icon fa ${sysmenu.icon}"></i> <span class="menu-text">
								${sysmenu.menuName} </span>
								<c:if test="${not empty  sysmenu.children}">
									<b class="arrow fa fa-angle-down"></b>
								</c:if>
								
						</a><b class="arrow"></b>
						<c:if test="${not empty  sysmenu.children}">
							<c:set var="sysMenus" value="${sysmenu.children}" scope="request"></c:set>
							<c:set var="isChildMenu" value="true" scope="request"></c:set>
							<c:import url="/common/menutree.jsp"></c:import>
						</c:if>
					</li>
				</c:forEach>
     </c:when>
     <c:otherwise>
        <ul class="submenu">
				<c:forEach items="${sysMenus}" var="sysmenu">
					<c:choose>
						<c:when test="${sysmenu.menuId==currentReqMenu.menuId}">
							<li class="active">
						</c:when>
						<c:otherwise>
							<li class="">
						</c:otherwise>
					</c:choose>
					<a href="<%=basePath %>${sysmenu.backstgUrl}?menuid=${sysmenu.menuId}">
						<i class="menu-icon fa fa-caret-right"></i> 
						${sysmenu.menuName} 
					</a> 
					<b class="arrow"></b>
						<c:if test="${not empty  sysmenu.children}">
							<c:set var="sysMenus" value="${sysmenu.children}" scope="request"></c:set>
							<c:set var="isChildMenu" value="true" scope="request"></c:set>
							<c:import url="/common/menutree.jsp"></c:import>
						</c:if>
					</li>
				</c:forEach>
		</ul>
     </c:otherwise>
</c:choose>

