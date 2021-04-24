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
 * create in 2021/4/13 3:21 下午
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
@Table(name = "system_mid_user_role")
@EntityListeners(AuditingEntityListener.class)
public class SystemMidUserRoleDO extends BaseEntity {

    private static final long serialVersionUID = 1758002168520712592L;

    public SystemMidUserRoleDO(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", columnDefinition = "BIGINT COMMENT '用户的 ID'")
    private Long userId;

    @Column(name = "role_id", columnDefinition = "BIGINT COMMENT '角色的 ID'")
    private Long roleId;

}
