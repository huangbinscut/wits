<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="tel.wits.servicematrix.model.infomodel.IndividualModel"%>
<%@ include file="../inc/header.jsp"%>

<html>
	<head>
		<!-- Meta -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!-- End of Meta -->
		
		<!-- Page title -->
		<title>WITS - 微智  - 机器人市场</title>
		<!-- End of Page title -->
		
		<!-- Libraries -->
		<link href="<c:url value='/css/pages/robotmarket.css'/>" rel="stylesheet" type="text/css" media="all"></link>

		<script type="text/javascript" src="<c:url value='/js/pages/robotmarket.js'/>"></script>
		<!-- End of Libraries -->	
		
		
	</head>
	<body>
		<!-- Container -->
		<div id="container">
		
			<!-- Header -->
			<div id="header">
				
				<!-- Top -->
				<%@ include file="../inc/topbar.jsp"%>
				<!-- End of Top-->
			
				<!-- The navigation bar -->
				<%@ include file="../inc/navbar.jsp"%>
				<!-- End of navigation bar" -->
				
				<!-- Search bar -->
				<div id="search">
					<form action="http://baidu.com">
						<p>
							<input type="submit" value="" class="but" />
							<input type="text" name="q" value="搜索资源" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;" />
						</p>
					</form>
				</div>
				<!-- End of Search bar -->
			
			</div>
			<!-- End of Header -->
			
			<!-- Background wrapper -->
			<div id="bgwrap">

				<!-- Main Content -->
				<div id="content">
					<div id="main">
					
						<p>请选购您需要的机器人：</p>
					
						<div class="pad20">
					
							<ul class="dash">
							    <c:forEach items="${prototypePage.items}" var="t" varStatus="status">
							
								<li>
									<a href="#" title='${ t.description }' class="tooltip bigbut">
										<img src="<c:url value='/images/test/prototype.jpg' />" alt='${ t.description }' />
										<span>&lt;${ t.prototypeName }&gt;</span>
									</a>
									<div>&nbsp;&nbsp;类型：${ t.functionType }</div>
									<div>&nbsp;&nbsp;售价：${ t.price/100 } 元</div>
									<div>&nbsp;&nbsp;售出：${ t.purchaseCount } 台</div>
									<div>
										<a href="#" class="smallbut" >[购买]</a>
									</div>
								</li>
								
								</c:forEach>
							</ul>
							<!-- End of Big buttons -->
							
						</div>
						<hr/>
						<span class="page">
							<common:pageV2 bean="prototypePage" url="/prototype/list" optimize="true"/>
						</span>
					</div>					
				</div>
				<!-- End of Main Content -->
 	
				
				<!-- Sidebar -->
				<div id="sidebar">		
						
					<!-- Tabs -->
					<div id="sidebartabs">
						<ul class="whitetabsnav">
							<li>
								<img src="<c:url value='/images/icons/3_48x48.png'/>" alt="" class="smallicon"/><a href="#sidebartabs-1">我的机器人</a>
							</li>
						</ul>
						
						<!-- First tab -->
						<div id="sidebartabs-1">
 							<div class="sort">
								<div class="box ui-widget ui-widget-content ui-corner-all portlet">
		
									<div class="portlet-header">
										社交网络型机器人
									</div>
									<div class="portlet-content">
										<div class="sidebardiv">
											<!-- Form -->
											<form method="post" action="#">
											<div class="display_open">
												<h2 class="normalh2 tooltip"  title="好友动态关注机器人,及时获取好友动态">
													<img src="<c:url value='/images/test/robot.jpg' />" alt="好友动态关注机器人,及时获取好友动态" class="smalliconupup"/>
													&lt;好友关注机器人&gt;
													<a href="#" class="display_open">
														<img src="<c:url value='/images/icons/Glyph Add.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_open"/>
														<img src="<c:url value='/images/icons/Glyph Remove.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_close"/>
													</a>
												</h2>
												<ul  class="display_close">
													<li><a href="#"><img src="<c:url value='/images/icons/Document Checklist.png' />" alt="功能参数" title="功能参数" class="smalliconupup tooltip"/>  设置关注好友列表</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/rulers.png' />" alt="规则参数" title="规则参数" class="smalliconupup tooltip"/>  设置触发规则</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Clock Alarm.png' />" alt="周期参数" title="周期参数" class="smalliconupup tooltip"/>  设置执行周期</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Cog.png' />" alt="个性参数" title="个性参数" class="smalliconupup tooltip"/>  个性化机器人</a></li>
												</ul>
											</div>
											<div class="display_open">
												<h2 class="normalh2 tooltip"  title="社会热点动态关注机器人,及时获取各大社交网络社会热点">
													<img src="<c:url value='/images/test/robot.jpg' />" alt="社会热点动态关注机器人,及时获取各大社交网络社会热点" class="smalliconupup"/>
													&lt;社会热点机器人&gt;
													<a href="#" class="display_open">
														<img src="<c:url value='/images/icons/Glyph Add.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_open"/>
														<img src="<c:url value='/images/icons/Glyph Remove.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_close"/>
													</a>
												</h2>
												<ul  class="display_close">
													<li><a href="#"><img src="<c:url value='/images/icons/Document Checklist.png' />" alt="功能参数" title="功能参数" class="smalliconupup tooltip"/>  设置热点来源</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/rulers.png' />" alt="规则参数" title="规则参数" class="smalliconupup tooltip"/>  设置触发规则</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Clock Alarm.png' />" alt="周期参数" title="周期参数" class="smalliconupup tooltip"/>  设置执行周期</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Cog.png' />" alt="个性参数" title="个性参数" class="smalliconupup tooltip"/>  个性化机器人</a></li>
												</ul>
											</div>
											<div class="display_open">
												<h2 class="normalh2 tooltip" title="关键词信息关注机器人,利用关键词过滤获取各大社交网络信息" >
													<img src="<c:url value='/images/test/robot.jpg' />" alt="关键词信息关注机器人,利用关键词过滤获取各大社交网络信息" class="smalliconupup"/>
													&lt;关键词机器人&gt;
													<a href="#" class="display_open">
														<img src="<c:url value='/images/icons/Glyph Add.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_open"/>
														<img src="<c:url value='/images/icons/Glyph Remove.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_close"/>
													</a>
												</h2>
												<ul  class="display_close">
													<li><a href="#"><img src="<c:url value='/images/icons/Document Checklist.png' />" alt="功能参数" title="功能参数" class="smalliconupup tooltip"/>  设置关键词列表</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/rulers.png' />" alt="规则参数" title="规则参数" class="smalliconupup tooltip"/>  设置触发规则</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Clock Alarm.png' />" alt="周期参数" title="周期参数" class="smalliconupup tooltip"/>  设置执行周期</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Cog.png' />" alt="个性参数" title="个性参数" class="smalliconupup tooltip"/>  个性化机器人</a></li>
												</ul>
											</div>
											</form>
											<!-- End of Form -->	
		
										</div>
									</div>
									
								</div>
								
								<div class="box ui-widget ui-widget-content ui-corner-all portlet">
									<div class="portlet-header">娱乐型机器人</div>
									<div class="portlet-content">
										<div class="sidebardiv">
											<!-- Form -->
											<form method="post" action="#">
											<div class="display_open">
												<h2 class="normalh2 tooltip"  title="追踪剧集机器人,及时获取剧集更新信息">
													<img src="<c:url value='/images/test/robot.jpg' />" alt="追踪剧集机器人,及时获取剧集更新信息" class="smalliconupup"/>
													&lt;剧集追新机器人&gt;
													<a href="#" class="display_open">
														<img src="<c:url value='/images/icons/Glyph Add.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_open"/>
														<img src="<c:url value='/images/icons/Glyph Remove.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_close"/>
													</a>
												</h2>
												<ul  class="display_close">
													<li><a href="#"><img src="<c:url value='/images/icons/Document Checklist.png' />" alt="功能参数" title="功能参数" class="smalliconupup tooltip"/>  设置关注剧集列表</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/rulers.png' />" alt="规则参数" title="规则参数" class="smalliconupup tooltip"/>  设置触发规则</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Clock Alarm.png' />" alt="周期参数" title="周期参数" class="smalliconupup tooltip"/>  设置执行周期</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Cog.png' />" alt="个性参数" title="个性参数" class="smalliconupup tooltip"/>  个性化机器人</a></li>
												</ul>
											</div>
											<div class="display_open">
												<h2 class="normalh2 tooltip"  title="美女图片机器人,定期获取美女图片发布源更新">
													<img src="<c:url value='/images/test/robot.jpg' />" alt="美女图片机器人,定期获取美女图片发布源更新" class="smalliconupup"/>
													&lt;美女图片机器人&gt;
													<a href="#" class="display_open">
														<img src="<c:url value='/images/icons/Glyph Add.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_open"/>
														<img src="<c:url value='/images/icons/Glyph Remove.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_close"/>
													</a>
												</h2>
												<ul  class="display_close">
													<li><a href="#"><img src="<c:url value='/images/icons/Document Checklist.png' />" alt="功能参数" title="功能参数" class="smalliconupup tooltip"/>  设置图片来源</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/rulers.png' />" alt="规则参数" title="规则参数" class="smalliconupup tooltip"/>  设置触发规则</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Clock Alarm.png' />" alt="周期参数" title="周期参数" class="smalliconupup tooltip"/>  设置执行周期</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Cog.png' />" alt="个性参数" title="个性参数" class="smalliconupup tooltip"/>  个性化机器人</a></li>
												</ul>
											</div>
											<div class="display_open">
												<h2 class="normalh2 tooltip"  title="追踪网络小说机器人,及时获取网络小说更新信息">
													<img src="<c:url value='/images/test/robot.jpg' />" alt="追踪网络小说机器人,及时获取网络小说更新信息" class="smalliconupup"/>
													&lt;小说追新机器人&gt;
													<a href="#" class="display_open">
														<img src="<c:url value='/images/icons/Glyph Add.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_open"/>
														<img src="<c:url value='/images/icons/Glyph Remove.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_close"/>
													</a>
												</h2>
												<ul  class="display_close">
													<li><a href="#"><img src="<c:url value='/images/icons/Document Checklist.png' />" alt="功能参数" title="功能参数" class="smalliconupup tooltip"/>  设置关注小说列表</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/rulers.png' />" alt="规则参数" title="规则参数" class="smalliconupup tooltip"/>  设置触发规则</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Clock Alarm.png' />" alt="周期参数" title="周期参数" class="smalliconupup tooltip"/>  设置执行周期</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Cog.png' />" alt="个性参数" title="个性参数" class="smalliconupup tooltip"/>  个性化机器人</a></li>
												</ul>
											</div>
											<div class="display_open">
												<h2 class="normalh2 tooltip"  title="追踪影讯机器人,及时获取院线影讯更新信息">
													<img src="<c:url value='/images/test/robot.jpg' />" alt="追踪影讯机器人,及时获取院线影讯更新信息" class="smalliconupup"/>
													&lt;影讯机器人&gt;
													<a href="#" class="display_open">
														<img src="<c:url value='/images/icons/Glyph Add.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_open"/>
														<img src="<c:url value='/images/icons/Glyph Remove.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_close"/>
													</a>
												</h2>
												<ul  class="display_close">
													<li><a href="#"><img src="<c:url value='/images/icons/Document Checklist.png' />" alt="功能参数" title="功能参数" class="smalliconupup tooltip"/>  设置关注院线列表</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/rulers.png' />" alt="规则参数" title="规则参数" class="smalliconupup tooltip"/>  设置触发规则</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Clock Alarm.png' />" alt="周期参数" title="周期参数" class="smalliconupup tooltip"/>  设置执行周期</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Cog.png' />" alt="个性参数" title="个性参数" class="smalliconupup tooltip"/>  个性化机器人</a></li>
												</ul>
											</div>
											</form>
											<!-- End of Form -->	
										</div>
									</div>
								</div>
								
								<div class="box ui-widget ui-widget-content ui-corner-all portlet">
									<div class="portlet-header">购物型机器人</div>
									<div class="portlet-content">
										<div class="sidebardiv">
											<!-- Form -->
											<form method="post" action="#">
											<div class="display_open">
												<h2 class="normalh2 tooltip"  title="商品动态关注机器人,及时获取商品更新信息">
													<img src="<c:url value='/images/test/robot.jpg' />" alt="商品动态关注机器人,及时获取商品更新信息" class="smalliconupup"/>
													&lt;商品关注机器人&gt;
													<a href="#" class="display_open">
														<img src="<c:url value='/images/icons/Glyph Add.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_open"/>
														<img src="<c:url value='/images/icons/Glyph Remove.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_close"/>
													</a>
												</h2>
												<ul  class="display_close">
													<li><a href="#"><img src="<c:url value='/images/icons/Document Checklist.png' />" alt="功能参数" title="功能参数" class="smalliconupup tooltip"/>  设置关注商品列表</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/rulers.png' />" alt="规则参数" title="规则参数" class="smalliconupup tooltip"/>  设置触发规则</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Clock Alarm.png' />" alt="周期参数" title="周期参数" class="smalliconupup tooltip"/>  设置执行周期</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Cog.png' />" alt="个性参数" title="个性参数" class="smalliconupup tooltip"/>  个性化机器人</a></li>
												</ul>
											</div>
											<div class="display_open">
												<h2 class="normalh2 tooltip"  title="社会热点动态关注机器人,及时获取各大社交网络社会热点">
													<img src="<c:url value='/images/test/robot.jpg' />" alt="店铺动态关注机器人,及时获取店铺更新信息" class="smalliconupup"/>
													&lt;店铺关注机器人&gt;
													<a href="#" class="display_open">
														<img src="<c:url value='/images/icons/Glyph Add.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_open"/>
														<img src="<c:url value='/images/icons/Glyph Remove.png' />" alt="参数设置" title="参数设置" class="smalliconupupright tooltip display_close"/>
													</a>
												</h2>
												<ul  class="display_close">
													<li><a href="#"><img src="<c:url value='/images/icons/Document Checklist.png' />" alt="功能参数" title="功能参数" class="smalliconupup tooltip"/>  设置关注店铺列表</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/rulers.png' />" alt="规则参数" title="规则参数" class="smalliconupup tooltip"/>  设置触发规则</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Clock Alarm.png' />" alt="周期参数" title="周期参数" class="smalliconupup tooltip"/>  设置执行周期</a></li>
													<li><a href="#"><img src="<c:url value='/images/icons/Cog.png' />" alt="个性参数" title="个性参数" class="smalliconupup tooltip"/>  个性化机器人</a></li>
												</ul>
											</div>
											</form>
											<!-- End of Form -->	
		
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- End of First tab -->
						
					</div>
					<!-- End of Tabs -->		
							
				</div>
				<!-- End of Sidebar -->

 	
 			
			</div>
			<!-- End of bgwrap -->
			
			
		</div>
		<!-- End of Container -->
		
		<!-- Footer -->
		<div id="footer">
			<p class="mid">
				<a href="#" title="返回页首" class="tooltip">返回页首</a>&middot;<a href="#" title="主面板" class="tooltip">主面板</a>&middot;<a href="#" title="设置" class="tooltip">设置</a>&middot;<a href="#" title="退出登录" class="tooltip">退出登录</a>
			</p>
			<p class="mid">
				<!-- Change this to your own once purchased -->
				&copy; Wits.tel 2012. All rights reserved.
				<!-- -->
			</p>
		</div>
		<!-- End of Footer -->


	</body>
</html>


