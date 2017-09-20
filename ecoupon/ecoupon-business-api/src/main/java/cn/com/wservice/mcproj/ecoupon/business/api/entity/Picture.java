package cn.com.wservice.mcproj.ecoupon.business.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author RichardXu
 * @Description:
 * @Data: Created in 16:23 2017/9/19
 */
@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name="content_picture")
public class Picture implements Serializable {

    /**
     * 图片Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String pictureId;

    /**
     * 图片名称
     */
    private String pictureName;
    /**
     * 图片描述
     */
    private String pictureDesc;
    /**
     * 上传路径
     */
    private String uploadImagePath;

    /**
     * 所属文章
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="articleId",referencedColumnName = "articleId")
    private Article article;

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
    private String modifiedUserName;


    @Override
    public String toString() {
        return "picture{" +
                "pictureId='" + pictureId + '\'' +
                ", pictureName='" + pictureName + '\'' +
                ", pictureDesc='" + pictureDesc + '\'' +
                ", uploadImagePath='" + uploadImagePath + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
