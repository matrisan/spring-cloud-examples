package com.github.spring.cloud.user.center.domain.entity;

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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TODO
 * <p>
 * create in 2021/4/13 3:22 下午
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
@Table(name = "system_mid_role_menu")
@EntityListeners(AuditingEntityListener.class)
public class SystemMIdRoleMenuDO extends BaseEntity {

    private static final long serialVersionUID = 7665025547581755881L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_id", columnDefinition = "BIGINT COMMENT '角色的 ID'")
    private Long roleId;

    @Column(name = "menu_id", columnDefinition = "BIGINT COMMENT '菜单的 ID'")
    private Long menuId;

}
