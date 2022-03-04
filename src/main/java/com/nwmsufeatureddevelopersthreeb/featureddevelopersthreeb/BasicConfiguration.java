package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.oauth2.client.registration.ClientRegistration;
// import
// org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository;
// import
// org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
// import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
  private final LogOut logoutHandler;

  public BasicConfiguration(LogOut logoutHandler) {
    this.logoutHandler = logoutHandler;
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.csrf()
        //  http.cors()
        .disable()
        .authorizeRequests()
        .antMatchers("/")
        .permitAll()
        .antMatchers(HttpMethod.GET, "/developers/random")
        .permitAll()
        .antMatchers(HttpMethod.GET, "/developers/randomshow")
        .permitAll()
        .antMatchers(HttpMethod.GET, "/developers/getall")
        .permitAll()
        .antMatchers(HttpMethod.GET, "/developers/getbyId/{developerId}")
        .permitAll()
        .antMatchers(HttpMethod.POST, "/developers/create")
        .permitAll()
        .antMatchers(HttpMethod.PUT, "/developers/update/{developerId}")
        .permitAll()
        .antMatchers(HttpMethod.DELETE, "/developers/delete/{developerId}")
        .permitAll()
        //    .antMatchers("/**").permitAll()
        .mvcMatchers("swagger-ui.html")
        .permitAll()
        .mvcMatchers("/")
        .permitAll()
        .mvcMatchers("/logout")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .oauth2Login()
        .and()
        .logout();
  }
}
/*@Bean
public WebMvcConfigurer corsConfigurer() {

    return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins(
                            "http://localhost:8080",
                            "http://localhost:8082" );
        }
    };
}
}*/

/*@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}*/

  /* @Bean
  ReactiveClientRegistrationRepository getRegistration(
          @Value("${spring.security.oauth2.client.provider.my-platform.token-uri}") String tokenUri,
          @Value("${spring.security.oauth2.client.registration.my-platform.client-id}") String clientId,
          @Value("${spring.security.oauth2.client.registration.my-platform.client-secret}") String clientSecret,
          @Value("${spring.security.oauth2.client.registration.my-platform.scopes}") String scope
  ) {
      ClientRegistration registration = ClientRegistration
              .withRegistrationId("my-platform")
              .tokenUri(tokenUri)
              .clientId(clientId)
              .clientSecret(clientSecret)
              .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
              .scope(scope)
              .build();
      return new InMemoryReactiveClientRegistrationRepository(registration);
  }*/
/*  @Bean
  public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			 public void addCorsMappings(CorsRegistry registry) {
registry.addMapping("/**")
.allowedOrigins("*")
.allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
}
		};
	}

}*/
