package com.shark.controller;

import com.shark.entity.Library;
import com.shark.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class LibraryHandler {
    @Autowired
    private LibraryRepository bookRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Library> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return bookRepository.findAll(request);
    }

    @PostMapping("/save")
    public String save(@RequestBody Library book){
        Library result = bookRepository.save(book);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Library findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Library book){
        Library result = bookRepository.save(book);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }
}
