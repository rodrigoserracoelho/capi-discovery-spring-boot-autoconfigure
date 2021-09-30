package io.surisoft.capi.lb.discovery.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CapiDiscoveryProperties.class)
@Slf4j
public class CapiDiscoveryAutoConfiguration {
    public CapiDiscoveryAutoConfiguration() {
        log.info("Starting Capi Auto Discovery");
    }
}
