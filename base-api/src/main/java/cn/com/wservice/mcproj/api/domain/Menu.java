package cn.com.wservice.mcproj.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @Author RichardXu
 * @Description:
 * @Data: Created in 14:00 2017/9/19s
 */
@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name="base_menu")
public class Menu implements Serializable {

    /**
     * 菜单Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 前台url
     */
    private String foreUrl;
    /**
     * 后台url
     */
    private String backstgUrl;
    /**
     * 图标
     */
    private String icon;
    /**
     * 是否有用
     */
    private boolean available;

    /**
     * 所属菜单类别
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="menuCategoryId",referencedColumnName = "menuCategoryId")
    private MenuCategory menuCategory;

    /**
     * 上级菜单
     */
    @JsonBackReference
    @ManyToOne(cascade = javax.persistence.CascadeType.MERGE, fetch = FetchType.EAGER)
    private Menu parent;

    /**
     * 子菜单
     */
    @JsonManagedReference
    @OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "parent", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Set<Menu> children;

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
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", foreUrl='" + foreUrl + '\'' +
                ", backstgUrl='" + backstgUrl + '\'' +
                ", icon='" + icon + '\'' +
                ", available=" + available +
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
