package com.lujieni.swagger.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerBeanMapperConfigure {

    /**
     * DozerBeanMapper类是线程安全的
     * @return
     */
    @Bean
    public DozerBeanMapper mapper() {
        return new DozerBeanMapper();
    }
}
