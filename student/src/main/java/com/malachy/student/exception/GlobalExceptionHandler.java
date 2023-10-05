package com.malachy.student.exception;

import com.malachy.student.dto.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
@RequiredArgsConstructor
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    private ErrorResponse buildErrorResponse(Object error){
        return ErrorResponse.builder()
                .httpStatusCode(HttpStatus.NOT_FOUND.value())
                .message(Collections.singletonList(error))
            //    .responseDate(LocalDateTime.now(Clock.systemUTC()))
                .build();
    }

    @ExceptionHandler(value = {SchoolNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse UserNotFoundException(SchoolNotFoundException ex) {
        return buildErrorResponse(ex.getMessage());
    }
}
