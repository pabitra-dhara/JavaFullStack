package com.example.DemoProj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/hello")
	public static String helloWorld() {
		return "Hello World";
	}
}
