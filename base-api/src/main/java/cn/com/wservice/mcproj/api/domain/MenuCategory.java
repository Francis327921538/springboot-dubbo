package cn.com.wservice.mcproj.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.util.Date;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author RichardXu
 * @Description: 实体类 菜单类别
 * @Data: Created in 11:40 2017/9/19
 */
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name="base_menu_category")
public class MenuCategory implements Serializable{
        /**
         * 菜单类别Id
         */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer menuCategoryId;

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
        @ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name="modifiedUserId",referencedColumnName="id")
        private UserAccount modifiedUser;


        @Override
        public String toString() {
            return "MenuCategory [menuCategoryId=" + menuCategoryId
                    + ", categoryName=" + categoryName + ", categoryDesc="
                    + categoryDesc + ", gmtCreate=" + gmtCreate + ", gmtModified="
                    + gmtModified + "]";
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



