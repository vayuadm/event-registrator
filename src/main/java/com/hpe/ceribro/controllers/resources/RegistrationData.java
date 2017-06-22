package com.hpe.ceribro.controllers.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hpe.ceribro.entities.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class RegistrationData {

    private String url;

    private CategoryType categoryType;
}
