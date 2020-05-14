package br.com.vcampanholi.exception.handler.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorInfo {

    private String namespace;
    private String language;
    private List<ErrorDetail> errors;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<ErrorDetail> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDetail> errors) {
        this.errors = errors;
    }

    public static Builder create() {
        return new Builder();
    }

    public static class Builder {

        private String namespace;
        private String language;
        private List<ErrorDetail> errors;

        public Builder namespace(String namespace) {
            this.namespace = namespace;
            return this;
        }

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public Builder errors(List<ErrorDetail> errors) {
            this.errors = ObjectUtils.isEmpty(errors) ? new ArrayList<>() : errors;
            return this;
        }

        public ErrorInfo build() {
            ErrorInfo errorInfo = new ErrorInfo();
            errorInfo.namespace = namespace;
            errorInfo.language = language;
            errorInfo.errors = errors;
            return errorInfo;
        }
    }
}