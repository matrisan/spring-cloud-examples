package com.github.spring.cloud.statistics.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * TODO
 * <p>
 * create in 2021/4/25 5:19 下午
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
@IdClass(ActiveUserMinutePk.class)
@Table(name = "active_user_day")
@EntityListeners(AuditingEntityListener.class)
public class ActiveUserDayDO implements Serializable {

    private static final long serialVersionUID = 5511840023439828784L;

    @Id
    @Column(columnDefinition = "VARCHAR(20) COMMENT '域名'")
    private String hostname;

    @Id
    @Column(name = "date_time", columnDefinition = "DATETIME COMMENT '日志时间'")
    private LocalDateTime dateTime;

    @Column(columnDefinition = "INT UNSIGNED COMMENT '统计值'")
    private Long count;

    @CreatedDate
    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastModifiedDate;

}
