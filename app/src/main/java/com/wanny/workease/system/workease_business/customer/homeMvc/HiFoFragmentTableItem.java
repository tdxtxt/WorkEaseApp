package com.wanny.workease.system.workease_business.customer.homeMvc;

/**
 * 类名 ：HiFoFragmentTableItem.java
 * 功能 ：
 * 作者 ： wanny
 * 时间 ：2015年7月2日上午10:10:55
 */
public class HiFoFragmentTableItem {
	
	private String name;
	private int iconResourceId;
	private int losition;
	private Class<?> fragment;
	public String getName() {
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getIconResourceId()
	{
		return iconResourceId;
	}
	public void setIconResourceId(int iconResourceId) {

		this.iconResourceId = iconResourceId;
	}
	public int getLosition() {
		return losition;

	}
	public void setLosition(int losition) {

		this.losition = losition;
	}
	public Class<?> getFragment() {

		return fragment;
	}
	public void setFragment(Class<?> fragment) {

		this.fragment = fragment;
	}


}
