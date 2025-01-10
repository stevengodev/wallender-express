package com.foliaco.wallender_express.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler( value = { NotFoundException.class } )
    public ResponseEntity<ErrorMessage> handleNotFoundException(RuntimeException e) {

        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .dateTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = { FileOperationException.class } )
    public ResponseEntity<ErrorMessage> handleNoFileSelectedException(RuntimeException e){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .dateTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<ErrorMessage> handleJsonProcessingException(JsonProcessingException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message("An error occurred while processing the JSON data")
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .dateTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
