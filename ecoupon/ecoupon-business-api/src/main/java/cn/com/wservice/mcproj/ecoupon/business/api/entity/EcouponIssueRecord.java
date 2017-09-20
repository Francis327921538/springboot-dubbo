package cn.com.wservice.mcproj.ecoupon.business.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 发放记录
 * @author cmf
 */
@Entity
@Data
@Table(name = "ecouponIssueRecord")
public class EcouponIssueRecord implements Serializable{
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 批号
     */
    @Column
    private String batchNumber;

    /**
     * 发放单位:虚拟外键，和发放单位表关联
     */
    @Column
    private String issuingUnit;

    /**
     * 电子券类型
     */
    @Column
    private Integer eStampType;

    /**
     * 操作员
     */
    @Column
    private String operator;

    /**
     * 发放总额
     */
    @Column
    private Double distributionTotal ;

    /**
     * 短信验证码
     */
    @Column
    private String SMSVerificationCode;

    /**
     * 校验码
     */
    @Column
    private String checkCode;

    /**
     * 状态
     */
    @Column
    private Integer state;

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
