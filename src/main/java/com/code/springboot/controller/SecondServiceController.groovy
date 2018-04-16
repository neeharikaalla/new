package com.code.springboot.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class SecondServiceController {

    private static String url1 = "http://localhost:8080/1"
    private static String url2 = "http://localhost:8080/2"
    private static String url3 = "http://localhost:8080/3"
    private static String url4 = "http://localhost:8080/4"
    private static String url5 = "http://localhost:8080/5"
    private static String url6 = "http://localhost:8080/6"
    private static String url7 = "http://localhost:8080/7"
    private static String url8 = "http://localhost:8080/8"
    private static String url9 = "http://localhost:8080/9"
    private static String url10 = "http://localhost:8080/10"

    /**
     * Restful endpoint to manage the conversation from a requestBody!
     * Returns an object
     * @param number
     * @param name
     * @return
     */
    @RequestMapping(value = "/conversation", method = RequestMethod.POST)
    ResponseEntity<Object> conversation(
            @RequestBody Object obj, @RequestParam(value = 'Number', required = false) Integer number,
            @RequestParam(value = 'Name', required = false) String name) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null")
        }
        if (number == null) {
            number = 1
        } else if (number == 0) {
            return new ResponseEntity<Object>("Conversation is stopped ", HttpStatus.OK)
        }
        if (name == null) {
            name = ''
        }
        def req = obj as Map
        def first = req.conv."1"
        if (first.size() <= 0) {
            throw new IllegalArgumentException("array cannot be empty")
        }
        def newMap = new HashMap(10)
        for (int i = 1; i <= req.conv.size(); i++) {
            newMap.put(i, req.conv."$i")
        }
        def map = new HashMap()
        newMap.get(number).each { cha ->
            if (cha == 1) {
                map.put(cha, urlWriter(url1, name))
            } else if (cha == 2) {
                map.put(cha, urlWriter(url2, name))
            } else if (cha == 3) {
                map.put(cha, urlWriter(url3, name))
            } else if (cha == 4) {
                map.put(cha, urlWriter(url4, name))
            } else if (cha == 5) {
                map.put(cha, urlWriter(url5, name))
            } else if (cha == 6) {
                map.put(cha, urlWriter(url6, name))
            } else if (cha == 7) {
                map.put(cha, urlWriter(url7, name))
            } else if (cha == 8) {
                map.put(cha, urlWriter(url8, name))
            } else if (cha == 9) {
                map.put(cha, urlWriter(url9, name))
            } else if (cha == 10) {
                map.put(cha, urlWriter(url10, name))
            } else if (cha == 0) {
                map.put(cha, "No conversation")
            }
        }
        new ResponseEntity<Object>(map, HttpStatus.OK)
    }


    private static urlWriter(String url, String name) {
        url + "/${name}"
    }
}
