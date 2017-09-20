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
 * @Description: 实体类    内容文章类别
 * @Data: Created in 15:22 2017/9/19
 */
@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name="content_article_category")
public class ArticleCategory implements Serializable{

    /**
     * 文章类别Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleCategoryId;

    /**
     * 类别名称
     */
    private String categoryName;
    /**
     * 类别描述
     */
    private String categoryDesc;

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
        return "ArticleCategory{" +
                "articleCategoryId=" + articleCategoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDesc='" + categoryDesc + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }


}
