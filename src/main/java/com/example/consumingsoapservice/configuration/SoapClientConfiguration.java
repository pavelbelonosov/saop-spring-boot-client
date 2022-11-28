
package com.example.consumingsoapservice.configuration;

import com.example.consumingsoapservice.service.ClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.example.consumingsoapservice.wsdl");
		return marshaller;
	}

	@Bean
	public ClientService client(Jaxb2Marshaller marshaller) {
		ClientService client = new ClientService();
		client.setDefaultUri("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}


}
