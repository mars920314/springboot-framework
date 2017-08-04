package com.datayes.framework.orm.dao.model.datayesdb;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.datayes.framework.orm.dao.model.CompanyInfo;
import com.datayes.framework.orm.dao.model.SecurityInfo;

public interface DatayesdbMapper {

	public List<CompanyInfo> selectTickers();
	
	public List<SecurityInfo> selectCompaniesByFilter(@Param("exchangeCD") String exchangeCD, @Param("assetClass") String assetClass);
	
}
