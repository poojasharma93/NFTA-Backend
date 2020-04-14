package com.nfta.stopsTransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.nfta.stopsTransaction.service.RouteService;
import com.nfta.stopsTransaction.service.ServiceRequestService;
import com.nfta.stopsTransaction.serviceImpl.RouteServiceImpl;
import com.nfta.stopsTransaction.serviceImpl.ServiceRequestServiceImpl;

@ComponentScan("com.nfta.stopsTransaction")
@SpringBootApplication
public class StopsTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(StopsTransactionApplication.class, args);
	}
	
	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public ServiceRequestService getServiceRequestService()
	{
		return new ServiceRequestServiceImpl();
	}
	

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public JavaMailSender getJavaMailSender()
	{
		return new JavaMailSenderImpl();
	}


}
