package com.everis.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorServiceController {
	

	@RequestMapping(value = "/interceptor")
	public void getInterceptor(/**@RequestHeader("valor1") int parametroCabecera**/) {

	}
 
}