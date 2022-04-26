package com.doubletex.app.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Alexandru Enache
 * @date 26.04.2022
 */

@NoArgsConstructor
@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
@Setter
@JsonIgnoreProperties({"suppressed", "cause", "stackTrace", "localizedMessage", "message"})
public class DoubletexBadRequest extends RuntimeException {
    private int httpCode = HttpStatus.BAD_REQUEST.value();
    private Map<String, Set<String>> fields = new HashMap<>();
    private LocalDateTime time = LocalDateTime.now();

    private static ThreadLocal<DoubletexBadRequest> local = ThreadLocal.withInitial(DoubletexBadRequest::new);

    public void addValidation(String fieldName, String validationMessage) {
        Set<String> validations;
        if (!fields.containsKey(fieldName)) {
            validations = new TreeSet<>();
        } else {
            validations = fields.get(fieldName);
        }
        validations.add(validationMessage);
        fields.put(fieldName, validations);
    }

    public void throwIfNecessary() throws DoubletexBadRequest {
        if (fields.isEmpty())
            return;
        throw this;
    }

    public static DoubletexBadRequest current() {
        return local.get();
    }

}
