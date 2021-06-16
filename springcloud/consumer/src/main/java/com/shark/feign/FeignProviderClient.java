package com.shark.feign;


import com.shark.entity.Library;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;

@FeignClient(value = "provider")
public interface FeignProviderClient {

    @GetMapping("/book/findAll/{page}/{size}")
    public Collection<Library> findAll(@PathVariable String size, @PathVariable String page);

    @GetMapping("/book/findById/{id}")
    public Library findById(@PathVariable("id") Integer id);
}
