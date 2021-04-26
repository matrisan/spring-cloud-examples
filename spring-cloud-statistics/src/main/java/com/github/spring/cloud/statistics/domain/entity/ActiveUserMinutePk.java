package com.github.spring.cloud.statistics.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 主键
 * <p>
 * create in 2021/4/25 11:22 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ActiveUserMinutePk implements Serializable {

    private static final long serialVersionUID = 411464346249482971L;

    private String hostname;

    private LocalDateTime dateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActiveUserMinutePk that = (ActiveUserMinutePk) o;
        return new EqualsBuilder().append(hostname, that.hostname).append(dateTime, that.dateTime).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(hostname).append(dateTime).toHashCode();
    }
}

