package cn.com.wservice.mcproj.ecoupon.business.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author RichardXu
 * @Description:
 * @Data: Created in 15:37 2017/9/19
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="content_article")
public class Article implements Serializable{

    /**
     * 文章Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleId;

    /**
     * 标题
     */
    private String title;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 内容
     */
    private String content;
    /**
     * 来源/作者
     */
    private String author;
    /**
     * 出处
     */
    private String provenance;
    /**
     * 浏览次数
     */
    private Integer views;
    /**
     * 关键词
     */
    private String keywords;
    /**
     * 文章url
     */
    private String articleUrl;
    /**
     * 发布状态
     */
    private String publicStatus;
    /**
     * 缩略图
     */
    private String thumb;

    /**
     * 所属文章类别
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="articleCategoryId",referencedColumnName = "articleCategoryId")
    private ArticleCategory articleCategory;

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
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", provenance='" + provenance + '\'' +
                ", views=" + views +
                ", keywords='" + keywords + '\'' +
                ", articleUrl='" + articleUrl + '\'' +
                ", publicStatus='" + publicStatus + '\'' +
                ", thumb='" + thumb + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
