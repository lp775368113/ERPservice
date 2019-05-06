package com.hcfa.material.vo;

import java.io.UnsupportedEncodingException;

import com.hcfa.util.CodeUtil;

public class Data0017 {
    private Integer id;

    private Integer erpid;
    
    private String status;
    
    private String rkey;

    private String ttype;

    private String invPartNumber;

    private String extraDesc;

    private String prodCodeSellPtr;

    private String prodSupper;

    private String package_;

    private String smtFlag;

    private String invPartDescriptionC;

    private String custPartName;

    private String custPartCode;

    private String purchUnitPtr;

    private String stockUnitPtr;

    private String supplierPtr;

    private String stdCost;

    private String stockPurch;

    private String iqcFlag;

    private String stockPakQty;

    private String stopPurch;

    private String qtyPerK;

    private String mwidth;

    private String mlength;

    private String restIqcDate;

    private String workManH;

    private String machH;
    
    private String prodCodeSellPtrStr;
    
    private String package_Str;
    

    public String getProdCodeSellPtrStr() {
		try {
        	if("".equals(prodCodeSellPtrStr)||prodCodeSellPtrStr==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(prodCodeSellPtrStr);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
	}

	public void setProdCodeSellPtrStr(String prodCodeSellPtrStr) {
		this.prodCodeSellPtrStr = prodCodeSellPtrStr;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getErpid() {
        return erpid;
    }

    public void setErpid(Integer erpid) {
        this.erpid = erpid;
    }

    public String getTtype() {
        try {
        	if("".equals(ttype)||ttype==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(ttype);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype == null ? null : ttype.trim();
    }

    public String getInvPartNumber() {
        try {
        	if("".equals(invPartNumber)||invPartNumber==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(invPartNumber);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setInvPartNumber(String invPartNumber) {
        this.invPartNumber = invPartNumber == null ? null : invPartNumber.trim();
    }

    public String getExtraDesc() {
        try {
        	if("".equals(extraDesc)||extraDesc==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(extraDesc);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setExtraDesc(String extraDesc) {
        this.extraDesc = extraDesc == null ? null : extraDesc.trim();
    }

    public String getProdCodeSellPtr() {
        try {
        	if("".equals(prodCodeSellPtr)||prodCodeSellPtr==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(prodCodeSellPtr);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setProdCodeSellPtr(String prodCodeSellPtr) {
        this.prodCodeSellPtr = prodCodeSellPtr == null ? null : prodCodeSellPtr.trim();
    }

    public String getProdSupper() {
        try {
        	if("".equals(prodSupper)||prodSupper==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(prodSupper);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setProdSupper(String prodSupper) {
        this.prodSupper = prodSupper == null ? null : prodSupper.trim();
    }

    public String getPackage_() {
		try {
        	if("".equals(package_)||package_==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(package_);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
	}

	public void setPackage_(String package_) {
		this.package_ = package_;
	}

	public String getSmtFlag() {
        return smtFlag;
    }

    public void setSmtFlag(String smtFlag) {
        this.smtFlag = smtFlag == null ? null : smtFlag.trim();
    }

    public String getInvPartDescriptionC() {
        try {
        	if("".equals(invPartDescriptionC)||invPartDescriptionC==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(invPartDescriptionC);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setInvPartDescriptionC(String invPartDescriptionC) {
        this.invPartDescriptionC = invPartDescriptionC == null ? null : invPartDescriptionC.trim();
    }

    public String getCustPartName() {
        try {
        	if("".equals(custPartName)||custPartName==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(invPartDescriptionC);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setCustPartName(String custPartName) {
        this.custPartName = custPartName == null ? null : custPartName.trim();
    }

    public String getCustPartCode() {
        try {
        	if("".equals(custPartCode)||custPartCode==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(custPartCode);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setCustPartCode(String custPartCode) {
        this.custPartCode = custPartCode == null ? null : custPartCode.trim();
    }

    public String getPurchUnitPtr() {
        try {
        	if("".equals(purchUnitPtr)||purchUnitPtr==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(purchUnitPtr);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setPurchUnitPtr(String purchUnitPtr) {
        this.purchUnitPtr = purchUnitPtr == null ? null : purchUnitPtr.trim();
    }

    public String getStockUnitPtr() {
        try {
        	if("".equals(stockUnitPtr)||stockUnitPtr==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(stockUnitPtr);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setStockUnitPtr(String stockUnitPtr) {
        this.stockUnitPtr = stockUnitPtr == null ? null : stockUnitPtr.trim();
    }

    public String getSupplierPtr() {
        try {
        	if("".equals(supplierPtr)||supplierPtr==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(supplierPtr);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setSupplierPtr(String supplierPtr) {
        this.supplierPtr = supplierPtr == null ? null : supplierPtr.trim();
    }

    public String getStdCost() {
        try {
        	if("".equals(stdCost)||stdCost==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(stdCost);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setStdCost(String stdCost) {
        this.stdCost = stdCost == null ? null : stdCost.trim();
    }

    public String getStockPurch() {
        try {
        	if("".equals(stockPurch)||stockPurch==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(stockPurch);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setStockPurch(String stockPurch) {
        this.stockPurch = stockPurch == null ? null : stockPurch.trim();
    }

    public String getIqcFlag() {
        return iqcFlag;
    }

    public void setIqcFlag(String iqcFlag) {
        this.iqcFlag = iqcFlag == null ? null : iqcFlag.trim();
    }

    public String getStockPakQty() {
        try {
        	if("".equals(stockPakQty)||stockPakQty==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(stockPakQty);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setStockPakQty(String stockPakQty) {
        this.stockPakQty = stockPakQty == null ? null : stockPakQty.trim();
    }

    public String getStopPurch() {
        try {
        	if("".equals(stopPurch)||stopPurch==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(stopPurch);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setStopPurch(String stopPurch) {
        this.stopPurch = stopPurch == null ? null : stopPurch.trim();
    }

    public String getQtyPerK() {
        try {
        	if("".equals(qtyPerK)||qtyPerK==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(qtyPerK);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setQtyPerK(String qtyPerK) {
        this.qtyPerK = qtyPerK == null ? null : qtyPerK.trim();
    }

    public String getMwidth() {
        try {
        	if("".equals(mwidth)||mwidth==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(mwidth);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setMwidth(String mwidth) {
        this.mwidth = mwidth == null ? null : mwidth.trim();
    }

    public String getMlength() {
        try {
        	if("".equals(mlength)||mlength==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(mlength);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setMlength(String mlength) {
        this.mlength = mlength == null ? null : mlength.trim();
    }

    public String getRestIqcDate() {
        try {
        	if("".equals(restIqcDate)||restIqcDate==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(restIqcDate);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setRestIqcDate(String restIqcDate) {
        this.restIqcDate = restIqcDate == null ? null : restIqcDate.trim();
    }

    public String getWorkManH() {
        try {
        	if("".equals(workManH)||workManH==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(workManH);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setWorkManH(String workManH) {
        this.workManH = workManH == null ? null : workManH.trim();
    }

    public String getMachH() {
        try {
        	if("".equals(machH)||machH==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(machH);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
    }

    public void setMachH(String machH) {
        this.machH = machH == null ? null : machH.trim();
    }

	public String getRkey() {
		try {
        	if("".equals(rkey)||rkey==null) {
        		return "";
        	}else {
        		return CodeUtil.getZW(rkey);
        	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
	}

	public void setRkey(String rkey) {
		this.rkey = rkey;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPackage_Str() {
		return package_Str;
	}

	public void setPackage_Str(String package_Str) {
		this.package_Str = package_Str;
	}
	
	
	
    
}