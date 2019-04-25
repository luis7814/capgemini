package co.com.capgemini.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import co.com.capgemini.bank.core.commons.utilities.JWTAuthorizationFilter;

@SpringBootApplication
public class MyBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBankApplication.class, args);
	}
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers("/v2/api-docs").permitAll()
				.antMatchers("/configuration/**").permitAll()
				.antMatchers("/swagger*/**").permitAll()
				.antMatchers("/webjars/**").permitAll()
				.anyRequest().authenticated();
		}
	}


}
