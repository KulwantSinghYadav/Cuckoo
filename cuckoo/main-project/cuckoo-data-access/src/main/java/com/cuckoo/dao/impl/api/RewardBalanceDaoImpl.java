package com.cuckoo.dao.impl.api;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cuckoo.dao.generic.DaoImpl;
import com.model.core.model.api.RewardBalance;

@Repository
@Component("rewardBalanceDao")
public class RewardBalanceDaoImpl extends DaoImpl<Integer , RewardBalance>  implements RewardBalanceDao {
	
}
