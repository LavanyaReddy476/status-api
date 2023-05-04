package com.api.status.modal;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusModel {
	private String url;
	private int statusCode;
	private long duration;
	private long date;
	
}
