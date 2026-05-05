package com.cosmos.fleet.controller;

import com.cosmos.fleet.exception.CombustivelInsuficienteException;
import com.cosmos.fleet.exception.CombustivelInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // intercepta exceções de todos os controllers
public class GlobalExceptionHandler {

    // captura erro de combustível inválido → retorna 400 Bad Request
    @ExceptionHandler(CombustivelInvalidoException.class)
    public ResponseEntity<String> handleCombustivelInvalido(CombustivelInvalidoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    // captura erro de combustível insuficiente → retorna 400 Bad Request
    @ExceptionHandler(CombustivelInsuficienteException.class)
    public ResponseEntity<String> handleCombustivelInsuficiente(CombustivelInsuficienteException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    // captura nave não encontrada → retorna 404 Not Found
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}