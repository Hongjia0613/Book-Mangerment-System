package com.shark.controller;

import com.shark.entity.Library;
import com.shark.feign.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/feign")
public class ConsumerController {
    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping("/findAll/{page}/{size}")
    public Collection<Library> findAll(@PathVariable("page") String page, @PathVariable("size") String size){
        return feignProviderClient.findAll(size, page);
    }

    @GetMapping("/findById/{id}")
    public Library findById(@PathVariable("id") Integer id){
        return feignProviderClient.findById(id);
    }

}
