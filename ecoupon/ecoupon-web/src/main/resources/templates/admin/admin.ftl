<!DOCTYPE html>
<html>
	<!-- head -->
	<#include "/header/head.ftl"/>
	<!-- /head -->
	<body class="no-skin">
		<div id="navbar" class="navbar navbar-default ace-save-state">
			<#include "/navbar/navbar.ftl"/>
			<!-- /.navbar-container -->
		</div>

		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>
			<#include "/sidebar/sidebar.ftl"/>
			<!-- /sidebar -->
			<div class="main-content" id="vue-page">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="<%=basePath%>/enterpInfor/addView">主页</a>
							</li>
							<li class="active">${menuDir}</li>
						</ul><!-- /.breadcrumb -->
						
						<div class="nav-search" id="nav-search">
							
								<span class="input-icon">
									<input @keyup.enter="getSearchPage(1)" v-model="searchQuery" type="text" placeholder="搜索..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i  style="cursor: pointer;" class="ace-icon fa fa-search nav-search-icon" @click="getSearchPage(1)"></i>
								</span>
							
						</div><!-- /.nav-search -->
					</div>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12" id="vue-page">
								<!-- PAGE CONTENT -->
								<#include "${jspPageDir}"/>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<#include "/footer/footer.ftl"/>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->
			<#include "/basic-scripts/basic-scripts.ftl"/>
		<!-- /basic scripts -->
	</body>
</html>
