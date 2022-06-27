package com.esanchezd.urlsln.repository;

import com.esanchezd.urlsln.entity.Urlshortener;

public interface UrlshortenerRepository {
	
	public Urlshortener getUrlshortener(String id, Boolean isActive);
	
}
