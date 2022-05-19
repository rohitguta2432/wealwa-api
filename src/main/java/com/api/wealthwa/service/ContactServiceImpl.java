package com.api.wealthwa.service;

import com.api.wealthwa.model.Contacts;
import com.api.wealthwa.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author rohit
 * @Date 19/05/22
 **/
@Slf4j
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Map<String, String> create(Contacts contact) {
        log.info("create contacts [{}]", contact);
        Map<String, String> map = new HashMap<>();

        contactRepository.save(contact);
        map.put("msg", "contacts are created successfull");
        return map;
    }
}
