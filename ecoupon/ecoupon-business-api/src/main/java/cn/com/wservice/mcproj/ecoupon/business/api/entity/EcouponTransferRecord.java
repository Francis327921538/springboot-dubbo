package cn.com.wservice.mcproj.ecoupon.business.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 电子券流转记录表
 *
 * @author cmf
 */
@Entity
@Data
@Table(name = "ecouponTransferRecord")
public class EcouponTransferRecord implements Serializable{
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
    private String serialNumber;

    /**
     * 电子券编码
     */

    @Column
    private String coding;

    /**
     * 时间戳
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date Timestamp;

    /**
     * 动作时间类型
     */
    @Column
    private String actuationTimeType;

    /**
     * 事件验证码
     */
    @Column
    private String eventVerificationCode;

    /**
     * 社会统一信用代码
     */
    @Column
    private String socialUnifiedCreditCode;

    /**
     * 会员用户Id
     */
    @Column
    private String memberId;

    /**
     * 校验码
     */
    @Column
    private String checkCode;

    /**
     * 合同编号:除领券没有合同编号，其他都有
     */
    @Column
    private String contractNo;

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
    private Date modificationTime;

    /**
     * 修改人(N:1)
     */
    @JsonIgnore
    private String modifiedUserName;


}
