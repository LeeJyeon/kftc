package com.eletronicbanking.kftc.transaction.controller;

import com.eletronicbanking.kftc.transaction.service.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class requestKftc {


    @Autowired
    RequestServiceImpl requestService;

    @GetMapping("test")
    @ResponseBody
    public String findName(@RequestParam(value = "account") String account) {
        requestService.findName(account);
        return account;
    }
}

