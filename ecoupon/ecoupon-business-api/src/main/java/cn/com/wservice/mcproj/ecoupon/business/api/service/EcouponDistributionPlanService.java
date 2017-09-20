package cn.com.wservice.mcproj.ecoupon.business.api.service;

import cn.com.wservice.mcproj.ecoupon.business.api.entity.EcouponDistributionPlan;

import java.util.List;

/**
 * 电子券发放计划管理servcie层接口
 * @author cmf
 */
public interface EcouponDistributionPlanService {
    /**
     * 按照id查询电子券发放计划信息
     * @param id
     * @return
     */
    public EcouponDistributionPlan findEcouponDistributionPlanById(Integer id);

    /**
     * 添加电子券发放计划信息
     * @param ecouponDistributionPlan
     * @return
     */
    public boolean addEcouponDistributionPlan(EcouponDistributionPlan ecouponDistributionPlan);

}
