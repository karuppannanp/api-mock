/**
 * 
 */
package com.homedepot.pip.backend.store.fulfillment;

import com.homedepot.pip.backend.store.fulfillment.days.Friday;
import com.homedepot.pip.backend.store.fulfillment.days.Monday;
import com.homedepot.pip.backend.store.fulfillment.days.Saturday;
import com.homedepot.pip.backend.store.fulfillment.days.Sunday;
import com.homedepot.pip.backend.store.fulfillment.days.Thursday;
import com.homedepot.pip.backend.store.fulfillment.days.Tuesday;
import com.homedepot.pip.backend.store.fulfillment.days.Wednesday;

/**
 * @author KXP8101
 *
 */
public class StoreHours {

	private Monday monday;
	private Tuesday tuesday;
	private Wednesday wednesday;
	private Thursday thursday;
	private Friday friday;
	private Saturday saturday;
	private Sunday sunday;

	public Monday getMonday() {
		return monday;
	}

	public void setMonday(Monday monday) {
		this.monday = monday;
	}

	public Tuesday getTuesday() {
		return tuesday;
	}

	public void setTuesday(Tuesday tuesday) {
		this.tuesday = tuesday;
	}

	public Wednesday getWednesday() {
		return wednesday;
	}

	public void setWednesday(Wednesday wednesday) {
		this.wednesday = wednesday;
	}

	public Thursday getThursday() {
		return thursday;
	}

	public void setThursday(Thursday thursday) {
		this.thursday = thursday;
	}

	public Friday getFriday() {
		return friday;
	}

	public void setFriday(Friday friday) {
		this.friday = friday;
	}

	public Saturday getSaturday() {
		return saturday;
	}

	public void setSaturday(Saturday saturday) {
		this.saturday = saturday;
	}

	public Sunday getSunday() {
		return sunday;
	}

	public void setSunday(Sunday sunday) {
		this.sunday = sunday;
	}
}