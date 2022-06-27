package com.esanchezd.urlsln.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esanchezd.urlsln.entity.Urlshortener;
import com.esanchezd.urlsln.repository.UrlshortenerRepository;

@Service
public class UrlslnServiceImpl implements UrlslnService{

	@Autowired(required = true)
	private UrlshortenerRepository urlshortenerRepository;
	
	@Override
	public String getRedirectUrl(String id) throws Exception {
		
		Urlshortener urlShortener = urlshortenerRepository.getUrlshortener(id, Boolean.TRUE);
		if(urlShortener == null || urlShortener.getUrl() == null) {
			throw new Exception("No existe id en la BD que tenga url");
		}
		return urlShortener.getUrl();
	}

}
