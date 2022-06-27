package com.esanchezd.urlsln.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.esanchezd.urlsln.dto.GeoIPDTO;
import com.maxmind.geoip2.exception.GeoIp2Exception;

public interface GeoIPLocationService {
	GeoIPDTO getIpLocation(String ip, HttpServletRequest request) throws IOException, GeoIp2Exception;
}
