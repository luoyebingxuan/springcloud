package com.hy.eurekaclient;

import com.hy.eurekaclient.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

@SpringBootApplication
@EnableEurekaClient
@Controller
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    @ResponseBody
    public String home(@RequestParam String name) {
        return "hi " + name + ",we are :" + port;
    }


    @RequestMapping("/test")
    @ResponseBody
    public ArrayList list() {
        User user = new User(1L , "wl" , "1234");
        User user2 = new User(2L , "wl" , "1234");
        User user3 = new User(3L , "wl" , "1234");
        ArrayList l1 = new ArrayList();
        l1.add(user);
        l1.add(user2);
        l1.add(user3);
        return l1;
    }

    @RequestMapping("/test2/{name}")
    @ResponseBody
    public String str(@PathVariable String name) {
        return "name = " + name;
    }


}
