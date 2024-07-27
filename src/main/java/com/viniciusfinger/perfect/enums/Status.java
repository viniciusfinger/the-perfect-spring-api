package com.viniciusfinger.perfect.enums;

import lombok.Getter;

@Getter
public enum Status {
    TO_DO("To Do"),
    IN_PROGRESS("In Progress"),
    REVIEWING("Reviewing"),
    DONE("Done");

    private final String description;

    Status(String description) {
        this.description = description;
    }
}
