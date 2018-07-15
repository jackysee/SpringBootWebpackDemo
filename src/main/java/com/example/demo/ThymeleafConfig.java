package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ThymeleafConfig {
	
	public static final Logger logger  = LoggerFactory.getLogger(ThymeleafConfig.class);
	
	@Bean
	public ITemplateResolver frontendTemplateResolver() {
		logger.error(" --------------------- thymeleaf resolver111 ================");
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//		resolver.setApplicationContext(ac);
		resolver.setPrefix("classpath:/assets/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode(TemplateMode.HTML);
		resolver.setCharacterEncoding("UTF-8");
		resolver.setOrder(0);
		resolver.setCheckExistence(true);
		return resolver;
	}


}
