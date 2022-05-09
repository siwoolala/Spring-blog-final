package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogControllerTest {

	// localhos:8080/test/home
	@GetMapping("/test/home")
	public String testHome() {
		return "<h1>hello</h1>";
	}
}
