package com.api.wealthwa.repository;

import com.api.wealthwa.model.Categorys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Categorys, UUID> {

}

