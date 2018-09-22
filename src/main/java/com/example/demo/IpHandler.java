package com.example.demo;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IpHandler {

	static String remoteAddr;
	
	private HttpServletRequest request;

	 @Autowired
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	 
	@PostMapping("/ip")
	String setRemotePC_IP() {
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr + ":3389 >>" + new Date().toString();
	}

	@GetMapping
	String getIP() {
		return remoteAddr ;
	}

}
