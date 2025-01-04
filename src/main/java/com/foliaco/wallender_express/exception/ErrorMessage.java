package com.foliaco.wallender_express.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
public class ErrorMessage {

    private String message;
    private int statusCode;
    private LocalDateTime dateTime;

}
