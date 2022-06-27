package com.esanchezd.urlsln.service;

import com.esanchezd.urlsln.dto.GeoIPDTO;
import com.maxmind.db.Reader;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ua_parser.Client;
import ua_parser.Parser;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

import static java.util.Objects.nonNull;

@Service
public class GeoIPLocationServiceImpl implements GeoIPLocationService{

    private DatabaseReader databaseReader;
    
	private static final String UNKNOWN = "UNKNOWN";

	@PostConstruct 
	public void init() throws IOException{
	    Resource resouce = new ClassPathResource("geo/GeoLite2-Country.mmdb");
        this.databaseReader = new DatabaseReader.Builder(resouce.getInputStream()).build();		
	}
	    
    /**
     * Get device info by user agent
     *
     * @param userAgent user agent http device
     * @return Device info details
     * @throws IOException if not found
     */
    private String getDeviceDetails(String userAgent) throws IOException {
        String deviceDetails = UNKNOWN;

        Parser parser = new Parser();

        Client client = parser.parse(userAgent);
        if (nonNull(client)) {
            deviceDetails = client.userAgent.family + " " + client.userAgent.major + "." + client.userAgent.minor +
                    " - " + client.os.family + " " + client.os.major + "." + client.os.minor;
        }

        return deviceDetails;
    }    

    /**
     * get user position by ip address
     *
     * @param ip String ip address
     * @return UserPositionDTO model
     * @throws IOException     if local database city not exist
     * @throws GeoIp2Exception if cannot get info by ip address
     */
    @Override
    public GeoIPDTO getIpLocation(String ip, HttpServletRequest request) throws IOException, GeoIp2Exception {

    	GeoIPDTO position = new GeoIPDTO();
        String location;

        InetAddress ipAddress = InetAddress.getByName(ip);
        CountryResponse cResponse = databaseReader.country(ipAddress);
        //CityResponse cityResponse = databaseReader.city(ipAddress);
        
        if (nonNull(cResponse) && nonNull(cResponse.getCountry())) {
        	
            String continent = (cResponse.getContinent() != null) ? cResponse.getContinent().getName() : "";
            String country = (cResponse.getCountry() != null) ? cResponse.getCountry().getName() : "";

            position.setCountry(country);
            position.setContinent(continent);
            position.setDevice(getDeviceDetails(request.getHeader("user-agent")));
            position.setIpAddress(ip);

        }
        return position;
    }
}
