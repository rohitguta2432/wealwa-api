package com.api.wealthwa.repository;

import com.api.wealthwa.model.Contents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContentRepository extends JpaRepository<Contents, UUID> {
}
