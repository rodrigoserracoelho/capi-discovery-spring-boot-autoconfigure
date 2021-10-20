package io.surisoft.capi.lb.discovery.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CapiDiscoveryProperties.class)
@ConditionalOnClass(CapiDiscoveryApplicationListener.class)
@Slf4j
public class CapiDiscoveryAutoConfiguration {

    private final CapiDiscoveryProperties capiDiscoveryProperties;

    public CapiDiscoveryAutoConfiguration(CapiDiscoveryProperties capiDiscoveryProperties) {
        this.capiDiscoveryProperties = capiDiscoveryProperties;
        log.info("Starting Capi Auto Discovery");
    }

    @Bean
    @ConditionalOnMissingBean
    public CapiDiscoveryApplicationListener capiDiscoveryApplicationListener() {
        return new CapiDiscoveryApplicationListener(capiDiscoveryProperties);
    }
}