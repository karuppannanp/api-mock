package com.homedepot.pip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.homedepot.pip.util.constant.Constants;

@Configuration
public class BeansConfig {

	@Primary
	@Bean
	public ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
		return objectMapper;
	}

	@Bean
	public XmlMapper getXmlMapper() {
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		xmlMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		xmlMapper.setSerializationInclusion(Include.NON_NULL);
		xmlMapper.setSerializationInclusion(Include.NON_EMPTY);
		return xmlMapper;
	}

	@Bean
	public String getOnPremApiHost() {
		return "http://" + Constants.ENV_DEPENEDENT_API_HOST + ":80";
	}
	
	@Bean
	public String getGcpApiHost() {
		return "https://" + Constants.ENV_DEPENEDENT_GCP_API_HOST + ":443";
	}
}