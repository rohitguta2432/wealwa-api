package com.api.wealthwa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 12/05/22
 **/

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    private String firstName;

    private String lastName;

    private String email;

    private String userName;

    private String mobile;

    private String password;

    private String authority;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date updatedAt;

}
