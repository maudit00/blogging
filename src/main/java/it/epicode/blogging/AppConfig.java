package it.epicode.blogging;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.cloudinary.utils.*;

@Configuration
@PropertySource("application.properties")
/**
 * AppConfig
 */
public class AppConfig {
  @Bean
  public Cloudinary getCloudinary(@Value("${cloudinary.cloud_name}") String name,
      @Value("${cloudinary.api_key}") String key,
      @Value("${cloudinary.api_secret}") String secret) {

    return new Cloudinary(ObjectUtils.asMap(
        "cloud_name", name,
        "api_key", key,
        "api_secret", secret));

  }

}
