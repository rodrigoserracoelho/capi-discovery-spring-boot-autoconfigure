package io.surisoft.capi.lb.discovery.autoconfigure.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CapiRegister {

    public void register(String capiHost, String name, String hostName, int port, String context) throws CapiDiscoveryException {
        try {
            RestTemplate restTemplate = new RestTemplate();
            CapiApi capiApi = new CapiApi();

            Mapping mapping = new Mapping();
            mapping.setHostname(hostName);
            mapping.setPort(port);
            mapping.setRootContext(context);

            capiApi.addToMapping(mapping);
            capiApi.setName(name);
            capiApi.setContext(context);
            capiApi.setProtocol("HTTP");

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<CapiApi> httpEntity = new HttpEntity<>(capiApi, httpHeaders);

            ResponseEntity<CapiApi> responseCapiApi = restTemplate.postForEntity(capiHost, httpEntity, CapiApi.class);

        } catch(Exception e) {
            throw new CapiDiscoveryException("Could not register this node on CAPI Load Balancer.");
        }
    }
}
