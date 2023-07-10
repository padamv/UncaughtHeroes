package com.npe.pet.uncaughtHeroes.controller.advice;

import com.npe.pet.uncaughtHeroes.exception.HeroNameDuplicateException;
import com.npe.pet.uncaughtHeroes.exception.HeroNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(value = {HeroNotFoundException.class})
    protected ResponseEntity<String> handleHeroNotFound(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {HeroNameDuplicateException.class})
    protected ResponseEntity<String> handleHeroNameDuplicate(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
