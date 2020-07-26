package com.cuckoo.dao.impl.api;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cuckoo.dao.generic.DaoImpl;
import com.model.core.model.api.RewardEligibility;

@Repository
@Component("rewardEligibilityDao")
public class RewardEligibilityDaoImpl  extends DaoImpl<Integer , RewardEligibility>  implements RewardEligibilityDao {

}
