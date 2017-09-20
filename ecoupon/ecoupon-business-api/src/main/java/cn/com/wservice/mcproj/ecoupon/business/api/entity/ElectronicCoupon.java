package cn.com.wservice.mcproj.ecoupon.business.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 电子券
 */
@Entity
@Data
public class ElectronicCoupon implements Serializable {

    private static final long serialVersionUID = 3680262457489291976L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String coding;  //电子券编码:20位编码后+1位电子券类型
    private String batch;   //批次
    private String releaseUnit; //发放单位
    private Date releaseTime;   //发放时间
    private String nominalValue;    //面值
    private String checkCode;    //校验码
    private String state;   //状态
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;    //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifyTime;    //修改时间
    private String modifyUsername;  //修改人

}
