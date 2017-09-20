package cn.com.wservice.mcproj.ecoupon.dao;

import cn.com.wservice.mcproj.ecoupon.business.api.entity.ElectronicCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by zhangz on 2017/9/19.
 */

/**
 * !importantspring data jpa参考资料http://blog.csdn.net/anxpp/article/details/51415698
 *
 *也可手写hql
 *
 * !important 不用写实现类
 */
public interface ElectronicCouponDao extends JpaRepository<ElectronicCoupon, Integer>, JpaSpecificationExecutor<ElectronicCoupon> {

/*  hql 实例
    @Query("from ElectronicCoupon")
    public List<ElectronicCoupon> getAll();
    @Query("from ElectronicCoupon where id = :id")
    public List<ElectronicCoupon> getByEId(@Param("id") int id);*/
}
