package io.surisoft.capi.lb.discovery.autoconfigure.http;

import java.util.ArrayList;
import java.util.List;

public class CapiApi {
    private String name;
    private String context;
    private String protocol;
    private List<Mapping> mappingList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public List<Mapping> getMappingList() {
        return mappingList;
    }

    public void setMappingList(List<Mapping> mappingList) {
        this.mappingList = mappingList;
    }

    public void addToMapping(Mapping mapping) {
        this.mappingList.add(mapping);
    }
}