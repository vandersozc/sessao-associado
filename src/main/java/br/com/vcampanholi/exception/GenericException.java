package br.com.vcampanholi.exception;

import br.com.vcampanholi.exception.handler.response.ErrorInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = false)
public class GenericException extends RuntimeException {

    private ErrorInfo errorInfo;
    private String message;
    private HttpStatus status;

    public GenericException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}