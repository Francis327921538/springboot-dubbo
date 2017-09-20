package cn.com.wservice.mcproj.ecoupon.business.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *  电子券类型表
 *　@author cmf
 */
@Entity
@Data
@Table(name="ecoupon_type")
public class EcouponType implements Serializable{
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 电子券类型名称（专用券Z；通用券T）
     */
    @Column
    private Integer typeName;
    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date creationTime;
    /**
     * 修改时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    public Date modificationTime;

    /**
     * 修改人(N:1)
     */
    @JsonIgnore
    private String modifiedUserName;


}
