package com.hcfa.service;
 
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.hcfa.inte.CommonService;
import com.hcfa.material.inte.MaterialService;

import org.springframework.context.annotation.Bean;
 
import javax.xml.ws.Endpoint;
 
 
/**
 * @作者 Administrator
 * @创建日期 2018/6/23 0023
 * @创建时间 11:31.
 */
@Configuration
public class WebConfig {
    @Autowired
    private Bus bus;
    
 
    @Autowired
    CommonService service;
    
    @Autowired
    MaterialService materialService;
 
    /*jax-ws*/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, service);
        endpoint.publish("/CommonService");
        return endpoint;
    }
    
    @Bean
    public Endpoint endpoint2() {
        EndpointImpl endpoint = new EndpointImpl(bus, materialService);
        endpoint.publish("/MaterialService");
        return endpoint;
    }
}
