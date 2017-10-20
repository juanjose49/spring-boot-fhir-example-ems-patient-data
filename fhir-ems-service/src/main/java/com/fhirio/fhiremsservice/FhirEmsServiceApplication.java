package com.fhirio.fhiremsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fhirio.fhiremsservice.service.AuthenticationService;
import com.fhirio.fhiremsservice.service.EmergencyService;
import com.fhirio.fhiremsservice.service.OrganizationService;
import com.fhirio.fhiremsservice.service.PatientService;
import com.fhirio.fhiremsservice.service.UserService;

@SpringBootApplication
@Configuration
public class FhirEmsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FhirEmsServiceApplication.class, args);
	}
	
    @Bean
    public AuthenticationService getAuthenticationService() {
        return new AuthenticationService();
    }
    
    @Bean
    public EmergencyService getEmergencyService() {
        return new EmergencyService();
    }
    
    @Bean
    public OrganizationService getOrganizationService() {
        return new OrganizationService();
    }
    
    @Bean
    public PatientService getPatientService() {
        return new PatientService();
    }
    
    @Bean
    public UserService getUserService() {
        return new UserService();
    }
    
}
