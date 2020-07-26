package com.cuckoo.dao.impl.api;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cuckoo.dao.generic.DaoImpl;
import com.model.core.model.api.RewardLinkage;

@Repository
@Component("rewardLinkageDao")
public class RewardLinkageDaoImpl  extends DaoImpl<Integer , RewardLinkage>  implements RewardLinkageDao{

}
