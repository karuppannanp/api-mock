package com.homedepot.pip.request.api;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.pip.data.proxy.ProxyService;
import com.homedepot.pip.exception.BadRequestException;
import com.homedepot.pip.exception.ProductNotFoundException;
import com.homedepot.pip.request.validator.RequestValidator;
import com.homedepot.pip.util.constant.Constants;

@RestController
@RequestMapping("/")
public class GcpApiSkuController {
	
	private final String ERROR_JSON = "{\"error\":\"Input parameters are not valid\"}";
	
	@Autowired
	private RequestValidator requestValidator;
	
	@Autowired
	private ProxyService proxyService;
	
	@Autowired
	private ControllerHelper controllerHelper;

	@RequestMapping(value = "irg/v1", params = "itemId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getParentIrg(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "storeId") String storeId,
			@RequestParam(value = "irgCount", required = false) String irgCount,
			@RequestParam(value = "key") String key) throws Exception {
		System.out.println("irg/v1");

		if (!requestValidator.isKeyValid(key) || !requestValidator.isStoreAndOnlineStoreIdValid(storeId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return ERROR_JSON;
		}

		try {
			if (Constants.IS_PROXY_ENABLED) {
				return proxyService.parentIrgService(itemId, storeId, irgCount, key);
			} else {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return controllerHelper.getGcpApiProductNotFoundJson(itemId);
			}
		} catch (ProductNotFoundException pnfe) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return controllerHelper.getGcpApiProductNotFoundJson(itemId);
		} catch (BadRequestException bre) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return ERROR_JSON;
		}
	}

	@RequestMapping(value = "irg/v1", params = "irgIds", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getChildIrg(HttpServletResponse res,
			@RequestParam(value = "irgIds") String irgIds,
			@RequestParam(value = "storeId") String storeId,
			@RequestParam(value = "key") String key) throws Exception {
		System.out.println("irg/v1");

		if (!requestValidator.isKeyValid(key) || !requestValidator.isStoreAndOnlineStoreIdValid(storeId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return ERROR_JSON;
		}

		try {
			if (Constants.IS_PROXY_ENABLED) {
				return proxyService.childIrgService(irgIds, storeId, key);
			} else {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return controllerHelper.getGcpApiProductNotFoundJson(irgIds);
			}
		} catch (ProductNotFoundException pnfe) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return controllerHelper.getGcpApiProductNotFoundJson(irgIds);
		} catch (BadRequestException bre) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return ERROR_JSON;
		}
	}

	@RequestMapping(value = "fbt/v1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getFbt(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "storeId") String storeId,
			@RequestParam(value = "key") String key) throws Exception {
		System.out.println("irg/v1");

		if (!requestValidator.isKeyValid(key) || !requestValidator.isStoreAndOnlineStoreIdValid(storeId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return ERROR_JSON;
		}

		try {
			if (Constants.IS_PROXY_ENABLED) {
				return proxyService.fbtService(itemId, storeId, key);
			} else {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return controllerHelper.getGcpApiProductNotFoundJson(itemId);
			}
		} catch (ProductNotFoundException pnfe) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return controllerHelper.getGcpApiProductNotFoundJson(itemId);
		} catch (BadRequestException bre) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return ERROR_JSON;
		}
	}

	@RequestMapping(value = "fbr/v1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getFbr(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "storeId") String storeId,
			@RequestParam(value = "key") String key) throws Exception {
		System.out.println("irg/v1");

		if (!requestValidator.isKeyValid(key) || !requestValidator.isStoreAndOnlineStoreIdValid(storeId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return ERROR_JSON;
		}

		try {
			if (Constants.IS_PROXY_ENABLED) {
				return proxyService.fbrService(itemId, storeId, key);
			} else {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return controllerHelper.getGcpApiProductNotFoundJson(itemId);
			}
		} catch (ProductNotFoundException pnfe) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return controllerHelper.getGcpApiProductNotFoundJson(itemId);
		} catch (BadRequestException bre) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return ERROR_JSON;
		}
	}
}