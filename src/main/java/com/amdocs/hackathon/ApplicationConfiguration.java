package com.amdocs.hackathon;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;


@Configuration
public class ApplicationConfiguration implements WebMvcConfigurer {

  public static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
  @Autowired
  private ApplicationContext context;

  @Bean
  public HttpMessageConverter gsonHttpMessageConverter(GsonBuilder builder) {
    return new GsonHttpMessageConverter(
        builder.excludeFieldsWithoutExposeAnnotation()
            .create()
    );
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  public NamedParameterJdbcTemplate namedParameterJdbcTemplate(JdbcTemplate jdbcTemplate) {
    return new NamedParameterJdbcTemplate(jdbcTemplate);
  }

}
