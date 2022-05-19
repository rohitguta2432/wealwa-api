package com.api.wealthwa.controller;

import com.api.wealthwa.model.Contacts;
import com.api.wealthwa.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author rohit
 * @Date 19/05/22
 **/
@RequestMapping("contact")
@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Contacts contact) {
        return new ResponseEntity<>(contactService.create(contact),HttpStatus.OK);
    }

}
