package com.tatsam.api.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"com.tatsam.api.controller"})
public class WebConfiguration implements WebMvcConfigurer {
}
