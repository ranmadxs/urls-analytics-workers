package com.esanchezd.urlsln.dto;

public class AnalyticEventDTO {
	private String ip;
	private String id;
	private String userAgent;
	
	
	public AnalyticEventDTO(String ip, String id, String userAgent) {
		super();
		this.ip = ip;
		this.id = id;
		this.userAgent = userAgent;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	
}
