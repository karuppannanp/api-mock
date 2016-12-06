package com.homedepot.pip.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class BeansConfig {

	private static XmlMapper XML_MAPPER;
	private static ObjectMapper OBJECT_MAPPER;

	public static ObjectMapper getObjectMapper() {
		if (OBJECT_MAPPER == null) {
			OBJECT_MAPPER = new ObjectMapper();
			OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
			OBJECT_MAPPER.setSerializationInclusion(Include.NON_NULL);
			OBJECT_MAPPER.setSerializationInclusion(Include.NON_EMPTY);
		}
		return OBJECT_MAPPER;
	}

	public static XmlMapper getXmlMapper() {
		if (XML_MAPPER == null) {
			XML_MAPPER = new XmlMapper();
			XML_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			XML_MAPPER.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
			XML_MAPPER.setSerializationInclusion(Include.NON_NULL);
			XML_MAPPER.setSerializationInclusion(Include.NON_EMPTY);
		}
		return XML_MAPPER;
	}
}