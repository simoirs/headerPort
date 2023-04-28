package com.headerPort.util;

import java.util.Map;

import org.springframework.context.annotation.Bean;

public class HeaderPrinter {
	
	public static void printHeaders(Map<String, String> headers) {
		System.out.println("Request headers: ");	
		headers.forEach((header, value) -> System.out.println(header + ": " + value));
	}

}
