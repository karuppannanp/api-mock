package com.homedepot.pip.util.http;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public enum Connection {

	INSTANCE;

	private RestTemplate restTemplate;
	private PoolingHttpClientConnectionManager connectionManager;

	private Connection() {

		connectionManager = new PoolingHttpClientConnectionManager();
		RequestConfig config = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();

		HttpClient defaultHttpClient = HttpClientBuilder.create().setDefaultRequestConfig(config)
				.setConnectionManager(connectionManager).build();

		connectionManager.setMaxTotal(200);
		connectionManager.setDefaultMaxPerRoute(40);
		ClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				defaultHttpClient);

		restTemplate = new RestTemplate(clientHttpRequestFactory);
	}

	@Deprecated
	public void shutdown() {
		connectionManager.shutdown();
	}

	public String makeRequest(String url) throws Exception {
		ResponseEntity<String> re = restTemplate.getForEntity(url, String.class);
		if (re.getStatusCode() != HttpStatus.OK) {
			throw new Exception("StatusCode: " + re.getStatusCode() + " getRequest() failed for url: " + url);
		}
		return re.getBody();
	}
}