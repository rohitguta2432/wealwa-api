package com.api.wealthwa.service;

import com.api.wealthwa.model.Contacts;

import java.util.Map;

/**
 * @Author rohit
 * @Date 19/05/22
 **/
public interface ContactService {

    Map<String, String> create(Contacts contact);

}
