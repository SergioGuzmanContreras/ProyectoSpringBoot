package mx.com.ersoft.controller.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import mx.com.ersoft.entity.LogEntity;
import mx.com.ersoft.service.LogService;


@Component("requestTimeInterceptor")
public class RequestTimeInterceptor  extends HandlerInterceptorAdapter{

	@Autowired
	private LogService logger;
	
	private static final Logger log = LoggerFactory.getLogger(RequestTimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hadler) throws Exception{
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
		long startTime = (long) request.getAttribute("startTime");
		String url = request.getRequestURL().toString();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = "";
		if(auth != null && auth.isAuthenticated())
			userName = auth.getName();
		logger.saveLog(new LogEntity(new Date(), auth.getDetails().toString(), userName, url));
		log.info("<== ### Request url: " + url + " <-> TOTAL TIME: " + (System.currentTimeMillis() - startTime) + " msg");
	}

}
