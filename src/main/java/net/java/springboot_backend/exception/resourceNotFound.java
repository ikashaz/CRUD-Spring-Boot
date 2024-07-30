package net.java.springboot_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class resourceNotFound extends RuntimeException {

    public resourceNotFound(String message) {
        super(message);
    }
}