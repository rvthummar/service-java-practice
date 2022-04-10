package com.rv.servicejavapractice.controller;

import com.rv.servicejavapractice.model.CommonProxy;
import com.rv.servicejavapractice.service.PracticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/practice")
@Slf4j
public class PracticeController {
    @Autowired
    private PracticeService practiceService;

    @GetMapping(path = "/ping")
    public String ping() {
        log.info("Successfully ping");
        return "Successfully ping";
    }

    @GetMapping(path = "/ping1")
    public ResponseEntity<CommonProxy> ping1() {
        log.info("Successfully ping");
        return new ResponseEntity<CommonProxy>(new CommonProxy(practiceService.getData(),"Successfully ping", Boolean.TRUE, HttpStatus.OK.value()), HttpStatus.OK);
    }
}