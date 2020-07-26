package com.cuckoo.dao.impl.api;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cuckoo.dao.generic.DaoImpl;
import com.model.core.model.api.RewardRedemption;

@Repository
@Component("rewardRedemptionDao")
public class RewardRedemptionDaoImpl extends DaoImpl<Integer , RewardRedemption>  implements RewardRedemptionDao{

}
