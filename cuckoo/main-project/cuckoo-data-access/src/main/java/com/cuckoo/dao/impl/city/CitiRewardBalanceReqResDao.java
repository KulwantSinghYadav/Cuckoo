package com.cuckoo.dao.impl.city;

import com.cuckoo.dao.generic.Dao;
import com.model.core.model.city.CitiRewardBalanceRequestResponse;

public interface CitiRewardBalanceReqResDao extends Dao<Integer , CitiRewardBalanceRequestResponse> {
	
	public void AddCityBalanceData();

}
