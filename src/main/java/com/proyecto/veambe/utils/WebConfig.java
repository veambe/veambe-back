package com.proyecto.veambe.utils;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Value("${upload.dir}")
  private String uploadDir;

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {

      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
            .allowedOrigins("http://localhost:5173")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*");
      }

    };
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    String fullUploadPath = Paths.get(uploadDir).toAbsolutePath().toUri().toString();
    registry.addResourceHandler("/uploads/**")
        .addResourceLocations(fullUploadPath);
        System.out.println("uploadDir = " + uploadDir);

  }
}
