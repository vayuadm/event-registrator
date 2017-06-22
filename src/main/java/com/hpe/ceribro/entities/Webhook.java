package com.hpe.ceribro.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Webhook implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @NotBlank
    private String url;

    @NonNull
    @NotBlank
    private String domain;

    @NonNull
    @NotBlank
    private String project;

    @NonNull
    @NotBlank
    private String module;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_type")
    @NonNull
    private CategoryType categoryType;
}
