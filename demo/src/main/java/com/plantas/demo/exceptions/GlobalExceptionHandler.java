package com.plantas.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<String> tratarRecursoNaoEncontrado(RecursoNaoEncontradoException ex){
       return ResponseEntity
               .status(HttpStatus.NOT_FOUND)
               .body(ex.getMessage());

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> tratarValidacao(MethodArgumentNotValidException ex){
        //getBindingResult(): acessa o resultado da validação
        //getFieldErrors(): retorna uma lista com os erros dos campos
        //get(0): seleciona o primeiro erro da lista
        //getDefaultMessage(): recupera a mensagem definida na anotação
        String mensagem = ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(mensagem);
    }
}
