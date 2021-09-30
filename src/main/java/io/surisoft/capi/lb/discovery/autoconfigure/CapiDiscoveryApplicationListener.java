package io.surisoft.capi.lb.discovery.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CapiDiscoveryApplicationListener implements ApplicationListener<ApplicationEvent> {

    @Autowired
    private CapiDiscoveryProperties capiDiscoveryProperties;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof ApplicationReadyEvent) {
            log.info("-----------------------------> " + applicationEvent.toString());
        } else if(applicationEvent instanceof ContextClosedEvent) {
            log.info("Application Stopped, removing service from load balancer");
        }
    }
}
