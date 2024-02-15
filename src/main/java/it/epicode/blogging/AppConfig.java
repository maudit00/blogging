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
  public Cloudinary getCloudinary(@Value("${cloud.name}") String name,
      @Value("${api.key}") String key,
      @Value("${api.secret}") String secret) {
    return new Cloudinary(ObjectUtils.asMap("cloud.name", name, "api.key", key, "api.secret", secret));

  }

}
