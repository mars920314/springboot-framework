package com.datayes.framework.orm.dao.model;

public class SecurityInfo {
	
	private Long securityIdInt;
	
	private String securityId;
	
	private String tickerSymbol;
	
	private String exchangeCd;
	
	private String secShortName;
	
	private String secFullName;
	
	private String secShortNameEn;
	
	private String secFullNameEn;
	
	private String assetClass;
	
	private Long partyId;
	
	private String partyFullName;
	
	private String listStatusCd;

    private String cnSpell;

	public Long getSecurityIdInt() {
		return securityIdInt;
	}

	public void setSecurityIdInt(Long securityIdInt) {
		this.securityIdInt = securityIdInt;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getTickerSymbol() {
		return tickerSymbol;
	}

	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}

	public String getExchangeCd() {
		return exchangeCd;
	}

	public void setExchangeCd(String exchangeCd) {
		this.exchangeCd = exchangeCd;
	}

	public String getSecShortName() {
		return secShortName;
	}

	public void setSecShortName(String secShortName) {
		this.secShortName = secShortName;
	}

	public String getSecFullName() {
		return secFullName;
	}

	public void setSecFullName(String secFullName) {
		this.secFullName = secFullName;
	}

	public String getSecShortNameEn() {
		return secShortNameEn;
	}

	public void setSecShortNameEn(String secShortNameEn) {
		this.secShortNameEn = secShortNameEn;
	}

	public String getSecFullNameEn() {
		return secFullNameEn;
	}

	public void setSecFullNameEn(String secFullNameEn) {
		this.secFullNameEn = secFullNameEn;
	}

	public String getAssetClass() {
		return assetClass;
	}

	public void setAssetClass(String assetClass) {
		this.assetClass = assetClass;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public String getPartyFullName() {
		return partyFullName;
	}

	public void setPartyFullName(String partyFullName) {
		this.partyFullName = partyFullName;
	}

	public String getListStatusCd() {
		return listStatusCd;
	}

	public void setListStatusCd(String listStatusCd) {
		this.listStatusCd = listStatusCd;
	}

	public String getCnSpell() {
		return cnSpell;
	}

	public void setCnSpell(String cnSpell) {
		this.cnSpell = cnSpell;
	}

}
