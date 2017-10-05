package com.aus.simon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.aus.simon")
@EnableAspectJAutoProxy
public class AppConfig {
    
}
