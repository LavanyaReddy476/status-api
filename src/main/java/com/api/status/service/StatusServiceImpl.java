package com.api.status.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


import com.api.status.modal.StatusModel;


@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	RestTemplate restTemplate;


	@Override
	public StatusModel getStatus(String url) {
		long startTime = System.currentTimeMillis();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		int statusCode = 0;
		try {
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
			statusCode = responseEntity.getStatusCode().value();

		}
		catch(RestClientResponseException restClientException) {		
			statusCode = restClientException.getStatusCode().value();
		}
		finally {
		long endTime = System.currentTimeMillis();
		return StatusModel.builder()
				.url(url)
				.statusCode(statusCode)
				.duration( endTime - startTime)
				.date(endTime)
				.build();
		}
	}



}
