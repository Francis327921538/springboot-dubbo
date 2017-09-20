package cn.com.wservice.mcproj.ecoupon.business.service;

import cn.com.wservice.mcproj.ecoupon.business.api.entity.EcouponDistributionPlan;
import cn.com.wservice.mcproj.ecoupon.business.api.service.EcouponDistributionPlanService;
import cn.com.wservice.mcproj.ecoupon.dao.EcouponDistributionPlanDao;

import javax.annotation.Resource;
import java.util.List;

public class EcouponDistributionPlanServiceImpl implements EcouponDistributionPlanService{

    @Resource
    private EcouponDistributionPlanDao ecouponDistributionPlanDao;
    @Override
    public EcouponDistributionPlan findEcouponDistributionPlanById(Integer id) {
        List<EcouponDistributionPlan> list  = ecouponDistributionPlanDao.findEcouponDistributionPlanById(id);
        if(list!=null&&list.size()!=0)return list.get(0);
        return null;
    }

    @Override
    public boolean addEcouponDistributionPlan(EcouponDistributionPlan ecouponDistributionPlan) {
        return null!=ecouponDistributionPlanDao.save(ecouponDistributionPlan);
    }
}
