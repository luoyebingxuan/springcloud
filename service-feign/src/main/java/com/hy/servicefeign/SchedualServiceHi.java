package com.hy.servicefeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "server-hi" , fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

    @GetMapping("/hi")
    String sayHiFromClientOne(@RequestParam(value ="name" ) String name);
}
