<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

				<div id="top">
					<!-- Logo -->
					<div class="logo"> 
						<a href="#" title="WITS - 微智" class="tooltip"><img src="<c:url value='/images/wits-logo.png'/>" alt="WITS - 微智" /></a> 
					</div>
					<!-- End of Logo -->
					
					<!-- Meta information -->
					<div class="meta">
						<p><span id="hello"></span>，<%=((IndividualModel)session.getAttribute(Constants.INDIVIDUAL_ACTIVE)).getUserName()%>！</p>
						<ul>
							<li><a href="<c:url value='/individual/logout'/>" title="退出" class="tooltip"><span class="ui-icon ui-icon-power"></span>退出</a></li>
							<li><a href="#" title="设置" class="tooltip"><span class="ui-icon ui-icon-wrench"></span>设置</a></li>
							<li><a href="#" title="账号" class="tooltip"><span class="ui-icon ui-icon-person"></span>账号</a></li>
						</ul>	
					</div>
					<!-- End of Meta information -->
				</div>
