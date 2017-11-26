package com.fhirio.fhiremsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    
    @Bean
    public FhirClient getFhirClient() {
		return new FhirClient("https://fhirtesting.hdap.gatech.edu/hapi-fhir-jpaserver-example/baseDstu3");
//        return new FhirClient("http://localhost:8080/baseDstu3");
    }
    
    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
        b.indentOutput(true).mixIn(org.hl7.fhir.dstu3.model.Reference.class, ReferenceMixin.class);
        return b;
    }

    public interface ReferenceMixin {
    	 @JsonIgnore
    	 void setReferenceElement(org.hl7.fhir.dstu3.model.StringType reference);
        
    }
}
