package com.example.serveurprojetgrp

import org.springframework.web.bind.annotation.*

@RestController
class MyRestController {

    //http://localhost:8080/test
    @GetMapping("/test")
    fun testMethode(): String {
        println("/test")

        return "helloWorld"
    }
}