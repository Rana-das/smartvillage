package com.smart.village.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebServerStaticResourceConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("admin/show_hospitalInfo/**","mymensingh/**",
        		"/**","/admin/**","/hospitalInfo/**","/static/**","/barishal/**",
        		"/dhaka/**","/khulna/**","/rajshahi/**","/rangpur/**","/sylhet/**",
        		"/chittagong/**",
        		"/head/**","admin/update-hospital/**",
        		//university
        		"admin/update-university/**",
        		"/universityInfo/**","admin/show_universityInfo/**",
        		//Historical Place
        		"admin/update-historicalPlace/**",
        		"/universityInfo/**","admin/show_historicalPlaceInfo/**",
        		//traditionalFood
        		"admin/update-traditionalFoodInformation/**",
        		"/traditionalFoodInformationForm/**","admin/show_traditionalFood/**",
        		//CarGarage
        		"admin/update-cargarage/**",
        		"/traditionalFoodInformationForm/**","admin/show_cargarageInfo/**"
        		
        		
        		).addResourceLocations("classpath:/static/");
    }
}
