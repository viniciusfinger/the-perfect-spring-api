package com.viniciusfinger.perfect.enums;

import lombok.Getter;

@Getter
public enum Priority {

    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High"),
    HIGHEST("Highest");

    private final String description;

    Priority(String description) {
        this.description = description;
    }
}
