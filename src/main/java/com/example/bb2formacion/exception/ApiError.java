package com.example.bb2formacion.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {
    private String errorCode;
    private String cause;
    private LocalDateTime timestamp;
    private List<String> details;


}
