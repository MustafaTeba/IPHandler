package com.example.demo;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IpHandler {

	static IP address;

	@PostMapping("/ip")
	IP setIP(@RequestBody IP ip) {
		this.address = ip;
		return ip;
	}

	@GetMapping
	String getIP() {
		return address.getIp() + " >> " + new Date().toString();
	}

}
