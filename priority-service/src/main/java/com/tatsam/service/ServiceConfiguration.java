package com.tatsam.service;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tatsam.serivce")
@EntityScan({"com.tatsam.service.entity"})
public class ServiceConfiguration {
}
