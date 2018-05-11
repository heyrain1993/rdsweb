package com.heyu.rdsweb;

import com.heyu.framework.interceptor.PageInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.heyu.*"})
public class RdswebApplication {

	public static void main(String[] args) {
		SpringApplication.run(RdswebApplication.class, args);
	}

	@Bean
	public PageInterceptor getPageInterceptor(){
		return new PageInterceptor();
	}
}
