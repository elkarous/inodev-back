package com.brightcoding.app.ws.security;





import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.brightcoding.app.ws.services.CondidatService;



@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter  {

	private final CondidatService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public Security(CondidatService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/condidat/add", "/","/login");
	}
	  
	
	   
	  
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
           http
				.cors().and()
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/ichat").permitAll()
				.antMatchers("/condidat/img/**").permitAll()
				.antMatchers("/document/doc/**").permitAll()
				.antMatchers("/document/download/**").permitAll()
				.antMatchers("/offer/Imgarticles/**").permitAll()
				.antMatchers("/specialite/Imgarticles/**").permitAll()
				.anyRequest().authenticated()
				

				.and()
				.addFilter(getAuthenticationFilter())
				.addFilter(new AuthorizationFilter(authenticationManager()))
				
				.sessionManagement()
			    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	


	protected AuthenticationFilter getAuthenticationFilter() throws Exception {
		final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
		filter.setFilterProcessesUrl("/users/login");
		return filter;
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
}
