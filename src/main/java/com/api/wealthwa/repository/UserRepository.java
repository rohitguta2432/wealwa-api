package com.api.wealthwa.repository;

import com.api.wealthwa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Author rohit
 * @Date 16/05/22
 **/
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUserName(String userName);

}
