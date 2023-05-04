package com.api.status.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.status.constants.UrlMappings;
import com.api.status.modal.StatusModel;
import com.api.status.service.StatusService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/v1")
public class StatusController {

	@Autowired
	StatusService statusService;


	@GetMapping("/amazon-status")
	public StatusModel getAmazonStatus() {
		return statusService.getStatus(UrlMappings.AMAZON_URL.url);
	}

	@GetMapping("/google-status")
	public StatusModel getGoogleStatus() {
		return statusService.getStatus(UrlMappings.GOOGLE_URL.url);
	}

	@GetMapping("/all-status")
	public List<StatusModel> getAllStatus() {
		return Arrays.stream(UrlMappings.values())
				.map(value -> statusService.getStatus(value.url))
				.collect(Collectors.toList());   	
	}


}
