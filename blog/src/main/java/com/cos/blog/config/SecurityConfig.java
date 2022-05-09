package com.cos.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// 빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것

@Configuration // 빈등록(IOC 관리)
@EnableWebSecurity // 시큐리티 필터 추가 = 스프링 시큐리티가 활성화가 되어 있는데 어떤 설정을 해당 파일에서 하겠다.
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable() //csrf 토큰 비활성화 (테스트시 걸어두는 게 좋음)
		.authorizeHttpRequests() // request가 들어오면
			.antMatchers("/", "/auth/**","/js/**", "/css/**", "/image/**") // 이 주소로 들어오면
			.permitAll() // permit : 허용하다
			.anyRequest() // 그리고 이게 아닌 모든 요청은
			.authenticated() // 인증이 되어야 해!!
		.and()
			.formLogin()
			.loginPage("/auth/loginForm")
			.loginProcessingUrl("/auth/loginProc")
			.defaultSuccessUrl("/");
	}
}
