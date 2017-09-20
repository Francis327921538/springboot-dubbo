<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style>
.nav-list>li .submenu>li>a{font-size:16px; font-family:'FZLTXIHJW';}
.no-skin .nav-list>li>a{background:#3b6dde !important; color:#fff;}
.no-skin .nav-list>li.open{background-color:#2e4c84 !important; }
.no-skin .nav-list>li.open>a{color:#fff;background-color:#2e4c84 !important;}
.no-skin .nav-list>li.open>a:link,.no-skin .nav-list>li.open>a:visited,.no-skin .nav-list>li.open>a:hover ,.no-skin .nav-list>li.open>a:active,.no-skin .nav-list>li.open>a:focus{
color:#fff;background-color:#2e4c84;}
.no-skin .nav-list>li.open:link,.no-skin .nav-list>li.open:visited,.no-skin .nav-list>li.open:hover ,.no-skin .nav-list>li.open:active,.no-skin .nav-list>li.open:focus{
color:#fff;background-color:#2e4c84;}
.menu-text,.nav-list>li>a>.menu-icon,.nav-list li.active>a>.arrow, .nav-list li.open>a>.arrow, .nav-list li:hover>a>.arrow{
color:#f6f6f6;background-color:#2e4c84;}
.no-skin .nav-list>li{border-color:#266cad;}
</style>

<div id="sidebar" class="sidebar responsive ace-save-state">
	<script type="text/javascript">
		try {
			ace.settings.loadState('sidebar')
		} catch (e) {
		}
	</script>
    <!-- nav-list -->
		<ul class="nav nav-list">
			<c:import url="/common/menutree.jsp"></c:import>
		</ul>
	<!-- /.nav-list -->

	<!-- <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i id="sidebar-toggle-icon"
			class="ace-icon fa fa-angle-double-left ace-save-state"
			data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div> -->

</div>