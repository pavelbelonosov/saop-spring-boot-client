
package com.example.consumingsoapservice.service;

import com.example.consumingsoapservice.wsdl.FullCountryInfoAllCountries;
import com.example.consumingsoapservice.wsdl.FullCountryInfoAllCountriesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ClientService extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(ClientService.class);

	public FullCountryInfoAllCountriesResponse getCountriesInfo() {
		FullCountryInfoAllCountries request = new FullCountryInfoAllCountries();
		log.info("Requesting Full Country Info All Countries");
		FullCountryInfoAllCountriesResponse response = (FullCountryInfoAllCountriesResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso",
						request);
		return response;
	}

}
