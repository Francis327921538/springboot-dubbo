package cn.com.wservice.mcproj.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author RichardXu
 * @Description: 实体类 组织机构
 * @Data: Created in 15:11 2017/9/19
 */
@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name="base_sys_organization")
public class Organization implements Serializable{
    /**
     * 组织机构Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer organizationId;
    /**
     * 组织机构名称
     */
    private String organizationName;
    /**
     * 组织机构类型
     */
    private String organizationType;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="gmt_create")
    private Date gmtCreate;
    /**
     * 修改时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @org.hibernate.annotations.UpdateTimestamp
    @Column(name="gmt_modified")
    private Date gmtModified;

    /**
     * 修改人(N:1)
     */
    @JsonIgnore
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="modifiedUserId",referencedColumnName="id")
    private UserAccount modifiedUser;

    @Override
    public String toString() {
        return "Organization{" +
                "organizationId=" + organizationId +
                ", organizationName='" + organizationName + '\'' +
                ", organizationType='" + organizationType + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

    /**
     * 获取修改人
     * @return
     */
    @Transient
    public String getModifyUserName() {
        return null == this.getModifiedUser()?"无":this.getModifiedUser().getUserDetail().getUsername();
    }


}
