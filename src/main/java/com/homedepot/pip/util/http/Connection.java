package com.homedepot.pip.util.http;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.homedepot.pip.exception.BadRequestException;
import com.homedepot.pip.exception.ProductNotFoundException;

@Configuration
public class Connection {

	@Bean
	public RestTemplate getRestTemplate() {

		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		RequestConfig config = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();

		HttpClient defaultHttpClient = HttpClientBuilder.create().setDefaultRequestConfig(config)
				.setConnectionManager(connectionManager).build();

		connectionManager.setMaxTotal(200);
		connectionManager.setDefaultMaxPerRoute(40);
		ClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				defaultHttpClient);

		return new RestTemplate(clientHttpRequestFactory);
	}

	public String makeRequest(String url) throws Exception {
		ResponseEntity<String> responseEntity = null;
		try {
			responseEntity = getRestTemplate().getForEntity(url, String.class);
			if (responseEntity.getStatusCode() != HttpStatus.OK) {
				if (responseEntity.getStatusCode() == HttpStatus.NOT_FOUND) {
					throw new ProductNotFoundException(responseEntity.getStatusCodeValue(), "Failed url: " + url);
				} else if (responseEntity.getStatusCode() == HttpStatus.BAD_REQUEST) {
					throw new BadRequestException(responseEntity.getStatusCodeValue(), "Failed url: " + url);
				}
				throw new Exception("StatusCode: " + responseEntity.getStatusCode() + " Failed url: " + url);
			}
			return responseEntity.getBody();
		} catch (HttpClientErrorException hcee) {
			if (hcee.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new ProductNotFoundException(hcee.getRawStatusCode(), "Failed url: " + url);
			} else if (hcee.getStatusCode() == HttpStatus.BAD_REQUEST) {
				throw new BadRequestException(hcee.getRawStatusCode(), "Failed url: " + url);
			}
			throw new Exception("StatusCode: " + hcee.getRawStatusCode() + " Failed url: " + url);
		}
	}
}