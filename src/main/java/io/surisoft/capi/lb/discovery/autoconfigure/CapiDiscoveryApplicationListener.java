package io.surisoft.capi.lb.discovery.autoconfigure;

import io.surisoft.capi.lb.discovery.autoconfigure.http.CapiDiscoveryException;
import io.surisoft.capi.lb.discovery.autoconfigure.http.CapiRegister;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CapiDiscoveryApplicationListener implements ApplicationListener<ApplicationEvent> {

    private CapiDiscoveryProperties capiDiscoveryProperties;

    public CapiDiscoveryApplicationListener(CapiDiscoveryProperties capiDiscoveryProperties) {
        this.capiDiscoveryProperties = capiDiscoveryProperties;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof ApplicationReadyEvent) {
            log.info("Application Started, trying to register your service with CAPI Load Balancer...");
            log.info(capiDiscoveryProperties.getCapiHost());
            log.info(capiDiscoveryProperties.getContext());
            log.info(capiDiscoveryProperties.getHost());

            CapiRegister capiRegister = new CapiRegister();
            try {
                capiRegister.register(capiDiscoveryProperties.getCapiHost(),
                        "smk-api", capiDiscoveryProperties.getHost(),
                        capiDiscoveryProperties.getPort(),
                        capiDiscoveryProperties.getContext());
            } catch (CapiDiscoveryException e) {
                if(capiDiscoveryProperties.isStopOnFailing()) {
                    ((ApplicationReadyEvent) applicationEvent).getApplicationContext().close();
                }
                log.warn(e.getMessage());
            }


        } else if(applicationEvent instanceof ContextClosedEvent) {
            log.info("Application Stopped, removing service from load balancer");
        }
    }
}