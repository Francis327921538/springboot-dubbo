package cn.com.wservice.mcproj.ecoupon.dao;

import cn.com.wservice.mcproj.ecoupon.business.api.entity.EcouponDistributionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

/**
 * 电子券发放计划管理接口
 * @author cmf
 */
public interface EcouponDistributionPlanDao extends JpaRepository<EcouponDistributionPlan,Serializable>{

    /**
     * 按照id查询电子券发放计划信息
     * @param id
     * @return
     */
    @Query("from EcouponDistributionPlan where id=?")
    public List<EcouponDistributionPlan> findEcouponDistributionPlanById(Integer id);


}
