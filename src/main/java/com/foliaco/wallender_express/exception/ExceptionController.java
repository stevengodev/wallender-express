package com.foliaco.wallender_express.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler( value = { NotFoundException.class } )
    public ResponseEntity<ErrorMessage> handleNotFoundException(RuntimeException e,
                                                 WebRequest request) {

        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .dateTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);

    }

}
