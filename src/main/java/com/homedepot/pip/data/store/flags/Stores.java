/**
 * 
 */
package com.homedepot.pip.data.store.flags;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author KXP8101
 * 
 */
@JacksonXmlRootElement(localName = "StoreInfoData")
public class Stores {

	@JacksonXmlProperty(localName = "com.homedepot.sa.el.restful.services.util.StoreInfoBeanVO")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Store[] stores;

	/**
	 * @return the stores
	 */
	public Store[] getStores() {
		return stores;
	}

	/**
	 * @param stores the stores to set
	 */
	public void setStores(Store[] stores) {
		this.stores = stores;
	}
}