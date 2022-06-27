package com.esanchezd.urlsln.component;

import static java.util.Objects.nonNull;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.esanchezd.urlsln.dto.DeviceDetailDTO;

import ua_parser.Client;
import ua_parser.Parser;

@Component
public class DeviceDetailComponent {

	public DeviceDetailDTO getDeviceDetail(String userAgent, String ip, String id) throws IOException {
		DeviceDetailDTO deviDet = new DeviceDetailDTO();
		deviDet.setId(id);
		deviDet.setIp(ip);
        Parser parser = new Parser();

        Client client = parser.parse(userAgent);
        if (nonNull(client)) {
        	deviDet.setFamily(client.userAgent.family);
        	deviDet.setMajor(client.userAgent.major);
        	deviDet.setMinor(client.userAgent.minor);
        }
		return deviDet;
	}
	
}
