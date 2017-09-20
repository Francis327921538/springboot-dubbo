package cn.com.wservice.mcproj.ecoupon.business.api.service;

import cn.com.wservice.mcproj.ecoupon.business.api.entity.EcouponType;

import javax.annotation.Resource;
import java.util.List;

/**
 * 电子券类型管理service层接口
 * @author cmf
 */
public interface EcouponTypeService {

    /**
     * 查询电子券类型列表
     * @return
     */
    public List<EcouponType> findEcouponTypeDaos();

    /**
     * 按照id查询电子券
     * @param id
     * @return
     */
    public EcouponType findEcouponTypeDaoById(Integer id);

    /**
     * 添加电子券类型信息
     * @param ecouponType
     * @return
     */
    public boolean addEcouponType(EcouponType ecouponType);
}
