package com.hcfa.vo;

public class Para {
	private String starttime;
	private String endtime;
	private String xh;
	
	public String getXh() {
		return xh;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	/**
	 * @param xh the xh to set
	 */
	public void setXh(String xh) {
		this.xh = xh;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Para [startTime=" + starttime + ", endTime=" + endtime + ", xh=" + xh + "]";
	}
	
}
