package com.doubletex.app.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

/**
 * @author Alexandru Enache
 * @date 26.04.2022
 */

@AllArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
@JsonIgnoreProperties({"suppressed", "cause", "stackTrace", "localizedMessage"})
public class DoubletexNotFound extends RuntimeException {
    private Class<?> entityClass;
    private Long id;

    @Override
    public String getMessage() {
        return "An entity of type " + entityClass.getSimpleName() + " with id: " + id + " was not found";
    }

    public int getCode() {
        return 404;
    }

    public String getTime() {
        return LocalDateTime.now().toString();
    }
}
