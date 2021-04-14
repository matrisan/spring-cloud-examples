package com.github.spring.cloud.user.center.core;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;
import java.util.Collections;

/**
 * TODO
 * <p>
 * create in 2021/1/14 7:02 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
//@Component
@RequiredArgsConstructor
public class SystemFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

//    private final ISystemResourceService service;

    /**
     * 需要根据请求的 URL 查询出访问这个 URL 需要哪些角色
     * 返回的 Collection 实际上是角色的集合
     *
     * @param object FilterInvocation
     * @return Collection
     * @throws IllegalArgumentException IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;
//        Collection<ConfigAttribute> configAttributes = service.findAllAntPathRequestMatcher().stream()
//                .filter(one -> one.getAntPathRequestMatcher().stream().anyMatch(sin -> sin.matches(fi.getRequest())))
//                .flatMap(one -> one.getRoles().stream().map(ISimpleRoleVO::getAuthority))
//                .map(one -> (ConfigAttribute) () -> one)
//                .collect(Collectors.toList());

//        return CollectionUtils.isEmpty(configAttributes) ? Collections.singleton(() -> "ROLE_ROOT") : addRoot(configAttributes);
        return null;
    }

    private Collection<ConfigAttribute> addRoot(Collection<ConfigAttribute> configAttributes) {
        configAttributes.add(() -> "ROLE_ROOT");
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return Collections.emptyList();
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
