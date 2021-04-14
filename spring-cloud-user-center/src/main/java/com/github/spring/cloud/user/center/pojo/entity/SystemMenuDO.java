package com.github.spring.cloud.user.center.pojo.entity;

import com.github.spring.boot.common.framework.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.http.HttpMethod;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Collection;

/**
 * TODO
 * <p>
 * create in 2021/4/13 3:18 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(
        name = "system_menu",
        indexes = {@Index(name = "idx_parentId", columnList = "parent_id")}
)
@EntityListeners(AuditingEntityListener.class)
public class SystemMenuDO extends BaseEntity {

    private static final long serialVersionUID = -6112326475507480416L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "menu_name", nullable = false, columnDefinition = "VARCHAR(100) COMMENT '资源名称'")
    private String menuName;

    @Column(name = "menu_code", nullable = false, columnDefinition = "VARCHAR(100) COMMENT '资源唯一名称'")
    private String menuCode;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '资源URL'")
    private String url;

    @Column(columnDefinition = "CHAR(10) COMMENT '资源请求方式'")
    private HttpMethod method;

    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 0 COMMENT '菜单优先级'")
    private Integer priority;

    @Column(name = "menu_note", nullable = false, columnDefinition = "VARCHAR(100) COMMENT '资源URL'")
    private String menuNote;

    @Column(name = "parent_id", nullable = false, columnDefinition = "BIGINT COMMENT 'parentId'")
    private Long parentId;

    @Transient
    private Collection<SystemMenuDO> submenu;

}
