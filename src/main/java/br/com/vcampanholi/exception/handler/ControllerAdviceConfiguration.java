package br.com.vcampanholi.exception.handler;

import br.com.vcampanholi.exception.GenericException;
import br.com.vcampanholi.exception.constants.CommonErrorsEnum;
import br.com.vcampanholi.exception.handler.response.ErrorDetail;
import br.com.vcampanholi.exception.handler.response.ErrorInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Configuration
@RestControllerAdvice
public class ControllerAdviceConfiguration {

    private static final String DEFAULT_LANGUAGE_TAG = "pt-BR";

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorInfo> genericException(GenericException error, HttpServletRequest httpServletRequest) {
        log.error("ControllerAdviceConfiguration.genericException={}", error);
        var errorInfo = ErrorInfo.builder()
                .errors(List.of(ErrorDetail.builder()
                        .message(error.getMessage())
                        .type(error.getStatus().name())
                        .build())
                )
                .language(DEFAULT_LANGUAGE_TAG)
                .namespace(httpServletRequest.getServletPath())
                .build();
        return ResponseEntity.status(error.getStatus()).body(errorInfo);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorInfo httpMessageNotReadableException(HttpMessageNotReadableException error,
                                                     HttpServletRequest httpServletRequest) {
        log.error("ControllerAdviceConfiguration.httpMessageNotReadableException={}", error);
        return ErrorInfo.builder()
                .namespace(httpServletRequest.getServletPath())
                .language(DEFAULT_LANGUAGE_TAG)
                .errors(List.of(ErrorDetail.builder()
                        .type(CommonErrorsEnum.HTTP_MESSAGE_NOT_READABLE.name())
                        .message("O corpo da requisição não pôde ser lido")
                        .build())
                )
                .build();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorInfo methodArgumentNotValidException(MethodArgumentNotValidException e,
                                                     HttpServletRequest httpServletRequest) {
        log.error("ControllerAdviceConfiguration.methodArgumentNotValidException={}", e);
        List<ErrorDetail> errors = new ArrayList<>();
        var fieldErrors = e.getBindingResult().getFieldErrors();
        if (!ObjectUtils.isEmpty(fieldErrors)) {
            errors = fieldErrors.stream()
                    .map(this::buildFieldErrorInfo)
                    .collect(Collectors.toList());
        }
        return ErrorInfo.builder()
                .namespace(httpServletRequest.getServletPath())
                .language(DEFAULT_LANGUAGE_TAG)
                .errors(errors)
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInfo constraintViolationException(ConstraintViolationException error,
                                                  HttpServletRequest httpServletRequest) {
        log.error("ControllerAdviceConfiguration.constraintViolationException={}", error);
        var errors = error.getConstraintViolations().stream()
                .map(violation -> ErrorDetail.builder()
                        .message(violation.getMessage())
                        .type(CommonErrorsEnum.METHOD_ARGUMENT_NOT_VALID.name())
                        .build()).collect(Collectors.toList());
        return ErrorInfo.builder()
                .namespace(httpServletRequest.getServletPath())
                .language(DEFAULT_LANGUAGE_TAG)
                .errors(errors)
                .build();
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorInfo bindException(BindException error, HttpServletRequest httpServletRequest) {
        log.error("ControllerAdviceConfiguration.bindException={}", error);
        var errors = error.getAllErrors().stream()
                .map(violation -> ErrorDetail.builder()
                        .message(violation.getDefaultMessage())
                        .type(CommonErrorsEnum.METHOD_ARGUMENT_NOT_VALID.name())
                        .build())
                .collect(Collectors.toList());
        return ErrorInfo.builder()
                .namespace(httpServletRequest.getServletPath())
                .language(DEFAULT_LANGUAGE_TAG)
                .errors(errors)
                .build();
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInfo httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException error,
                                                            HttpServletRequest httpServletRequest) {
        log.error("ControllerAdviceConfiguration.httpRequestMethodNotSupportedException={}", error);
        return ErrorInfo.builder()
                .namespace(httpServletRequest.getServletPath())
                .language(DEFAULT_LANGUAGE_TAG)
                .errors(List.of(ErrorDetail.builder()
                        .type(CommonErrorsEnum.METHOD_ARGUMENT_NOT_VALID.name())
                        .message("Método http não é suportado para a requisição")
                        .build())
                )
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInfo exceptionHandler(Exception error, HttpServletRequest httpServletRequest) {
        log.error("ControllerAdviceConfiguration.exceptionHandler={}", error);
        return ErrorInfo.builder()
                .namespace(httpServletRequest.getServletPath())
                .language(DEFAULT_LANGUAGE_TAG)
                .errors(List.of(ErrorDetail.builder()
                        .type(CommonErrorsEnum.INTERNAL_SERVER_ERROR.name())
                        .message("Ocorreu um erro inesperado na aplicação")
                        .build())
                )
                .build();
    }

    private ErrorDetail buildFieldErrorInfo(FieldError error) {
        return ErrorDetail.builder()
                .type(CommonErrorsEnum.METHOD_ARGUMENT_NOT_VALID.name())
                .message(error.getDefaultMessage())
                .build();
    }
}