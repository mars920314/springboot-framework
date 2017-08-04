package com.datayes.framework.orm.dao.model;

public class CompanyInfo {
    private String tickerSymbol;
    private String fullName;
    private String shortName;
    private Long partyID;
    private String industry;
    private String industryID;
    private String securityID;
    private String cnSpell;

    public String getSecurityID() {
        return securityID;
    }

    public void setSecurityID(String securityID) {
        this.securityID = securityID;
    }

    public String getTickerSymbol() {
        return this.tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getIndustry() {
        return this.industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Long getPartyID() {
        return this.partyID;
    }

    public void setPartyID(Long partyID) {
        this.partyID = partyID;
    }

    public String getIndustryID() {
        return industryID;
    }

    public void setIndustryID(String industryID) {
        this.industryID = industryID;
    }

	public String getCnSpell() {
		return cnSpell;
	}

	public void setCnSpell(String cnSpell) {
		this.cnSpell = cnSpell;
	}
}
