package com.practice.rest.webservices.restwebservices.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDetails {
    private LocalDateTime dateTime;
    private String message;
    private String details;

    public ErrorDetails(LocalDateTime dateTime, String message, String details) {
        super();
        this.dateTime = dateTime;
        this.message = message;
        this.details = details;
    }
}
