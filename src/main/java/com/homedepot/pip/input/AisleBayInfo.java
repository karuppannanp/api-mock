package com.homedepot.pip.input;

import java.util.List;

/**
 * @author KXP8101
 *
 */
public class AisleBayInfo {

	private SearchReport searchReport;
	private List<StoreSkuAisle> storeSkus;

	public SearchReport getSearchResult() {
		return searchReport;
	}

	public void setSearchReport(SearchReport searchReport) {
		this.searchReport = searchReport;
	}

	public List<StoreSkuAisle> getStoreSkus() {
		return storeSkus;
	}

	public void setStoreSkus(List<StoreSkuAisle> storeSkus) {
		this.storeSkus = storeSkus;
	}
}