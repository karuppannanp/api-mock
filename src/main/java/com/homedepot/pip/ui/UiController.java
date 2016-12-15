package com.homedepot.pip.ui;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.homedepot.pip.data.sku.attributeGroup.AttributeGroupMappings;

/**
 * @author KXP8101
 *
 */
@Controller
@RequestMapping("data/sku/")
public class UiController {

	@RequestMapping(value = "loadForm", method = RequestMethod.GET)
	public ModelAndView loadForm(HttpServletResponse res, ModelAndView mav)
			throws Exception {
		mav.addObject("guidToNameMappings", AttributeGroupMappings.getGuidToNameMappings());
		mav.addObject("attributeGroupNames", AttributeGroupMappings.getAttributeGroupNames());
		mav.setViewName("create/item");
		return mav;
	}
}