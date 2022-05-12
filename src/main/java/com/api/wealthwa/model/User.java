package com.api.wealthwa.model;

import lombok.Builder;

import javax.persistence.*;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 12/05/22
 **/
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    private String firstName;

    private String lastName;


}
