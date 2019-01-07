package com.igate.contactbook.bean;

public class EnquiryBean {
	
	private int enqryId;
	private String fName;
	private String iName;
	private String contactNo;
	private String pLocation;
	private String pDomain;
	
	public int getEnqryId() {
		return enqryId;
	}
	public void setEnqryId(int enqryId) {
		this.enqryId = enqryId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getpLocation() {
		return pLocation;
	}
	public void setpLocation(String pLocation) {
		this.pLocation = pLocation;
	}
	public String getpDomain() {
		return pDomain;
	}
	public void setpDomain(String pDomain) {
		this.pDomain = pDomain;
	}
	
	@Override
	public String toString() {
		return "EnquiryBean [enquiryId=" + enqryId + ", fName=" + fName + ", iName=" + iName + ", contactNo="
				+ contactNo + ", pLocation=" + pLocation + ", pDomain=" + pDomain + "]";
	}
}
