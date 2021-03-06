package com.gesco.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private Environment env;
	
	
	private static final String[] PUBLIC_MATCHERS = {
			"/h2-console/**"

	};

	private static final String[] PUBLIC_MATCHERS_GET = {
			"/api/paciente/**",
			"/api/funcionario/**",
			"/api/login/**",
			"/api/antibiotico/**",
			"/api/prescricao/**",
			"/api/tratamento/**",
			"/api/hospital/**"
			
			
	};

	private static final String[] PUBLIC_MATCHERS_POST = {
			"/api/paciente/**",
			"/api/funcionario/**",
			"/api/login/**",
			"/api/antibiotico/**",
			"/api/prescricao/**",
			"/api/tratamento/**",
			"/api/hospital/**"
	};
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }
		
		http.cors().and().csrf().disable().addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
			.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(HttpMethod.PUT, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(HttpMethod.DELETE, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(HttpMethod.PATCH, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(PUBLIC_MATCHERS).permitAll()
			.anyRequest().authenticated();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {    
	    web.ignoring().antMatchers("/v2/api-docs/**");
	    web.ignoring().antMatchers("/swagger.json");
	    web.ignoring().antMatchers("/swagger-ui.html");
	    web.ignoring().antMatchers("/swagger-resources/**");
	    web.ignoring().antMatchers("/webjars/**");
	}
	

}
