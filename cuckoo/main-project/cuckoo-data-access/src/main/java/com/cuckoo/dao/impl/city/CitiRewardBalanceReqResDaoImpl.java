package com.cuckoo.dao.impl.city;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cuckoo.dao.generic.DaoImpl;
import com.model.core.model.city.CitiRewardBalanceRequestResponse;

@Repository
@Component("CitiRewardBalanceReqResDao")
public class CitiRewardBalanceReqResDaoImpl extends DaoImpl<Integer , CitiRewardBalanceRequestResponse>  implements CitiRewardBalanceReqResDao {
	
	@Override
	public void AddCityBalanceData() {
		// TODO Auto-generated method stub
		
	}

}
