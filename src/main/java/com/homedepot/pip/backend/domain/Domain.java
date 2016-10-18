package com.homedepot.pip.backend.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.StandardToStringStyle;

/**
 * This is the domain object common from which all the domain object has to
 * extend from to get the benefit of THDDomain.
 * 
 */
public class Domain implements Serializable {
	private static final long serialVersionUID = 70863131270021328L;

	public String toString() {
		final StandardToStringStyle style = new StandardToStringStyle();
		style.setFieldSeparator("\n");
		style.setContentStart("\n*************** Start *************\n");
		style.setContentEnd("\n*************** End  *************\n");
		style.setArraySeparator("\n");
		style.setArrayStart("*** Array Start ***");
		style.setArrayEnd("*** Array End ***");
		return ReflectionToStringBuilder.toString(this, style);
	}
}
