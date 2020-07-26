package com.cuckoo.dao.impl.api;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cuckoo.dao.generic.DaoImpl;
import com.model.core.model.api.RewardEnablement;

@Repository
@Component("rewardEnablementDao")
public class RewardEnablementDaoImpl  extends DaoImpl<Integer , RewardEnablement>  implements RewardEnablementDao{

}
