package com.capstoneproject.taskdata;

import com.capstoneproject.taskdata.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableFeignClients
public class TaskdataApplication {

	public static void main(String[] args) {

		SpringApplication.run(TaskdataApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean jwtFilter(){
//		returns list of intercepted URLs with defined JwtFilter class
		FilterRegistrationBean frb=new FilterRegistrationBean<>();
		frb.setFilter(new JwtFilter());
		frb.addUrlPatterns("/employee-details/v1/add-task/**");
		return frb;
	}
	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		final CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowCredentials(true);
		corsConfig.addAllowedOrigin("http://localhost:4200");
		corsConfig.addAllowedHeader("*");
		corsConfig.addAllowedMethod("*");

		final UrlBasedCorsConfigurationSource src = new UrlBasedCorsConfigurationSource();
		src.registerCorsConfiguration("/**",corsConfig);
		FilterRegistrationBean frb = new FilterRegistrationBean(new CorsFilter(src));
		frb.setOrder(Ordered.HIGHEST_PRECEDENCE);

		return frb;
	}

}
