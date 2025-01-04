package com.foliaco.wallender_express.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class ErrorMessage {

    private String message;
    private int statusCode;
    private LocalDateTime dateTime;

}
