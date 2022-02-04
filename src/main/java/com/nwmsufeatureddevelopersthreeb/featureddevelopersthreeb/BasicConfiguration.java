package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebSecurity
@EnableWebMvc
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
     
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/").permitAll()
                                .antMatchers(HttpMethod.GET, "/developers/random").permitAll()
				.antMatchers(HttpMethod.GET, "/developers/randomshow").permitAll()
                                .antMatchers(HttpMethod.GET, "/developers/getall").permitAll()
                                .antMatchers("/**").permitAll()
                                .mvcMatchers("swagger-ui.html")
 
                                .permitAll().anyRequest().authenticated();
	}

}
