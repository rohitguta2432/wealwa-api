package com.api.wealthwa.repository;

import com.api.wealthwa.model.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Author rohit
 * @Date 19/05/22
 **/

@Repository
public interface ContactRepository extends JpaRepository<Contacts, UUID> {

}
