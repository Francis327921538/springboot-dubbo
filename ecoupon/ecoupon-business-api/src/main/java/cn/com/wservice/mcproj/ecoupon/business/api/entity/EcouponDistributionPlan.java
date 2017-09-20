package cn.com.wservice.mcproj.ecoupon.business.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 电子券发放计划表
 *
 * @author :cmf
 */
@Entity
@Data
@Table(name = "ecouponDistributionPlan")
public class EcouponDistributionPlan implements Serializable{
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 流水号
     */
    @Column
    private String streamNumber;

    /**
     * 批号
     */
    @Column
    private String batchNumber;

    /**
     * 发布时间计划
     */

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date releaseTimePlan;

    /**
     * 计划类型
     */
    @Column
    private String projectType;

    /**
     * 计划发放金额
     */
    @Column
    private Double plannedDisbursingAmount;

    /**
     * 计划发布者
     */
    @Column
    private String publisher;

    /**
     * 计划执行时间
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledTime;

    /**
     * 计划状态:待创建电子券（计划可撤销）
     * ；已创建电子券；已发放电子券（系统不能做任意修改）
     */
    @Column
    private Integer statePlan;

    /**
     * 验证码
     */
    @Column
    private String verificationCode;

    /**
     * 校验码
     */
    @Column
    private String checkCode;

    /**
     * 创建时间
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    /**
     * 修改时间
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyTime;

    /**
     * 修改人(N:1)
     */
    @JsonIgnore
    private String modifiedUserName;


}

