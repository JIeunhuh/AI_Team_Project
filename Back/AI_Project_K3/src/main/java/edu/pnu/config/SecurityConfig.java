package edu.pnu.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import edu.pnu.filter.JwtAuthenticationFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationConfiguration authConfig;
    
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    // Security Setting
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
        .cors().and()
        .csrf(abcd -> abcd.disable())
        .httpBasic().disable()
        .sessionManagement(abcd -> abcd.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.authorizeHttpRequests(authorize -> {
            try {
				authorize
				        .requestMatchers("/member/**").authenticated()
				        .requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
				        .requestMatchers("/admin/**").hasRole("ADMIN")
				        // 권한 설정 추가 기억이겅 !!
// get method 권한 인증 .requestMatchers(HttpMethod.GET, ".api URI").permitAll()
				        .requestMatchers("/image",
				        		"/signup", "/login", 
				        		"/statistics/**",
				        		"/board/**", "/images/**",
				        		"/boardList","comments/**","/fileupload").permitAll()
				        .anyRequest().authenticated()
				        .and().exceptionHandling().authenticationEntryPoint(new FailedAuthenticationEntryPoint());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
        
       http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    

        return http.build();
    }
    
 
    class FailedAuthenticationEntryPoint implements AuthenticationEntryPoint{

		@Override
		public void commence(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException authException) throws IOException, ServletException {
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().write("{\"code\": \"NP\", \"message\":\"Do not have permission.\" }");
		}
    	
    }

    // password 암호화
    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

}
