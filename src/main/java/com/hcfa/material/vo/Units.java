package com.hcfa.material.vo;

import java.io.UnsupportedEncodingException;

import com.hcfa.util.CodeUtil;

public class Units {
    private Long rkey;

    private String unitCode;

    private String unitName;

    public Long getRkey() {
        return rkey;
    }

    public void setRkey(Long rkey) {
        this.rkey = rkey;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode == null ? null : unitCode.trim();
    }

    public String getUnitName() {
        try {
        	if("".equals(unitName)||unitName==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(unitName);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

	@Override
	public String toString() {
		return "Units [rkey=" + rkey + ", unitCode=" + unitCode + ", unitName=" + getUnitName() + "]";
	}
    
}