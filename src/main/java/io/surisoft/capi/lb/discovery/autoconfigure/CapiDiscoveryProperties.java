package io.surisoft.capi.lb.discovery.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "capi.lb.discovery")
@Data
public class CapiDiscoveryProperties {
   private String host;
   private int port;
   private String context;
}