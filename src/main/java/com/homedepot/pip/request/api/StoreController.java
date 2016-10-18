package com.homedepot.pip.request.api;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.pip.cache.store.StoreCache;
import com.homedepot.pip.request.validator.RequestValidator;

@RestController
@RequestMapping("/store/")
public class StoreController {

	private static final String SUCCESS_JSON = "{\"success\":true}";
	private static final String BAD_REQUEST_JSON = "{\"error\":\"One or more input parameters are invalid\"}";
	private static final String NOT_FOUND_JSON = "{\"error\":\"The store does not exist. Please check.\"}";

	@Autowired
	RequestValidator requestValidator;

	@RequestMapping(value = "flags/change", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createSku(HttpServletResponse res,
			@RequestParam(value = "storeId") String storeId,
			@RequestParam(value = "bopis", required = false) Boolean bopis,
			@RequestParam(value = "boss", required = false) Boolean boss,
			@RequestParam(value = "bodfs", required = false) Boolean bodfs,
			@RequestParam(value = "bossMsg", required = false) Boolean bossMsg) {

		if (!requestValidator.isStoreIdValid(storeId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return BAD_REQUEST_JSON;
		}

		if (!StoreCache.checkStoreInCache(storeId)) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return NOT_FOUND_JSON;
		}

		StoreCache.updateStoreFlags(storeId, bopis, boss, bossMsg, bodfs);
		return SUCCESS_JSON;
	}
}