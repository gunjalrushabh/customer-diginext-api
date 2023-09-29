package com.alphware.customExceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ReportGenerationException.class)
    public ResponseEntity<Object> ReportGenerationExceptionHandler(ReportGenerationException exception) {
        Map<String, Object> error = new HashMap<>();
        error.put("error", exception.getMessage());
        error.put("message", "Report not generated");
        error.put("status", HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.ok(error);
    }
}
