package com.example.User.controller;


import com.example.User.dao.SampleData;
import com.example.User.service.UserSampleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class UserController {
    @Autowired
    private UserSampleService userSampleService;



    @PostMapping(value = "/addUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String show(@RequestBody SampleData sampleData) {
        String data = "";
        try {
            Thread.sleep(5000);
            data = new ObjectMapper().writeValueAsString(sampleData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userSampleService.addSampleData(sampleData);
//        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/addition/{num}/{num1}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public int add(@PathVariable int num, @PathVariable int num1) {

        return num + num1;
    }

    @PostMapping(value = "/subtraction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public int show(@RequestParam(name = "num") int num, @RequestParam(name= "num1") int num1) {


        return num - num1;
    }

    @GetMapping(value = "/name/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String showName(@PathVariable  String name) {

        return "Hi "+ name +" How are you";
    }

}
