package cn.com.wservice.mcproj.ecoupon.business.api.service;

import cn.com.wservice.mcproj.ecoupon.business.api.entity.ElectronicCoupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zhangz on 2017/9/19.
 */
public interface ElectronicCouponService {

    ElectronicCoupon getOne(int id);

    List<ElectronicCoupon> listAll();

    ElectronicCoupon create(ElectronicCoupon electronicCoupon);

    ElectronicCoupon update(ElectronicCoupon electronicCoupon);

    Page<ElectronicCoupon> search(ElectronicCoupon electronicCoupon, Pageable pageable);
}
