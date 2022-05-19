package com.api.wealthwa.repository;

import com.api.wealthwa.model.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Author rohit
 * @Date 17/05/22
 **/
@Repository
public interface AuthTokenRepository extends JpaRepository<AuthToken, UUID> {

    AuthToken findByUserId(UUID userId);

}
