package net.javaguides.springboot_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L; //Used for version control during Java object serialization.
    public ResourceNotFoundException(String Message){
        super(Message);
    }
}
