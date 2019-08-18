package com.hijklmn.springcloud.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

// @Component
public class AccessFilter extends ZuulFilter {
	
	private final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

	@Override
	public boolean shouldFilter() {
		
		logger.info("----------> zuul filter : shouldFilter");
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		RequestContext ctx = RequestContext.getCurrentContext();
		
		HttpServletRequest request = ctx.getRequest();
		
		logger.info("send {} request to {} ", request.getMethod(), request.getRequestURL().toString());
		
		Object accessToken = request.getParameter("accessToken");
		
		if (accessToken == null) {
			logger.warn("access token is empty !");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;
		}
		
		logger.info("access token ok !");
		
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
