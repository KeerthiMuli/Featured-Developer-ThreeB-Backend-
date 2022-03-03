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
        .antMatchers(HttpMethod.POST, "/developers/create")
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
}
