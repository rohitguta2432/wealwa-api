package com.api.wealthwa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "contents")
public class Contents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID contentId;

    @NotNull(message = "categoryId cannot be null")
    private UUID categoryId;

    @NotNull(message = "images cannot be null ")
    private String imgUrl;

    @NotNull(message = "contents cannot be null ")
    private String description;

    @Transient
    private String categoryName;



}
