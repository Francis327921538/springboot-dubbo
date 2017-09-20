package cn.com.wservice.mcproj.ecoupon.business.service;

import cn.com.wservice.mcproj.ecoupon.business.api.entity.ElectronicCoupon;
import cn.com.wservice.mcproj.ecoupon.business.api.service.ElectronicCouponService;
import cn.com.wservice.mcproj.ecoupon.dao.ElectronicCouponDao;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangz on 2017/9/19.
 */
@Service(version = "1.0.0")
public class ElectronicCouponServiceImpl implements ElectronicCouponService {

    @Resource
    private ElectronicCouponDao electronicCouponDao;

    @Override
    public ElectronicCoupon getOne(int id) {
        return electronicCouponDao.findOne(id);
    }

    @Override
    public List<ElectronicCoupon> listAll() {
        return electronicCouponDao.findAll();
    }

    @Override
    public ElectronicCoupon create(ElectronicCoupon electronicCoupon) {
        return electronicCouponDao.save(electronicCoupon);
    }

    @Override
    public ElectronicCoupon update(ElectronicCoupon electronicCoupon) {
        return electronicCouponDao.saveAndFlush(electronicCoupon);
    }

    @Override
    public Page<ElectronicCoupon> search(ElectronicCoupon electronicCoupon, Pageable pageable) {
        return electronicCouponDao.findAll(new Specification<ElectronicCoupon>() {
            @Override
            public Predicate toPredicate(Root<ElectronicCoupon> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.or(
                  criteriaBuilder.like(root.get("coding"), "%" + electronicCoupon.getCoding() + "%"),
                  criteriaBuilder.like(root.get("batch"), "%" + electronicCoupon.getBatch() + "%"),
                  criteriaBuilder.like(root.get("releaseUnit"), "%" + electronicCoupon.getReleaseUnit() + "%")
                );
                return criteriaBuilder.and(criteriaBuilder.equal(root.get("state"), electronicCoupon.getState()), predicate);
//                return criteriaBuilder.and(criteriaBuilder.between(root.get("modifyTime"),
//                        Date.from(LocalDateTime.of(2020,1,1,0,0,0).atZone(ZoneId.systemDefault()).toInstant()),
//                        Date.from(LocalDateTime.of(2050,1,1,0,0,0).atZone(ZoneId.systemDefault()).toInstant())));
            }
        }, pageable);
    }


}
