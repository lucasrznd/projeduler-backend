package com.lucasrznd.projedulerbackend.exceptions.handler;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.lucasrznd.projedulerbackend.exceptions.BusinessRuleException;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.exceptions.StandardError;
import com.lucasrznd.projedulerbackend.exceptions.ValidationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> handleNotFoundException(final ResourceNotFoundException ex, final HttpServletRequest request) {
        return ResponseEntity.status(NOT_FOUND).body(
                StandardError.builder()
                        .timestamp(LocalDateTime.now()).status(NOT_FOUND.value())
                        .error(NOT_FOUND.getReasonPhrase()).message(ex.getMessage())
                        .path(request.getRequestURI()).build()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationException> handleArgumentNotValidException(final MethodArgumentNotValidException ex, final HttpServletRequest request) {
        var error = ValidationException.builder()
                .timestamp(LocalDateTime.now())
                .status(BAD_REQUEST.value())
                .error(BAD_REQUEST.getReasonPhrase())
                .message("Erro na validacão de atributos")
                .errors(new ArrayList<>())
                .path(request.getRequestURI()).build();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            error.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> handleDataIntegrityViolationException(final DataIntegrityViolationException ex, final HttpServletRequest request) {
        return ResponseEntity.status(CONFLICT).body(
                StandardError.builder()
                        .timestamp(LocalDateTime.now()).status(CONFLICT.value())
                        .error(CONFLICT.getReasonPhrase()).message(ex.getMessage())
                        .path(request.getRequestURI()).build()
        );
    }

    @ExceptionHandler({BadCredentialsException.class})
    public ResponseEntity<StandardError> handleBadCredentialsException(final RuntimeException ex, final HttpServletRequest request) {
        return ResponseEntity.status(UNAUTHORIZED).body(
                StandardError.builder()
                        .timestamp(LocalDateTime.now())
                        .status(UNAUTHORIZED.value())
                        .error(UNAUTHORIZED.getReasonPhrase())
                        .message(ex.getMessage())
                        .path(request.getRequestURI()).build()
        );
    }

    @ExceptionHandler({UsernameNotFoundException.class})
    public ResponseEntity<StandardError> handleUsernameNotFoundException(final UsernameNotFoundException ex, final HttpServletRequest request) {
        return ResponseEntity.status(UNAUTHORIZED).body(
                StandardError.builder()
                        .timestamp(LocalDateTime.now())
                        .status(UNAUTHORIZED.value())
                        .error(UNAUTHORIZED.getReasonPhrase())
                        .message(ex.getMessage())
                        .path(request.getRequestURI()).build()
        );
    }

    @ExceptionHandler({JWTVerificationException.class})
    public ResponseEntity<StandardError> handleJWTVerificationException(final JWTVerificationException ex, final HttpServletRequest request) {
        return ResponseEntity.status(UNAUTHORIZED).body(
                StandardError.builder()
                        .timestamp(LocalDateTime.now())
                        .status(UNAUTHORIZED.value())
                        .error(UNAUTHORIZED.getReasonPhrase())
                        .message(ex.getMessage())
                        .path(request.getRequestURI()).build()
        );
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<StandardError> handleBusinessRuleException(final BusinessRuleException ex, final HttpServletRequest request) {
        return ResponseEntity.status(CONFLICT).body(
                StandardError.builder()
                        .timestamp(LocalDateTime.now()).status(CONFLICT.value())
                        .error(CONFLICT.getReasonPhrase()).message(ex.getMessage())
                        .path(request.getRequestURI()).build()
        );
    }
}
