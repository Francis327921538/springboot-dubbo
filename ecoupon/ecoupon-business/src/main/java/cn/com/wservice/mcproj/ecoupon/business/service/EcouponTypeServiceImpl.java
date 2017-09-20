package cn.com.wservice.mcproj.ecoupon.business.service;

import cn.com.wservice.mcproj.ecoupon.business.api.entity.EcouponType;
import cn.com.wservice.mcproj.ecoupon.business.api.service.EcouponTypeService;
import cn.com.wservice.mcproj.ecoupon.dao.EcouponTypeDao;

import javax.annotation.Resource;
import java.util.List;

public class EcouponTypeServiceImpl implements EcouponTypeService{
    @Resource
    private EcouponTypeDao ecouponTypeDao;
    @Override
    public List<EcouponType> findEcouponTypeDaos() {
        return ecouponTypeDao.findEcouponTypes();
    }

    @Override
    public EcouponType findEcouponTypeDaoById(Integer id) {
        List<EcouponType> list = ecouponTypeDao.findEcouponTypeById(id);
        if(list!=null&&list.size()!=0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean addEcouponType(EcouponType ecouponType) {
        return null!=ecouponTypeDao.save(ecouponType);
    }

}
