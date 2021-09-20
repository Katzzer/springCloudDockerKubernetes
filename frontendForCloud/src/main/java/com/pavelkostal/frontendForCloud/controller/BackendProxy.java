package com.pavelkostal.frontendForCloud.controller;

import com.pavelkostal.frontendForCloud.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="backend-server", url="localhost:8000")
public interface BackendProxy {
    
    // Address of the remote serer
    @GetMapping("/api/v2/employees")
    public List<Employee> connectToRestBackendWithFluxAndWebClientAndFeignClient(); 
}
