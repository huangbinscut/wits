<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="tel.wits.servicematrix.model.infomodel.IndividualModel"%>
<%@ include file="../inc/header.jsp"%>

<html>
	<head>
		<!-- Meta -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!-- End of Meta -->
		
		<!-- Page title -->
		<title>WITS - 微智  - 信息主页</title>
		<!-- End of Page title -->
		
		<!-- Libraries -->
		<link href="<c:url value='/css/pages/resourceconsole.css'/>" rel="stylesheet" type="text/css" media="all"></link>

		<script type="text/javascript" src="<c:url value='/js/pages/resourceconsole.js'/>"></script>
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
					
							<!-- Dialog -->
							<div id="dialog" title="创造/分享信息!">
								<p>Welcome to <b>创造/分享信息!</b></p>
							</div>
							<!-- End of Dialog -->
 
						<div id="filterbar" class="pad20">
							<!-- Fieldset -->
							<fieldset class="workingfilter">
								<legend><img src="<c:url value='/images/icons/onebit_02.png'/>" alt="" class="smalliconup"/>搜索信息</legend>
								<p>
									<label>当前生效过滤条件：</label>
									<input type="checkbox" />java岛
									<input type="checkbox" />GMCC
									<input type="checkbox" />IBM
									<input type="checkbox" />java语言
									<input type="checkbox" />2012/12/21
									<input type="checkbox" />《java与模式》
								</p>
								
								<div class="sort">
									<div class="box ui-widget ui-widget-content ui-corner-all portlet">
			
										<div class="portlet-header">按时间/位置/知识过滤信息</div>
										<div class="portlet-content">
								
											<!-- Tabs -->
											<div id="mainfiltertabs">
												<ul class="whitetabsnav">
													<li><img src="<c:url value='/images/icons/onebit_15.png'/>" alt="" class="smallicon"/><a href="#mainfiltertabs-1">时间线视图</a></li>
													<li><img src="<c:url value='/images/icons/onebit_19.png'/>" alt="" class="smallicon"/><a href="#mainfiltertabs-2">地理位置视图</a></li>
													<li><img src="<c:url value='/images/icons/owl.jpg' />" alt="" class="smallicon"/><a href="#mainfiltertabs-3">知识视图</a></li>
												</ul>
												
												<!-- First tab -->
												<div id="mainfiltertabs-1">
												
													<ul class="smalldash">
														<li>
															<span>切换时间范围：</span>
														</li>										
														<li>
															<a href="#" title="时间刻度：小时" class="tooltip">
																<span>一天</span>
															</a>
														</li>
														<li>
															<a href="#" title="时间刻度：天" class="tooltip">
																<span>一周</span>
															</a>
														</li>
														<li>
															<a href="#" title="时间刻度：周" class="tooltip">
																<span>一个月</span>
															</a>
														</li>
													</ul>
							
													<hr/>
													
													<p>当前时间范围：一天（0点 - 24点）</p>
													<!-- Slider -->
													<div id="slider"></div>
													<!-- End of Slider -->
													<hr/>
												</div>
												<!-- End of First tab -->
												
												<!-- Second tab -->
												<div id="mainfiltertabs-2">
													<!-- Form -->
													<form method="post" action="#">
														<!-- Fieldset -->
															<p>
																<label for="locaitionfilter">按地名过滤信息: </label>
				 												<input class="mf" name="locationfilter" type="text" value="请输入地名定位" /> 
				 												<input class="button" type="submit" value="查找" />
				 												
															</p>
															<hr/>
															
																<div class="verticallist">
																	<h2 class="normalh2">相关搜索结果如下：</h2>
																	<ul>
																		<li><a href="#"><span>中国移动通信集团广东有限公司</span></a></li>
																		<li><a href="#"><span>	IBM国际商业机器公司</span></a></li>
																		<li><a href="#"><span>广州市天河区华景新城</span></a></li>
																	</ul>																										
																</div>
																<div class="gpsmap">
																	<img src="<c:url value='/images/test/gpsmap.jpg' />" alt=""/>
																</div>
															<hr/>
														<!-- End of fieldset -->
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Second tab -->
				
												<!-- Third tab -->
												<div id="mainfiltertabs-3">
													<!-- Form -->
													<form method="post" action="#">
														<!-- Fieldset -->
															<p>
																<label for="locaitionfilter">按知识结构过滤信息: </label>
				 												<input class="mf" name="locationfilter" type="text" value="请输入关键词" /> 
				 												<input class="button" type="submit" value="查找" />
				 												
															</p>
															<hr/>
															
																<div class="verticallist">
																	<h2 class="normalh2">相关搜索结果如下：</h2>
																	<ul>
																		<li><a href="#"><span>地理/岛屿/java岛</span></a></li>
																		<li><a href="#"><span>技术/IT/编程语言/java语言</span></a></li>
																		<li><a href="#"><span>书籍/艺术+IT/《java与模式》</span></a></li>
																	</ul>																										
																</div>
																<div class="gpsmap">
																	<img src="<c:url value='/images/test/socialmap.jpg' />" alt=""/>
																</div>
															<hr/>
														<!-- End of fieldset -->
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Third tab -->
								
											</div>
											<!-- End of Tabs -->
						
										</div>
									</div>
								</div>
					
							</fieldset>
							<!-- End of fieldset -->						
						</div>
					
						<div id="infoflowbar" class="pad20">
							<h2><img src="<c:url value='/images/icons/bonus48x48_21.png'/>" alt="" class="smalliconup"/>信息获取报告/信息流</h2>
							<hr/>
							
							<!-- Fieldset -->
							<fieldset class="infoflow">
								<legend>
									<img src="<c:url value='/images/icons/mail1.png'/>" alt="" class="smalliconupupup"/>
									<img src="<c:url value='/images/test/logorobot.jpg' />" alt="" class="smalliconupupup"/>
									<好友关注机器人> - 2013年5月25日执行报告
								</legend>
								<div class="message information">
									<p>
										报告机器人：<好友关注机器人>&nbsp;&nbsp;&nbsp;&nbsp;
										所有人：timearrow&nbsp;&nbsp;&nbsp;&nbsp;
										<br/>
										功能：定期获取关注好友的社交网络动态信息&nbsp;&nbsp;&nbsp;&nbsp;
										触发规则：定期时钟&nbsp;&nbsp;&nbsp;&nbsp;
										执行周期：每天&nbsp;&nbsp;&nbsp;&nbsp;
										<br/>
										执行时间：23时35分&nbsp;&nbsp;&nbsp;&nbsp;
										获取信息数：35条&nbsp;&nbsp;&nbsp;&nbsp;
										输出信息数：24条&nbsp;&nbsp;&nbsp;&nbsp;
										新信息数：15条&nbsp;&nbsp;&nbsp;&nbsp;
									</p>
								</div>
								<hr/>

								<div class="sort">
									<div class="box ui-widget ui-widget-content ui-corner-all portlet">
			
										<div class="portlet-header">输出信息列表</div>
										<!-- portlet-content -->
										<div class="portlet-content">
										
										<!-- infoflow -->
										<fieldset class="infoflow">
											<legend>
												<img src="<c:url value='/images/icons/mail1.png'/>" alt="" class="smalliconupupup"/>
												<img src="<c:url value='/images/test/sinaweibo.jpg' />" alt="" class="smalliconupupup"/>
												
											</legend>
											<p>
												<img src="<c:url value='/images/test/1.jpg' />" alt="" class="floatleft"/>
												SinaAppEngine：
												【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
											</p>
											<ul class="smalldashright">
												<li>
													<span>操作：</span>
												</li>										
												<li>
													<a href="#" title="收藏" class="tooltip">
														<span>收藏</span>
													</a>
												</li>
												<li>
													<a href="#" title="转发" class="tooltip">
														<span>转发</span>
													</a>
												</li>
												<li>
													<a href="#" title="备份" class="tooltip">
														<span>备份</span>
													</a>
												</li>
											</ul>
											<hr/>
																			
											<!-- Tabs -->
											<div id="infoflowtabs1">
												<ul class="whitetabsnav">
													<li><img src="<c:url value='/images/icons/Pictures.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs1-1">图片</a></li>
													<li><img src="<c:url value='/images/icons/Movies.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs1-2">视频</a></li>
													<li><img src="<c:url value='/images/icons/Music Blue.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs1-3">音乐</a></li>
													<li><img src="<c:url value='/images/icons/onebit_19.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs1-4">地图</a></li>
													<li><img src="<c:url value='/images/icons/owl.jpg' />" alt="" class="smallicon"/><a href="#infoflowtabs1-5">知识</a></li>									
													<li><img src="<c:url value='/images/icons/onebit_10.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs1-6">评论</a></li>									
												</ul>
												
												<!-- First tab -->
												<div id="infoflowtabs1-1">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="放大" class="tooltip">
																	<span>放大</span>
																</a>
															</li>
															<li>
																<a href="#" title="缩小" class="tooltip">
																	<span>缩小</span>
																</a>
															</li>
															<li>
																<a href="#" title="旋转" class="tooltip">
																	<span>旋转</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/small.jpg' />" alt=""/>
														</div>
													</form>
													<!-- End of Form -->	
												</div>
												<!-- End of First tab -->
												
												<!-- Second tab -->
												<div id="infoflowtabs1-2">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="弹出播放" class="tooltip">
																	<span>弹出播放</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/vedio.jpg' />" alt=""/>
														</div>
			
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Second tab -->
				
												<!-- Third tab -->
												<div id="infoflowtabs1-3">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="弹出播放" class="tooltip">
																	<span>弹出播放</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/music.jpg' />" alt=""/>
														</div>
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Third tab -->
				
												<!-- Fourth tab -->
												<div id="infoflowtabs1-4">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="刷新地图" class="tooltip">
																	<span>刷新地图</span>
																</a>
															</li>
															<li>
																<a href="#" title="复原" class="tooltip">
																	<span>复原</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/gpsmap.jpg' />" alt=""/>
														</div>
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Fourth tab -->
			
												<!-- Fifth tab -->
												<div id="infoflowtabs1-5">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="刷新" class="tooltip">
																	<span>刷新</span>
																</a>
															</li>
															<li>
																<a href="#" title="复原" class="tooltip">
																	<span>复原</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/socialmap.jpg' />" alt=""/>
														</div>
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Fifth tab -->
			
												<!-- Sixth tab -->
												<div id="infoflowtabs1-6">
													<!-- Form -->
													<form method="post" action="#">
														<p>
			 												<input class="hf" name="lf" type="text" value="输入您的评论" /> 
			 												<input class="button" type="submit" value="提交" />
															同时转发？<input type="checkbox" />
														</p>
													
														<hr/>
														<p>
															<img src="<c:url value='/images/test/0.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
														<p>
															<img src="<c:url value='/images/test/1.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Sixth tab -->
											</div>
											<!-- End of Tabs -->
							
										
										</fieldset>
										<!-- end of infoflow -->
										
										<hr/>	
										
										<!-- infoflow -->
										<fieldset class="infoflow">
											<legend>
												<img src="<c:url value='/images/icons/Mail Open 1.png'/>" alt="" class="smalliconupupup"/>
												<img src="<c:url value='/images/test/qqweibo.jpg' />" alt="" class="smalliconupupup"/>
												
											</legend>
											<p>
												<img src="<c:url value='/images/test/0.jpg' />" alt="" class="floatleft"/>
													苍井空：我喜欢不能喝酒的人。因为照顾喝醉的我。哈哈没有黄色的意思啊！//@格斗禅师:那老师，您能不能告诉我，您尊敬什么酒都不喝的人吗？！
													 //@苍井空: 白酒是很强！害怕怕怕可怕。我尊敬会喝白酒的人！//@MandyChauM:那老师，你喜欢喝中国的白酒吗？								
											</p>
											<ul class="smalldashright">
												<li>
													<span>操作：</span>
												</li>										
												<li>
													<a href="#" title="收藏" class="tooltip">
														<span>收藏</span>
													</a>
												</li>
												<li>
													<a href="#" title="转发" class="tooltip">
														<span>转发</span>
													</a>
												</li>
												<li>
													<a href="#" title="备份" class="tooltip">
														<span>备份</span>
													</a>
												</li>
											</ul>
											<hr/>
			
																			
											<!-- Tabs -->
											<div id="infoflowtabs2">
												<ul class="whitetabsnav">
													<li><img src="<c:url value='/images/icons/Movies.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs2-1">视频信息卡</a></li>
													<li><img src="<c:url value='/images/icons/onebit_10.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs2-2">评论信息卡</a></li>									
												</ul>
												
												<!-- First tab -->
												<div id="infoflowtabs2-1">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="弹出播放" class="tooltip">
																	<span>弹出播放</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/vedio.jpg' />" alt=""/>
														</div>
													</form>
													<!-- End of Form -->	
												</div>
												<!-- End of First tab -->
												
												<!-- Second tab -->
												<div id="infoflowtabs2-2">
													<!-- Form -->
													<form method="post" action="#">
														<p>
			 												<input class="hf" name="lf" type="text" value="输入您的评论" /> 
			 												<input class="button" type="submit" value="提交" />
															同时转发？<input type="checkbox" />
														</p>
													
														<hr/>
														<p>
															<img src="<c:url value='/images/test/0.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
														<p>
															<img src=images/test/1.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
			
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Second tab -->
				
				
											</div>
											<!-- End of Tabs -->
								
										
										</fieldset>
										<!-- end of infoflow -->
												
										<hr/>					
										
										<!-- infoflow -->
										<fieldset class="infoflow">
											<legend>
												<img src="<c:url value='/images/icons/mail1.png'/>" alt="" class="smalliconupupup"/>
												<img src="<c:url value='/images/test/sinaweibo.jpg' />" alt="" class="smalliconupupup"/>
												
											</legend>
											<p>
												<img src="<c:url value='/images/test/1.jpg' />" alt="" class="floatleft"/>
												SinaAppEngine：
												【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
			
											</p>
											<ul class="smalldashright">
												<li>
													<span>操作：</span>
												</li>										
												<li>
													<a href="#" title="收藏" class="tooltip">
														<span>收藏</span>
													</a>
												</li>
												<li>
													<a href="#" title="转发" class="tooltip">
														<span>转发</span>
													</a>
												</li>
												<li>
													<a href="#" title="备份" class="tooltip">
														<span>备份</span>
													</a>
												</li>
											</ul>
											<hr/>
			
																			
											<!-- Tabs -->
											<div id="infoflowtabs3">
												<ul class="whitetabsnav">
													<li><img src="<c:url value='/images/icons/Pictures.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs3-1">图片信息卡</a></li>
													<li><img src="<c:url value='/images/icons/Movies.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs3-2">视频信息卡</a></li>
													<li><img src="<c:url value='/images/icons/onebit_10.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs3-3">评论信息卡</a></li>									
												</ul>
												
												<!-- First tab -->
												<div id="infoflowtabs3-1">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="放大" class="tooltip">
																	<span>放大</span>
																</a>
															</li>
															<li>
																<a href="#" title="缩小" class="tooltip">
																	<span>缩小</span>
																</a>
															</li>
															<li>
																<a href="#" title="旋转" class="tooltip">
																	<span>旋转</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/small.jpg' />" alt=""/>
														</div>
													</form>
													<!-- End of Form -->	
												</div>
												<!-- End of First tab -->
												
												<!-- Second tab -->
												<div id="infoflowtabs3-2">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="弹出播放" class="tooltip">
																	<span>弹出播放</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/vedio.jpg' />" alt=""/>
														</div>
			
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Second tab -->
				
												<!-- Third tab -->
												<div id="infoflowtabs3-3">
													<!-- Form -->
													<form method="post" action="#">
														<p>
			 												<input class="hf" name="lf" type="text" value="输入您的评论" /> 
			 												<input class="button" type="submit" value="提交" />
															同时转发？<input type="checkbox" />
														</p>
													
														<hr/>
														<p>
															<img src="<c:url value='/images/test/0.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
														<p>
															<img src="<c:url value='/images/test/1.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Third tab -->
				
											</div>
											<!-- End of Tabs -->
								
										
										</fieldset>
										<!-- end of infoflow -->
										
										</div>
										<!-- end of portlet-content -->
									</div>
								</div>
							</fieldset>
							<!-- end of Fieldset -->	
							<hr/>
							
							<!-- Fieldset -->
							<fieldset class="infoflow">
								<legend>
									<img src="<c:url value='/images/icons/mail1.png'/>" alt="" class="smalliconupupup"/>
									<img src="<c:url value='/images/test/logorobot.jpg' />" alt="" class="smalliconupupup"/>
									<美女图片机器人> - 2013年5月26日执行报告
								</legend>
								<div class="message information">
									<p>
										报告机器人：<美女图片机器人>&nbsp;&nbsp;&nbsp;&nbsp;
										所有人：timearrow&nbsp;&nbsp;&nbsp;&nbsp;
										<br/>
										功能：定期获取美女图片&nbsp;&nbsp;&nbsp;&nbsp;
										触发规则：定期时钟&nbsp;&nbsp;&nbsp;&nbsp;
										执行周期：每天&nbsp;&nbsp;&nbsp;&nbsp;
										<br/>
										执行时间：21时15分&nbsp;&nbsp;&nbsp;&nbsp;
										获取信息数：25条&nbsp;&nbsp;&nbsp;&nbsp;
										输出信息数：3条&nbsp;&nbsp;&nbsp;&nbsp;
										新信息数：1条&nbsp;&nbsp;&nbsp;&nbsp;
									</p>
								</div>
								<hr/>

								<div class="sort">
									<div class="box ui-widget ui-widget-content ui-corner-all portlet">
			
										<div class="portlet-header">输出信息列表</div>
										<!-- portlet-content -->
										<div class="portlet-content">
										
										<!-- infoflow -->
										<fieldset class="infoflow">
											<legend>
												<img src="<c:url value='/images/icons/mail1.png'/>" alt="" class="smalliconupupup"/>
												<img src="<c:url value='/images/test/sinaweibo.jpg' />" alt="" class="smalliconupupup"/>
												
											</legend>
											<p>
												<img src="<c:url value='/images/test/1.jpg' />" alt="" class="floatleft"/>
												SinaAppEngine：
												【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
											</p>
											<ul class="smalldashright">
												<li>
													<span>操作：</span>
												</li>										
												<li>
													<a href="#" title="收藏" class="tooltip">
														<span>收藏</span>
													</a>
												</li>
												<li>
													<a href="#" title="转发" class="tooltip">
														<span>转发</span>
													</a>
												</li>
												<li>
													<a href="#" title="备份" class="tooltip">
														<span>备份</span>
													</a>
												</li>
											</ul>
											<hr/>
																			
											<!-- Tabs -->
											<div id="infoflowtabs4">
												<ul class="whitetabsnav">
													<li><img src="<c:url value='/images/icons/Pictures.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs4-1">图片</a></li>
													<li><img src="<c:url value='/images/icons/Movies.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs4-2">视频</a></li>
													<li><img src="<c:url value='/images/icons/Music Blue.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs4-3">音乐</a></li>
													<li><img src="<c:url value='/images/icons/onebit_19.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs4-4">地图</a></li>
													<li><img src="<c:url value='/images/icons/owl.jpg' />" alt="" class="smallicon"/><a href="#infoflowtabs4-5">知识</a></li>									
													<li><img src="<c:url value='/images/icons/onebit_10.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs4-6">评论</a></li>									
												</ul>
												
												<!-- First tab -->
												<div id="infoflowtabs4-1">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="放大" class="tooltip">
																	<span>放大</span>
																</a>
															</li>
															<li>
																<a href="#" title="缩小" class="tooltip">
																	<span>缩小</span>
																</a>
															</li>
															<li>
																<a href="#" title="旋转" class="tooltip">
																	<span>旋转</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/small.jpg' />" alt=""/>
														</div>
													</form>
													<!-- End of Form -->	
												</div>
												<!-- End of First tab -->
												
												<!-- Second tab -->
												<div id="infoflowtabs4-2">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="弹出播放" class="tooltip">
																	<span>弹出播放</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/vedio.jpg' />" alt=""/>
														</div>
			
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Second tab -->
				
												<!-- Third tab -->
												<div id="infoflowtabs4-3">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="弹出播放" class="tooltip">
																	<span>弹出播放</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/music.jpg' />" alt=""/>
														</div>
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Third tab -->
				
												<!-- Fourth tab -->
												<div id="infoflowtabs4-4">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="刷新地图" class="tooltip">
																	<span>刷新地图</span>
																</a>
															</li>
															<li>
																<a href="#" title="复原" class="tooltip">
																	<span>复原</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/gpsmap.jpg' />" alt=""/>
														</div>
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Fourth tab -->
			
												<!-- Fifth tab -->
												<div id="infoflowtabs4-5">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="刷新" class="tooltip">
																	<span>刷新</span>
																</a>
															</li>
															<li>
																<a href="#" title="复原" class="tooltip">
																	<span>复原</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/socialmap.jpg' />" alt=""/>
														</div>
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Fifth tab -->
			
												<!-- Sixth tab -->
												<div id="infoflowtabs4-6">
													<!-- Form -->
													<form method="post" action="#">
														<p>
			 												<input class="hf" name="lf" type="text" value="输入您的评论" /> 
			 												<input class="button" type="submit" value="提交" />
															同时转发？<input type="checkbox" />
														</p>
													
														<hr/>
														<p>
															<img src="<c:url value='/images/test/0.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
														<p>
															<img src="<c:url value='/images/test/1.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Sixth tab -->
											</div>
											<!-- End of Tabs -->
							
										
										</fieldset>
										<!-- end of infoflow -->
										
										<hr/>	
										
										<!-- infoflow -->
										<fieldset class="infoflow">
											<legend>
												<img src="<c:url value='/images/icons/Mail Open 1.png'/>" alt="" class="smalliconupupup"/>
												<img src="<c:url value='/images/test/qqweibo.jpg' />" alt="" class="smalliconupupup"/>
												
											</legend>
											<p>
												<img src="<c:url value='/images/test/0.jpg' />" alt="" class="floatleft"/>
													苍井空：我喜欢不能喝酒的人。因为照顾喝醉的我。哈哈没有黄色的意思啊！//@格斗禅师:那老师，您能不能告诉我，您尊敬什么酒都不喝的人吗？！
													 //@苍井空: 白酒是很强！害怕怕怕可怕。我尊敬会喝白酒的人！//@MandyChauM:那老师，你喜欢喝中国的白酒吗？								
											</p>
											<ul class="smalldashright">
												<li>
													<span>操作：</span>
												</li>										
												<li>
													<a href="#" title="收藏" class="tooltip">
														<span>收藏</span>
													</a>
												</li>
												<li>
													<a href="#" title="转发" class="tooltip">
														<span>转发</span>
													</a>
												</li>
												<li>
													<a href="#" title="备份" class="tooltip">
														<span>备份</span>
													</a>
												</li>
											</ul>
											<hr/>
			
																			
											<!-- Tabs -->
											<div id="infoflowtabs5">
												<ul class="whitetabsnav">
													<li><img src="<c:url value='/images/icons/Movies.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs5-1">视频信息卡</a></li>
													<li><img src="<c:url value='/images/icons/onebit_10.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs5-2">评论信息卡</a></li>									
												</ul>
												
												<!-- First tab -->
												<div id="infoflowtabs5-1">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="弹出播放" class="tooltip">
																	<span>弹出播放</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/vedio.jpg' />" alt=""/>
														</div>
													</form>
													<!-- End of Form -->	
												</div>
												<!-- End of First tab -->
												
												<!-- Second tab -->
												<div id="infoflowtabs5-2">
													<!-- Form -->
													<form method="post" action="#">
														<p>
			 												<input class="hf" name="lf" type="text" value="输入您的评论" /> 
			 												<input class="button" type="submit" value="提交" />
															同时转发？<input type="checkbox" />
														</p>
													
														<hr/>
														<p>
															<img src="<c:url value='/images/test/0.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
														<p>
															<img src=images/test/1.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
			
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Second tab -->
				
				
											</div>
											<!-- End of Tabs -->
								
										
										</fieldset>
										<!-- end of infoflow -->
												
										<hr/>					
										
										<!-- infoflow -->
										<fieldset class="infoflow">
											<legend>
												<img src="<c:url value='/images/icons/mail1.png'/>" alt="" class="smalliconupupup"/>
												<img src="<c:url value='/images/test/sinaweibo.jpg' />" alt="" class="smalliconupupup"/>
												
											</legend>
											<p>
												<img src="<c:url value='/images/test/1.jpg' />" alt="" class="floatleft"/>
												SinaAppEngine：
												【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
			
											</p>
											<ul class="smalldashright">
												<li>
													<span>操作：</span>
												</li>										
												<li>
													<a href="#" title="收藏" class="tooltip">
														<span>收藏</span>
													</a>
												</li>
												<li>
													<a href="#" title="转发" class="tooltip">
														<span>转发</span>
													</a>
												</li>
												<li>
													<a href="#" title="备份" class="tooltip">
														<span>备份</span>
													</a>
												</li>
											</ul>
											<hr/>
			
																			
											<!-- Tabs -->
											<div id="infoflowtabs6">
												<ul class="whitetabsnav">
													<li><img src="<c:url value='/images/icons/Pictures.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs6-1">图片信息卡</a></li>
													<li><img src="<c:url value='/images/icons/Movies.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs6-2">视频信息卡</a></li>
													<li><img src="<c:url value='/images/icons/onebit_10.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs6-3">评论信息卡</a></li>									
												</ul>
												
												<!-- First tab -->
												<div id="infoflowtabs6-1">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="放大" class="tooltip">
																	<span>放大</span>
																</a>
															</li>
															<li>
																<a href="#" title="缩小" class="tooltip">
																	<span>缩小</span>
																</a>
															</li>
															<li>
																<a href="#" title="旋转" class="tooltip">
																	<span>旋转</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/small.jpg' />" alt=""/>
														</div>
													</form>
													<!-- End of Form -->	
												</div>
												<!-- End of First tab -->
												
												<!-- Second tab -->
												<div id="infoflowtabs6-2">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="弹出播放" class="tooltip">
																	<span>弹出播放</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/vedio.jpg' />" alt=""/>
														</div>
			
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Second tab -->
				
												<!-- Third tab -->
												<div id="infoflowtabs6-3">
													<!-- Form -->
													<form method="post" action="#">
														<p>
			 												<input class="hf" name="lf" type="text" value="输入您的评论" /> 
			 												<input class="button" type="submit" value="提交" />
															同时转发？<input type="checkbox" />
														</p>
													
														<hr/>
														<p>
															<img src="<c:url value='/images/test/0.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
														<p>
															<img src="<c:url value='/images/test/1.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Third tab -->
				
											</div>
											<!-- End of Tabs -->
								
										
										</fieldset>
										<!-- end of infoflow -->
										
										</div>
										<!-- end of portlet-content -->
									</div>
								</div>
							</fieldset>
							<!-- end of Fieldset -->	
							<hr/>
							
							<!-- Fieldset -->
							<fieldset class="infoflow">
								<legend>
									<img src="<c:url value='/images/icons/mail1.png'/>" alt="" class="smalliconupupup"/>
									<img src="<c:url value='/images/test/logorobot.jpg' />" alt="" class="smalliconupupup"/>
									<好友关注机器人> - 2013年5月26日执行报告
								</legend>
								<div class="message information">
									<p>
										报告机器人：<好友关注机器人>&nbsp;&nbsp;&nbsp;&nbsp;
										所有人：timearrow&nbsp;&nbsp;&nbsp;&nbsp;
										<br/>
										功能：定期获取关注好友的社交网络动态信息&nbsp;&nbsp;&nbsp;&nbsp;
										触发规则：定期时钟&nbsp;&nbsp;&nbsp;&nbsp;
										执行周期：每天&nbsp;&nbsp;&nbsp;&nbsp;
										<br/>
										执行时间：23时35分&nbsp;&nbsp;&nbsp;&nbsp;
										获取信息数：35条&nbsp;&nbsp;&nbsp;&nbsp;
										输出信息数：24条&nbsp;&nbsp;&nbsp;&nbsp;
										新信息数：15条&nbsp;&nbsp;&nbsp;&nbsp;
									</p>
								</div>
								<hr/>

								<div class="sort">
									<div class="box ui-widget ui-widget-content ui-corner-all portlet">
			
										<div class="portlet-header">输出信息列表</div>
										<!-- portlet-content -->
										<div class="portlet-content">
										
										<!-- infoflow -->
										<fieldset class="infoflow">
											<legend>
												<img src="<c:url value='/images/icons/Mail Open 1.png'/>" alt="" class="smalliconupupup"/>
												<img src="<c:url value='/images/test/qqweibo.jpg' />" alt="" class="smalliconupupup"/>
												
											</legend>
											<p>
												<img src="<c:url value='/images/test/0.jpg' />" alt="" class="floatleft"/>
													苍井空：我喜欢不能喝酒的人。因为照顾喝醉的我。哈哈没有黄色的意思啊！//@格斗禅师:那老师，您能不能告诉我，您尊敬什么酒都不喝的人吗？！
													 //@苍井空: 白酒是很强！害怕怕怕可怕。我尊敬会喝白酒的人！//@MandyChauM:那老师，你喜欢喝中国的白酒吗？								
											</p>
											<ul class="smalldashright">
												<li>
													<span>操作：</span>
												</li>										
												<li>
													<a href="#" title="收藏" class="tooltip">
														<span>收藏</span>
													</a>
												</li>
												<li>
													<a href="#" title="转发" class="tooltip">
														<span>转发</span>
													</a>
												</li>
												<li>
													<a href="#" title="备份" class="tooltip">
														<span>备份</span>
													</a>
												</li>
											</ul>
											<hr/>
			
																			
											<!-- Tabs -->
											<div id="infoflowtabs7">
												<ul class="whitetabsnav">
													<li><img src="<c:url value='/images/icons/Movies.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs7-1">视频信息卡</a></li>
													<li><img src="<c:url value='/images/icons/onebit_10.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs7-2">评论信息卡</a></li>									
												</ul>
												
												<!-- First tab -->
												<div id="infoflowtabs7-1">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="弹出播放" class="tooltip">
																	<span>弹出播放</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/vedio.jpg' />" alt=""/>
														</div>
													</form>
													<!-- End of Form -->	
												</div>
												<!-- End of First tab -->
												
												<!-- Second tab -->
												<div id="infoflowtabs7-2">
													<!-- Form -->
													<form method="post" action="#">
														<p>
			 												<input class="hf" name="lf" type="text" value="输入您的评论" /> 
			 												<input class="button" type="submit" value="提交" />
															同时转发？<input type="checkbox" />
														</p>
													
														<hr/>
														<p>
															<img src="<c:url value='/images/test/0.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
														<p>
															<img src=images/test/1.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
			
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Second tab -->
				
				
											</div>
											<!-- End of Tabs -->
								
										
										</fieldset>
										<!-- end of infoflow -->
												
										<hr/>					
										
										<!-- infoflow -->
										<fieldset class="infoflow">
											<legend>
												<img src="<c:url value='/images/icons/mail1.png'/>" alt="" class="smalliconupupup"/>
												<img src="<c:url value='/images/test/sinaweibo.jpg' />" alt="" class="smalliconupupup"/>
												
											</legend>
											<p>
												<img src="<c:url value='/images/test/1.jpg' />" alt="" class="floatleft"/>
												SinaAppEngine：
												【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
			
											</p>
											<ul class="smalldashright">
												<li>
													<span>操作：</span>
												</li>										
												<li>
													<a href="#" title="收藏" class="tooltip">
														<span>收藏</span>
													</a>
												</li>
												<li>
													<a href="#" title="转发" class="tooltip">
														<span>转发</span>
													</a>
												</li>
												<li>
													<a href="#" title="备份" class="tooltip">
														<span>备份</span>
													</a>
												</li>
											</ul>
											<hr/>
			
																			
											<!-- Tabs -->
											<div id="infoflowtabs8">
												<ul class="whitetabsnav">
													<li><img src="<c:url value='/images/icons/Pictures.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs8-1">图片信息卡</a></li>
													<li><img src="<c:url value='/images/icons/Movies.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs8-2">视频信息卡</a></li>
													<li><img src="<c:url value='/images/icons/onebit_10.png'/>" alt="" class="smallicon"/><a href="#infoflowtabs8-3">评论信息卡</a></li>									
												</ul>
												
												<!-- First tab -->
												<div id="infoflowtabs8-1">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="放大" class="tooltip">
																	<span>放大</span>
																</a>
															</li>
															<li>
																<a href="#" title="缩小" class="tooltip">
																	<span>缩小</span>
																</a>
															</li>
															<li>
																<a href="#" title="旋转" class="tooltip">
																	<span>旋转</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/small.jpg' />" alt=""/>
														</div>
													</form>
													<!-- End of Form -->	
												</div>
												<!-- End of First tab -->
												
												<!-- Second tab -->
												<div id="infoflowtabs8-2">
													<!-- Form -->
													<form method="post" action="#">
														<ul class="smalldash">
															<li>
																<span>操作：</span>
															</li>										
															<li>
																<a href="#" title="弹出播放" class="tooltip">
																	<span>弹出播放</span>
																</a>
															</li>
														</ul>
														<hr/>
														<div class="aligncenter">
															<img src="<c:url value='/images/test/vedio.jpg' />" alt=""/>
														</div>
			
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Second tab -->
				
												<!-- Third tab -->
												<div id="infoflowtabs8-3">
													<!-- Form -->
													<form method="post" action="#">
														<p>
			 												<input class="hf" name="lf" type="text" value="输入您的评论" /> 
			 												<input class="button" type="submit" value="提交" />
															同时转发？<input type="checkbox" />
														</p>
													
														<hr/>
														<p>
															<img src="<c:url value='/images/test/0.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
														<p>
															<img src="<c:url value='/images/test/1.jpg' />" alt="" class="floatleft"/>
															SinaAppEngine：
															【#SAE技术分享#】《迁移 WordPress 到 SAE 完全操作攻略》http://t.cn/zlEgvm6 via@WordPressJAM
						
															
														</p>
													</form>
													<!-- End of Form -->	
						 						</div>
												<!-- End of Third tab -->
				
											</div>
											<!-- End of Tabs -->
								
										
										</fieldset>
										<!-- end of infoflow -->
										
										</div>
										<!-- end of portlet-content -->
									</div>
								</div>
							</fieldset>
							<!-- end of Fieldset -->	
							<hr/>

							
							<p class="aligncenter">
								正在加载信息，请稍候...
							</p>
							
 						</div>
					</div>					
				</div>
				<!-- End of Main Content -->
				
				<!-- Sidebar -->
				<div id="sidebar">		
						
					<!-- Tabs -->
					<div id="sidebartabs">
						<ul class="whitetabsnav">
							<li>
								<img src="<c:url value='/images/icons/3_48x48.png'/>" alt="" class="smallicon"/><a href="#sidebartabs-1">获取信息</a>
							</li>
							<li><img src="<c:url value='/images/icons/20_48x48.png'/>" alt="" class="smallicon"/><a href="#sidebartabs-2">管理信息</a></li>
						</ul>
						
						<!-- First tab -->
						<div id="sidebartabs-1">
<%-- 							<h2 class="notop">
								<img src="<c:url value='/images/icons/4_48x48.png'/>" alt="" class="smallicondown"/>
								信息汇总
								<a href="#" title="有新的信息动态" class="tooltip">
									<img src="<c:url value='/images/icons/26_48x48.png'/>" alt="" class="smalliconright"/>
								</a>					
							</h2>
 --%>					
 									
 							<p>	<b>报告:</b> 
								<a href="#" title="新执行报告数" class="tooltip">22</a>更新/
								<a href="#" title="已执行报告数" class="tooltip">2331</a>汇总
								<a href="#" title="有新的执行报告动态" class="tooltip">
									<img src="<c:url value='/images/icons/26_48x48.png'/>" alt="" class="smalliconright"/>
								</a>
							</p>
 							<p>	<b>信息:</b> 
								<a href="#" title="新获取信息数" class="tooltip">21</a>更新/
								<a href="#" title="已获取信息数" class="tooltip">4561</a>汇总
								<a href="#" title="有新的信息动态" class="tooltip">
									<img src="<c:url value='/images/icons/26_48x48.png'/>" alt="" class="smalliconright"/>
								</a>
							</p>
												
<%-- 							<h2>
								<img src="<c:url value='/images/icons/onebit_24.png'/>" alt="" class="smallicondown"/>
								信息获取机器人
								<a href="#" title="获取最新信息" class="tooltip">
									<img src="<c:url value='/images/icons/update.png'/>" alt="" class="smalliconright"/>
								</a>					
							</h2>
 --%>							
 							<h2></h2>
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
												<h2 class="normalh2 " >
													<a href="#" class="tooltip" title="好友动态关注机器人,及时获取好友动态">
														<img src="<c:url value='/images/test/robot.jpg' />" alt="好友动态关注机器人,及时获取好友动态" class="smalliconupup"/>
														&lt;好友关注机器人&gt;
													</a>
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
												<h2 class="normalh2 " >
													<a href="#" class="tooltip" title="社会热点动态关注机器人,及时获取各大社交网络社会热点">
														<img src="<c:url value='/images/test/robot-update.jpg' />" alt="社会热点动态关注机器人,及时获取各大社交网络社会热点" class="smalliconupup"/>
														&lt;社会热点机器人&gt;
													</a>
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
												<h2 class="normalh2 " >
													<a href="#" class="tooltip" title="关键词信息关注机器人,利用关键词过滤获取各大社交网络信息">
														<img src="<c:url value='/images/test/robot-update.jpg' />" alt="关键词信息关注机器人,利用关键词过滤获取各大社交网络信息" class="smalliconupup"/>
														&lt;关键词机器人&gt;
													</a>
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
												<h2 class="normalh2 " >
													<a href="#" class="tooltip" title="追踪剧集机器人,及时获取剧集更新信息">
														<img src="<c:url value='/images/test/robot.jpg' />" alt="追踪剧集机器人,及时获取剧集更新信息" class="smalliconupup"/>
														&lt;剧集追新机器人&gt;
													</a>
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
												<h2 class="normalh2 " >
													<a href="#" class="tooltip" title="美女图片机器人,定期获取美女图片发布源更新">
														<img src="<c:url value='/images/test/robot-update.jpg' />" alt="美女图片机器人,定期获取美女图片发布源更新" class="smalliconupup"/>
														&lt;美女图片机器人&gt;
													</a>
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
												<h2 class="normalh2 " >
													<a href="#" class="tooltip" title="追踪网络小说机器人,及时获取网络小说更新信息">
														<img src="<c:url value='/images/test/robot.jpg' />" alt="追踪网络小说机器人,及时获取网络小说更新信息" class="smalliconupup"/>
														&lt;小说追新机器人&gt;
													</a>
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
												<h2 class="normalh2 " >
													<a href="#" class="tooltip" title="追踪影讯机器人,及时获取院线影讯更新信息">
														<img src="<c:url value='/images/test/robot.jpg' />" alt="追踪影讯机器人,及时获取院线影讯更新信息" class="smalliconupup"/>
														&lt;影讯机器人&gt;
													</a>
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
												<h2 class="normalh2 " >
													<a href="#" class="tooltip" title="商品动态关注机器人,及时获取商品更新信息">
														<img src="<c:url value='/images/test/robot.jpg' />" alt="商品动态关注机器人,及时获取商品更新信息" class="smalliconupup"/>
														&lt;商品关注机器人&gt;
													</a>
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
												<h2 class="normalh2 " >
													<a href="#" class="tooltip" title="社会热点动态关注机器人,及时获取各大社交网络社会热点">
														<img src="<c:url value='/images/test/robot-update.jpg' />" alt="店铺动态关注机器人,及时获取店铺更新信息" class="smalliconupup"/>
														&lt;店铺关注机器人&gt;
													</a>
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
						
						<!-- Second tab -->
						<div id="sidebartabs-2">
<!-- 						<h2 class="notop">
								<img src="<c:url value='/images/icons/20_48x48.png'/>" alt="" class="smallicondown"/>
								管理社会信息
							</h2>
 -->						
 
 							<h2 class="notop">
								<img src="<c:url value='/images/icons/onebit_15.png'/>" alt="" class="smallicondown"/>
								按时间范围过滤
							</h2>
							
							<div id="datepicker"></div>
						
												
												
							<h2>
								<img src="<c:url value='/images/icons/onebit_13.png'/>" alt="" class="smallicondown"/>
								按信息属性分类
							</h2>
							<div class="sort">
								<div class="box ui-widget ui-widget-content ui-corner-all portlet">
		
									<div class="portlet-header">信息类型</div>
									<div class="portlet-content">
										<div class="sidebardiv">
											<!-- Form -->
											<form method="post" action="#">
												<h2 class="normalh2">所有信息类型<input type="checkbox"  class="checkall" /></h2>
											
												<ul>
													<li><a href="#">创新成果</a><input type="checkbox" /></li>
													<li><a href="#">内容信息</a><input type="checkbox" />
														<ul>
															<li><a href="#">书籍</a><input type="checkbox" /></li>
															<li><a href="#">图片</a><input type="checkbox" /></li>
															<li><a href="#">音乐</a><input type="checkbox" /></li>
														</ul>
														
													</li>
													<li><a href="#">社会关系</a><input type="checkbox" /></li>
													<li><a href="#">任务、约会</a><input type="checkbox" /></li>
													<li><a href="#">沟通记录</a><input type="checkbox" /></li>
													
												</ul>
											</form>
											<!-- End of Form -->	
		
										</div>
									</div>
																																				
								</div>
								
								<div class="box ui-widget ui-widget-content ui-corner-all portlet">
									<div class="portlet-header">信息用途</div>
									<div class="portlet-content">
										<div class="sidebardiv">
											<!-- Form -->
											<form method="post" action="#">
												<h2 class="normalh2">所有信息用途<input type="checkbox"  class="checkall" /></h2>
											
												<ul>
													<li><a href="#">金融、理财</a><input type="checkbox" /></li>
													<li><a href="#">工作、事业</a><input type="checkbox" /></li>
													<li><a href="#">生活休闲</a><input type="checkbox" />
														<ul>
															<li><a href="#">运动</a><input type="checkbox" /></li>
															<li><a href="#">兴趣爱好</a><input type="checkbox" />
																<ul>
																	<li><a href="#">摄影</a><input type="checkbox" /></li>
																	<li><a href="#">自行车</a><input type="checkbox" /></li>
																	<li><a href="#">旅游</a><input type="checkbox" /></li>
																	<li><a href="#">咖啡</a><input type="checkbox" /></li>
																</ul>
																
															</li>
															<li><a href="#">娱乐</a><input type="checkbox" /></li>
														</ul>
														
													</li>
													<li><a href="#">家庭、朋友</a><input type="checkbox" /></li>
												</ul>
											</form>
											<!-- End of Form -->	
		
										</div>
									</div>
								</div>
								
							</div>
 
 						</div>
						<!-- End of Second tab -->
					</div>
					<!-- End of Tabs -->		
							
				</div>
				<!-- End of Sidebar -->
				
				
				<!-- RightSidebar -->
				<div id="rightsidebar">
					
					<h2><img src="<c:url value='/images/icons/onebit_26.png'/>" alt=""  class="smalliconup"/>分享范围&gt;&gt;</h2>
					<div id="accordion_right">
					
						<p>	<b>传播:</b>
							<a href="#" title="已备份信息数" class="tooltip">233</a>备份/
							<a href="#" title="已分享信息数" class="tooltip">456</a>分享
							<a href="#" title="有新的传播动态" class="tooltip">
								<img src="<c:url value='/images/icons/26_48x48.png'/>" alt="" class="smalliconright"/>
							</a>
						</p>
						<h2></h2>
						<div>
							<!-- Form -->
							<form method="post" action="#">
						
							<h3><a href="#" title="社交网络" class="tooltip">社交网络</a></h3>							
							<div class="rightsidebardiv">
								<h2 class="normalh2">所有社交网络<input type="checkbox"  class="checkall" /></h2>
								<ul>
									<li><a href="#"><img src="<c:url value='/images/test/sinaweibo.jpg' />" alt="" class="smalliconup"/>  新浪微博</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/test/qqweibo.jpg' />" alt="" class="smalliconup"/>  腾讯微博</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/test/twitter.jpg' />" alt="" class="smalliconup"/>  Twitter</a><input type="checkbox" /></li>
								</ul>
							</div>

							</form>
							<!-- End of Form -->	

						</div>
						<div>
							<!-- Form -->
							<form method="post" action="#">
						
							<h3><a href="#" title="联系人" class="tooltip">联系人</a></h3>					
							<div class="rightsidebardiv">
								<h2 class="normalh2">所有联系人<input type="checkbox"  class="checkall" /></h2>
								<ul>
									<li><a href="#"><img src="<c:url value='/images/icons/Contact.png'/>" alt="" class="smalliconup"/>  diesang</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/icons/Contact.png'/>" alt="" class="smalliconup"/>  曹二曹二</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/icons/Contact.png'/>" alt="" class="smalliconup"/>  黄大力</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/icons/Contact.png'/>" alt="" class="smalliconup"/>  minakokaka</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/icons/Contact.png'/>" alt="" class="smalliconup"/>  copylight</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/icons/Contact.png'/>" alt="" class="smalliconup"/>  ye-huang</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/icons/Contact.png'/>" alt="" class="smalliconup"/>  岁念猫哥</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/icons/Contact.png'/>" alt="" class="smalliconup"/>  PRC_laiyan...</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/icons/Contact.png'/>" alt="" class="smalliconup"/>  janey_h</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/icons/Contact.png'/>" alt="" class="smalliconup"/>  溦转</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/icons/Contact.png'/>" alt="" class="smalliconup"/>  黄四三二一</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/icons/Contact.png'/>" alt="" class="smalliconup"/>  曹二曹二</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/icons/Contact.png'/>" alt="" class="smalliconup"/>  黄大力</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/icons/Contact.png'/>" alt="" class="smalliconup"/>  minakokaka</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/icons/Contact.png'/>" alt="" class="smalliconup"/>  copylight</a><input type="checkbox" /></li>
								</ul>
							</div>
							
							</form>
							<!-- End of Form -->	
							
						</div>
						<div>
							<!-- Form -->
							<form method="post" action="#">
						
							<h3><a href="#" title="备份网盘" class="tooltip">备份网盘</a></h3>
							<div class="rightsidebardiv">
								<h2 class="normalh2">所有备份网盘<input type="checkbox"  class="checkall" /></h2>
								<ul>
									<li><a href="#"><img src="<c:url value='/images/test/huaweidisk.jpg' />" alt="" class="smalliconup"/>  华为网盘</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/test/sinadisk.png' />" alt="" class="smalliconup"/>  新浪微盘</a><input type="checkbox" /></li>
									<li><a href="#"><img src="<c:url value='/images/test/baidudisk.jpg' />" alt="" class="smalliconup"/>  百度云盘</a><input type="checkbox" /></li>
								</ul>
							</div>
							</form>
							<!-- End of Form -->	
						</div>
					</div>
					
					
				</div>
				<!-- End of RightSidebar -->
					
				<!-- TopSidebar -->
				<div id="topsidebar">
				
					<ul>
						<li><a href="#" class="tooltip" title="获取信息"><img src="<c:url value='/images/icons/spectrum1.jpg' />" alt=""/></a></li>						
						<li><a href="#" class="tooltip" title="管理信息"><img src="<c:url value='/images/icons/spectrum2.jpg' />" alt=""/></a></li>						
						<li><a href="#" class="tooltip" title="使用信息"><img src="<c:url value='/images/icons/spectrum3.jpg' />" alt=""/></a></li>						
						<li><a href="#" class="tooltip" title="创造信息" id="dialog_link"><img src="<c:url value='/images/icons/spectrum4.jpg' />" alt=""/></a></li>					
						<li><a href="#" class="tooltip" title="分享信息"><img src="<c:url value='/images/icons/spectrum5.jpg' />" alt=""/></a></li>						
					</ul>
								
				</div>
				<!-- End of TopSidebar -->


 			
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


