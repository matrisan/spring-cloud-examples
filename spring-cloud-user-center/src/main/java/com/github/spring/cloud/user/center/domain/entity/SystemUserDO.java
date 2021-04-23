package com.github.spring.cloud.user.center.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.spring.boot.common.framework.BaseEntity;
import com.github.spring.cloud.user.center.domain.converter.SystemPasswordConverter;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.Audited;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.github.spring.cloud.user.center.domain.common.OrmTableName.SYSTEM_USER;

/**
 * 用户实体类
 * <p>
 * create in 2021/4/2 4:43 下午
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
        name = SYSTEM_USER,
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_username", columnNames = {"username"}),
                @UniqueConstraint(name = "uk_mobile", columnNames = {"mobile"})
        })
@Audited
@EntityListeners(AuditingEntityListener.class)
public class SystemUserDO extends BaseEntity implements UserDetails {

    private static final long serialVersionUID = 6949655530047745714L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '用户名'")
    private String username;

    @Column(columnDefinition = "CHAR(20) COMMENT '手机号码'")
    private String mobile;

    @JsonIgnore
    @Column(columnDefinition = "VARCHAR(255) COMMENT '密码'")
    @Convert(converter = SystemPasswordConverter.class)
    private String password;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '邮箱'")
    private String email;

    @Transient
    @JsonManagedReference
    private Collection<SystemRoleDO> roles;

    @JsonIgnore
    @Column(name = "account_non_expired", columnDefinition = "DATETIME COMMENT '账户没有过期'")
    private Date accountNonExpired;

    @JsonIgnore
    @Column(name = "account_non_locked", columnDefinition = "DATETIME COMMENT '账户没有被锁定'")
    private Date accountNonLocked;

    @JsonIgnore
    @Column(name = "credentials_non_expired", columnDefinition = "DATETIME COMMENT '凭证没有过期'")
    private Date credentialsNonExpired;

    @JsonIgnore
    @Column(name = "last_login_date", columnDefinition = "DATETIME COMMENT '最后登录时间'")
    private Date lastLoginDate;

    @JsonIgnore
    @Override
    public Collection<SystemRoleDO> getAuthorities() {
        return roles;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    @DomainEvents
    public List<SystemUserDO> domainEvents() {
        return Lists.newArrayList(this);
    }

    @AfterDomainEventPublication
    public void callbackMethod() {
        log.info("AfterDomainEventPublication");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SystemUserDO that = (SystemUserDO) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId().hashCode());
    }
}
