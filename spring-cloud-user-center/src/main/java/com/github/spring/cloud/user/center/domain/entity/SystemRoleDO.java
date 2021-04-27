package com.github.spring.cloud.user.center.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.spring.boot.common.framework.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import java.util.Collection;
import java.util.Objects;

import static com.github.spring.cloud.user.center.domain.common.OrmTableName.SYSTEM_ROLE;


/**
 * <p>
 * 创建时间为 下午3:22 2020/5/10
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

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
        name = SYSTEM_ROLE,
        uniqueConstraints = {@UniqueConstraint(name = "uk_role_name", columnNames = {"role_name"})}
)
@EntityListeners(AuditingEntityListener.class)
public class SystemRoleDO extends BaseEntity implements GrantedAuthority {

    private static final long serialVersionUID = -3157807413812174641L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", columnDefinition = "CHAR(20) COMMENT '角色名称'")
    private String roleName;

    @Column(name = "role_code", columnDefinition = "CHAR(20) COMMENT '角色编码'")
    private String roleCode;

    @Transient
    @JsonBackReference
    private Collection<SystemUserDO> users;


    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SystemRoleDO that = (SystemRoleDO) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId().hashCode());
    }
}
