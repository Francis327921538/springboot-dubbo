package cn.com.wservice.mcproj.ecoupon.dao;

import cn.com.wservice.mcproj.ecoupon.business.api.entity.EcouponType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

/**
 * 电子券类型管理dao层接口
 * @author cmf
 */
public interface EcouponTypeDao extends JpaRepository<EcouponType, Serializable> {
    /**
     * 查询电子券类型列表
     * @return
     */
    @Query("from EcouponType")
    public List<EcouponType> findEcouponTypes();

    /**
     * 根据id查询电子券类型的详细信息
     * @param id
     * @return
     */
    @Query("from EcouponType where id = ?1")
    public List<EcouponType> findEcouponTypeById(Integer id);

}
