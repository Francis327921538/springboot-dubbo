<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style>
body,h1,h2,h3,h4,h5,h6,p,ul,li,a,small,span,label{font-family:'微软雅黑';}
 .naveaaimg{width:429px; height:45px; padding:0; margin-top:8px;} 
.padd0{ padding:0;}
.navheaasm{margin-top:16px; font-size:20px; color:#fff; font-family:'微软雅黑';}
.ace-navb .nav-user-photo{border:0;}
.navbar-container{height:80px;background:#4784f5;}
.ace-navb>li>a{color:#fff;margin-top: 18px; font-size:16px;}
.ace-navb>li>a span small{ margin-top: -1px;}
.ace-navb>li.light-blue>a:focus, .ace-navb>li.light-blue>a:hover, .ace-navb>li.open.light-blue>a{ background-color: #fff; color:#000;}
/* .ace-navb>li{background-color:#fff !important} */
a{color:#fff;text-decoration:none;}
.ace-navb>li.light-blue>a{background:transparent;}
.lcexit{padding-top: 30px; background-color: #4b8aff;padding-left:20px; width: 160px;height: 80px; margin-right: -8%; text-align:left;}
.lcexit>li>a:link,.lcexit>li>a:hover,.lcexit>li>a:focus{background:transparent;color:#fff;} 
/* .lcexit:hover,.lcexit:focus,.lcexit li:hover,.lcexit li:focus{ background-color: #4b8affs;color:#fff;} */
.lcexit:hover,.lcexit>li:hover{background-color: #3a79ed !important;color:#fff;}
.ace-navb>li{width:100%;list-style:none;}
.ace-navb>li>a{font-size:14px;}
.ace-navb>li.light-blue>a:link,.ace-navb>li.light-blue>a:hover,.ace-navb>li.light-blue>a:focus{
background:transparent;color:#fff;}
.navba-search{position:relative;border-bottom:1px solid #dbe4fd;margin-top:26px;}
.navba-search>.input-icon>.ace-icon {
    padding: 0;
    z-index: 2;
    position: absolute;
    top: 1px;
    bottom: 1px;
    left: 210px;
    line-height: 30px;
    display: inline-block;
    color: #dbe4fd;
    font-size: 16px;
}
  .ace-navb {
    height: 100%;
    width:100%;
  /*   margin: 0px !important; */
}
.navba-search span.input-icon input{border:0;outline:none;background:transparent; color:#dbe4fd;z-index:11; margin-left: -30px;
    width: 248px; }
 ul ul, ol ul { list-style-type: none !important;}
.user-info {max-width:160px !important;}
.navbar-container{padding-right:0px !important;}
</style>
<div class="navbar-container ace-save-state" id="navbar-container">
				<div class="navbar-header pull-left col-xs-4 col-sm-4 col-md-4 col-lg-4 padd0">
					<a  href="{basePath}" class="navbar-brand col-xs-12 col-sm-12 col-md-12 col-lg-12 padd0">
					<img class="col-xs-3 col-sm-3 col-md-3 col-lg-3 naveaaimg" src="<%= basePath %>ace_assets/images/apply/lchtlogo.png"   alt=""/>
						<!-- <small class="col-xs-8 col-sm-8 col-md-8 col-lg-8 navheaasm">
							<i class="glyphicon glyphicon-music white"></i>
							两创示范工作管理系统
						</small> -->
					</a>
				</div>
						
		<!--navbar-buttons navbar-header  -->		<div class=" col-xs-3 col-sm-3 col-md-3 col-lg-3 pull-right " role="navigation">
					<ul class="nav ace-navb">
						<li class="light-blue dropdown-modal"> 
							<!-- <a data-toggle="dropdown" href="#" class="dropdown-toggle pull-left"> -->
							<a href="#" class="dropdown-toggle pull-left">
								<img class="nav-user-photo" src="{basePath}ace_assets/images/apply/lchtuser.png" alt="Jason's Photo">
								<span class="user-info">
									<small>欢迎您,
									 ${null == sessionScope.sysUser?sessionScope.comUser.name:sessionScope.sysUser.sysUserDetail.username} <br>
									 </small>
									 <%-- ${null == sysUser?"企业用户":sysUser.roles.iterator().next().description} --%> 
								</span>
							<!-- 	<i class="ace-icon fa fa-caret-down" style="color:#000"></i> -->
							</a>
							<ul class="pull-right lcexit ">
							<li>
									<a href="<%=basePath %>dologout">
									<img src="{basePath}ace_assets/images/apply/lchtexit.png" width="20"  height="22"/>
										<!-- <small> -->退出登录<!-- </small> -->
									</a>
								</li>
								</ul>
							<%-- <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close" style="left:auto !important; top:auto !important;">
								<li>
									<a href="<%=basePath %>dologout">
									<img src="{basePath}ace_assets/images/apply/lchtexit.png" width="20"  height="22"/>
										<i class="ace-icon fa fa-power-off"></i>
										退出登录
									</a>
								</li>
							</ul> --%>
						</li>
					</ul>
				</div>
			</div>