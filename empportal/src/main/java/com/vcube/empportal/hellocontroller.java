package com.vcube.empportal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontroller {
	@RequestMapping("/hello")
	String hello() {
		return "springboot is comedy!!";
	}
}
