package com.headerPort.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.headerPort.util.HeaderPrinter;
import com.headerPort.util.PortChecker;

@RestController
public class AppController {
	
	@GetMapping("/")
	public ResponseEntity<String> listRequestHeaders(
			@RequestHeader Map<String, String> headers) {
		
		HeaderPrinter.printHeaders(headers);
		
		Gson gson = new Gson();
		String jsonHeaders = gson.toJson(headers);
		
		return new ResponseEntity<String>(jsonHeaders, HttpStatus.OK);
	}
	
	@GetMapping("/port/{portNumber}")
	public ResponseEntity<String> getPortAvailability(@PathVariable int portNumber) {
	
		if(PortChecker.checkPortIsAvailable(portNumber)) {
			return new ResponseEntity<String>("Port free to use", HttpStatus.OK);
		}
		else return new ResponseEntity<String>("Port already in use", HttpStatus.OK);
		
		
	}
	
	
	
}
