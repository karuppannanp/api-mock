package com.homedepot.pip.request.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.pip.data.proxy.ProxyService;

@RestController
@RequestMapping("/wcs/resources/")
public class ProxyController {

	@Autowired
	private ProxyService proxyService;

	@RequestMapping(value = "killswitch/KillSwitchesService/loadoptionsfromdb", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String proxyOptionsRegistry() throws Exception {
		System.out.println("Proxy - killswitch/KillSwitchesService/loadoptionsfromdb");
		return proxyService.optionsRegistry();
	}

	@RequestMapping(value = "LoadStoreInfo/StoreInfoService/loadStoreInfo", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String proxyStoresRegistry() throws Exception {
		System.out.println("Proxy - LoadStoreInfo/StoreInfoService/loadStoreInfo");
		return proxyService.storesRegistry();
	}
}