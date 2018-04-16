package com.code.springboot.controller

import com.google.common.base.Strings
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import java.time.LocalDate
import java.time.LocalDateTime


@RestController
class NewServiceController {

    String arr = "abcdefghijklm"

    @RequestMapping(value = "/1/{Name}", method = RequestMethod.GET)
    ResponseEntity<Object> name(
            @PathVariable(value = "Name") String name) {

        def nameJson = new HashMap()
        LocalDateTime dateTime = LocalDateTime.now()
        LocalDate today = LocalDate.now()
        nameJson.put("name", name as String)
        nameJson.put("date", today.toString() as String)
        nameJson.put("time", dateTime.toLocalTime().toString() as String)

        def cha
        if (!Strings.isNullOrEmpty(name)) {
            cha = name.charAt(0)
        }
            //check if the static array of chars contains the first char of name then return json
            if (arr.contains(cha.toString())) {
                HttpHeaders headers = new HttpHeaders()
                headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                return new ResponseEntity<Object>(nameJson.toString(), headers, HttpStatus.OK,)

            } else {
                HttpHeaders headers = new HttpHeaders()
                headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE)
                return new ResponseEntity<Object>(nameXml(name, today, dateTime),headers, HttpStatus.OK)
            }
    }


    @RequestMapping(value = "/2/{Name}", method = RequestMethod.GET)
    ResponseEntity<Object> second(
            @PathVariable(value = "Name") String name) {

        def nameJson = new HashMap()
        LocalDateTime dateTime = LocalDateTime.now()
        LocalDate today = LocalDate.now()
        nameJson.put("name", name as String)
        nameJson.put("date", today.toString() as String)
        nameJson.put("time", dateTime.toLocalTime().toString() as String)

        def cha
        if (!Strings.isNullOrEmpty(name)) {
            cha = name.charAt(0)
        }
        //check if the static array of chars contains the first char of name then return json
        if (arr.contains(cha.toString())) {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            return new ResponseEntity<Object>(nameJson.toString(), headers, HttpStatus.OK,)

        } else {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE)
            return new ResponseEntity<Object>(nameXml(name, today, dateTime),headers, HttpStatus.OK)
        }
    }

    @RequestMapping(value = "/3/{Name}", method = RequestMethod.GET)
    ResponseEntity<Object> third(
            @PathVariable(value = "Name") String name) {

        def nameJson = new HashMap()
        LocalDateTime dateTime = LocalDateTime.now()
        LocalDate today = LocalDate.now()
        nameJson.put("name", name as String)
        nameJson.put("date", today.toString() as String)
        nameJson.put("time", dateTime.toLocalTime().toString() as String)

        def cha
        if (!Strings.isNullOrEmpty(name)) {
            cha = name.charAt(0)
        }
        //check if the static array of chars contains the first char of name then return json
        if (arr.contains(cha.toString())) {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            return new ResponseEntity<Object>(nameJson.toString(), headers, HttpStatus.OK,)

        } else {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE)
            return new ResponseEntity<Object>(nameXml(name, today, dateTime),headers, HttpStatus.OK)
        }
    }

    @RequestMapping(value = "/4/{Name}", method = RequestMethod.GET)
    ResponseEntity<Object> fourth(
            @PathVariable(value = "Name") String name) {

        def nameJson = new HashMap()
        LocalDateTime dateTime = LocalDateTime.now()
        LocalDate today = LocalDate.now()
        nameJson.put("name", name as String)
        nameJson.put("date", today.toString() as String)
        nameJson.put("time", dateTime.toLocalTime().toString() as String)

        def cha
        if (!Strings.isNullOrEmpty(name)) {
            cha = name.charAt(0)
        }
        //check if the static array of chars contains the first char of name then return json
        if (arr.contains(cha.toString())) {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            return new ResponseEntity<Object>(nameJson.toString(), headers, HttpStatus.OK,)

        } else {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE)
            return new ResponseEntity<Object>(nameXml(name, today, dateTime),headers, HttpStatus.OK)
        }
    }


    @RequestMapping(value = "/5/{Name}", method = RequestMethod.GET)
    ResponseEntity<Object> fifth(
            @PathVariable(value = "Name") String name) {

        def nameJson = new HashMap()
        LocalDateTime dateTime = LocalDateTime.now()
        LocalDate today = LocalDate.now()
        nameJson.put("name", name as String)
        nameJson.put("date", today.toString() as String)
        nameJson.put("time", dateTime.toLocalTime().toString() as String)

        def cha
        if (!Strings.isNullOrEmpty(name)) {
            cha = name.charAt(0)
        }
        //check if the static array of chars contains the first char of name then return json
        if (arr.contains(cha.toString())) {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            return new ResponseEntity<Object>(nameJson.toString(), headers, HttpStatus.OK,)

        } else {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE)
            return new ResponseEntity<Object>(nameXml(name, today, dateTime),headers, HttpStatus.OK)
        }
    }


    @RequestMapping(value = "/6/{Name}", method = RequestMethod.GET)
    ResponseEntity<String> six(
            @PathVariable(value = "Name") String name) {

        def nameJson = new HashMap()
        LocalDateTime dateTime = LocalDateTime.now()
        LocalDate today = LocalDate.now()
        nameJson.put("name", name as String)
        nameJson.put("date", today.toString() as String)
        nameJson.put("time", dateTime.toLocalTime().toString() as String)

        def cha
        if (!Strings.isNullOrEmpty(name)) {
            cha = name.charAt(0)
        }
        //check if the static array of chars contains the first char of name then return json
        if (arr.contains(cha.toString())) {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            return new ResponseEntity<String>(nameJson.toString(), headers, HttpStatus.OK,)

        } else {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE)
            return new ResponseEntity<String>(nameXml(name, today, dateTime),headers, HttpStatus.OK)
        }
    }


    @RequestMapping(value = "/7/{Name}", method = RequestMethod.GET)
    ResponseEntity<String> seven(
            @PathVariable(value = "Name") String name) {

        def nameJson = new HashMap()
        LocalDateTime dateTime = LocalDateTime.now()
        LocalDate today = LocalDate.now()
        nameJson.put("name", name as String)
        nameJson.put("date", today.toString() as String)
        nameJson.put("time", dateTime.toLocalTime().toString() as String)

        def cha
        if (!Strings.isNullOrEmpty(name)) {
            cha = name.charAt(0)
        }
        //check if the static array of chars contains the first char of name then return json
        if (arr.contains(cha.toString())) {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            return new ResponseEntity<String>(nameJson.toString(), headers, HttpStatus.OK,)

        } else {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE)
            return new ResponseEntity<String>(nameXml(name, today, dateTime),headers, HttpStatus.OK)
        }
    }


    @RequestMapping(value = "/8/{Name}", method = RequestMethod.GET)
    ResponseEntity<Object> eight(
            @PathVariable(value = "Name") String name) {

        def nameJson = new HashMap()
        LocalDateTime dateTime = LocalDateTime.now()
        LocalDate today = LocalDate.now()
        nameJson.put("name", name as String)
        nameJson.put("date", today.toString() as String)
        nameJson.put("time", dateTime.toLocalTime().toString() as String)

        def cha
        if (!Strings.isNullOrEmpty(name)) {
            cha = name.charAt(0)
        }
        //check if the static array of chars contains the first char of name then return json
        if (arr.contains(cha.toString())) {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            return new ResponseEntity<Object>(nameJson.toString(), headers, HttpStatus.OK,)

        } else {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE)
            return new ResponseEntity<Object>(nameXml(name, today, dateTime),headers, HttpStatus.OK)
        }
    }


    @RequestMapping(value = "/9/{Name}", method = RequestMethod.GET)
    ResponseEntity<String> nine(
            @PathVariable(value = "Name") String name) {

        def nameJson = new HashMap()
        LocalDateTime dateTime = LocalDateTime.now()
        LocalDate today = LocalDate.now()
        nameJson.put("name", name as String)
        nameJson.put("date", today.toString() as String)
        nameJson.put("time", dateTime.toLocalTime().toString() as String)

        def cha
        if (!Strings.isNullOrEmpty(name)) {
            cha = name.charAt(0)
        }
        //check if the static array of chars contains the first char of name then return json
        if (arr.contains(cha.toString())) {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            return new ResponseEntity<String>(nameJson.toString(), headers, HttpStatus.OK,)

        } else {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE)
            return new ResponseEntity<String>(nameXml(name, today, dateTime),headers, HttpStatus.OK)
        }
    }


    @RequestMapping(value = "/10/{Name}", method = RequestMethod.GET)
    ResponseEntity<String> ten(
            @PathVariable(value = "Name") String name) {

        def nameJson = new HashMap()
        LocalDateTime dateTime = LocalDateTime.now()
        LocalDate today = LocalDate.now()
        nameJson.put("name", name as String)
        nameJson.put("date", today.toString() as String)
        nameJson.put("time", dateTime.toLocalTime().toString() as String)

        def cha
        if (!Strings.isNullOrEmpty(name)) {
            cha = name.charAt(0)
        }
        //check if the static array of chars contains the first char of name then return json
        if (arr.contains(cha.toString())) {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            return new ResponseEntity<String>(nameJson.toString(), headers, HttpStatus.OK,)

        } else {
            HttpHeaders headers = new HttpHeaders()
            headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE)
            return new ResponseEntity<String>(nameXml(name, today, dateTime),headers, HttpStatus.OK)
        }
    }
    static String nameXml(def name, LocalDate today, LocalDateTime dateTime) {

        def xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<details>\n" +
                "  <name>$name</name>\n" +
                "  <date>${today.toString()}</date>\n" +
                "  <time>${dateTime.toLocalTime().toString()}</time>\n" +
                "</details>"
        xml
    }

}
