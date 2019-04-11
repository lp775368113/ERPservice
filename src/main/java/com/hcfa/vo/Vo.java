package com.hcfa.vo;

import java.util.List;

public class Vo {
	private String name_code;
	private String xiaoliang;
	private String shuliang;
	
	/**
	 * @return the name_code
	 */
	public String getName_code() {
		return name_code;
	}
	/**
	 * @param name_code the name_code to set
	 */
	public void setName_code(String name_code) {
		this.name_code = name_code;
	}
	public String getXiaoliang() {
		return xiaoliang;
	}
	/**
	 * @param xiaoliang the xiaoliang to set
	 */
	public void setXiaoliang(String xiaoliang) {
		this.xiaoliang = xiaoliang;
	}
	/**
	 * @return the shuliang
	 */
	public String getShuliang() {
		return shuliang;
	}
	/**
	 * @param shuliang the shuliang to set
	 */
	public void setShuliang(String shuliang) {
		this.shuliang = shuliang;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vo [name_code=" + name_code + ", xiaoliang=" + xiaoliang + ", shuliang=" + shuliang + "]";
	}
	
	
}	
