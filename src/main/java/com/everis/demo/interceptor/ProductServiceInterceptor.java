package com.everis.demo.interceptor;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ProductServiceInterceptor implements HandlerInterceptor {

	String cabecera = "";
	String valorCabecera = "";

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Enumeration en = request.getHeaderNames();
		while (en.hasMoreElements()) {

			String headerName = (String) en.nextElement();

			String headerValue = request.getHeader(headerName);
			if (headerName.equals("valor1")) {
				System.out.print("Cabecera de la peticion: Header Name = " + headerName + " " + " Header Value = "
						+ headerValue + ". ");
				this.cabecera = headerName;
				this.valorCabecera = headerValue;
			}
		}

		System.out.println("Pre Handle method is Calling");
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		response.setHeader(cabecera, valorCabecera + "Modificado");
//      Enumeration en2 = (Enumeration) response.getHeaderNames();
//	    while(en2.hasMoreElements()){
//
//	        String headerName = (String) en2.nextElement(); 
//
//	        String headerValue = response.getHeader(headerName);
//	        if(headerName.equals("valor1")) {
//	        	System.out.print("Cabecera de la respuesta: Header Name = "+ headerName + " " + " Header Value = "+ headerValue + ". ");
//	        }
//	    }
		
		//Esto da un problema 
		Collection<String> headerNames = response.getHeaderNames();

		while (!headerNames.isEmpty()) {
			String headerName = (String) headerNames.toString();

			System.out.println("Cabecera de la respuesta: Header Name = "+headerName + " Header Value = " + response.getHeader(headerName));
		}
		System.out.println("Post Handle method is Calling");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

		System.out.println("Request and Response is completed");
	}
}