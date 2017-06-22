package com.hpe.ceribro.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CategoryType {

    DEFAULT("default"),
    SLACK("slack"),
    TRELLO("trello");

    private String value;
}
