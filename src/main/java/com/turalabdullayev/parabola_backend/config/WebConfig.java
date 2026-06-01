package com.turalabdullayev.parabola_backend.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		Path uploadDir = Paths.get("/app/uploads");
		String uploadPath = uploadDir.toFile().exists() ? uploadDir.toFile().getAbsolutePath()
				: Paths.get("./uploads").toFile().getAbsolutePath();

		registry.addResourceHandler("/uploads/**").addResourceLocations("file:" + uploadPath + "/");
	}
}