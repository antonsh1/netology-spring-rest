package ru.smartjava.rest.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.smartjava.rest.exceptions.InvalidCredentials;
import ru.smartjava.rest.exceptions.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlersAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> InvalidCredentialsHandler(InvalidCredentials ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> UnauthorizedUserHandler(UnauthorizedUser ex) {
        System.out.println(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}
