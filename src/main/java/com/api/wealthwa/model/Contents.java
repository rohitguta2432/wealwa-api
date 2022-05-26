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

    private String imgUrl;

    @NotNull(message = "contents cannot be null ")
    @Column(name = "description", length = 5000)
    private String description;

    @Transient
    private String categoryName;


    public Contents(@NotNull(message = "categoryId cannot be null") UUID categoryId, @NotNull(message = "contents cannot be null ") String description) {
        this.categoryId = categoryId;
        this.description = description;
    }
}
