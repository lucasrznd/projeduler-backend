package com.lucasrznd.projedulerbackend.exceptions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SecurityError {

    private Integer status;
    private String error;
    private String message;
    private String path;

}
