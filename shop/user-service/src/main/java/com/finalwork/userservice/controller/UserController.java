package com.finalwork.userservice.controller;

import com.finalwork.common.bussiness.dto.user.LoginDTO;
import com.finalwork.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    DiscoveryClient discoveryClient;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO){
        if (userService.checkLogin(loginDTO)){
            return "success";
        }
        return "failed";
    }

    @GetMapping("/server-list")
    public List<ServiceInstance> getServerList(){
        List<ServiceInstance> list = discoveryClient.getInstances("user-service");
        return list;
    }
}
