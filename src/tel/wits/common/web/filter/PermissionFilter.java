package tel.wits.common.web.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tel.wits.common.Constants;

public class PermissionFilter implements Filter {
	private static HashMap<String, String> freeResource;

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rsp = (HttpServletResponse) response;
		String contextPath = req.getContextPath();
		String currentURI = req.getRequestURI();
		if (currentURI != null) {
			currentURI = currentURI.replaceFirst(contextPath, "");
		}
		if (currentURI.startsWith("/images/")) {
			currentURI = "/images/";
		} else if (currentURI.startsWith("/css/")) {
			currentURI = "/css/";
		} else if (currentURI.startsWith("/js/")) {
			currentURI = "/js/";
		}

		if (!freeResource.containsKey(currentURI)) {
			if ( req.getSession().getAttribute(Constants.INDIVIDUAL_ACTIVE) == null ) {
				PrintWriter out = rsp.getWriter();
				if (req.getHeader("x-requested-with") != null) {
					// ajax请求返回超时提示
					out.print("{\"retFlag\":0,\"msg\":\"系统超时请重新登录\"}");
					return;
				} else {
					rsp.sendRedirect(contextPath);
					return;
				}

			}
		}
		chain.doFilter(req, rsp);
	}

	public void init(FilterConfig config) throws ServletException {
		freeResource = new HashMap<String, String>();
		freeResource.put("", "");
		freeResource.put("/", "/");
		freeResource.put("/visit", "/visit");
		freeResource.put("/individual/login", "/individual/login");
		freeResource.put("/individual/register", "/individual/register");
		freeResource.put("/individual/logout", "/individual/logout");

		freeResource.put("/images/", "/images/");
		freeResource.put("/css/", "/css/");
		freeResource.put("/js/", "/js/");
	
	}

}