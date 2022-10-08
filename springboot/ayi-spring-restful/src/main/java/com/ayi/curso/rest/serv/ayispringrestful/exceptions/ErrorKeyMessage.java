package com.ayi.curso.rest.serv.ayispringrestful.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ErrorKeyMessage {
    private String errorCode;
    private String description;

    public ErrorKeyMessage(String errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }
}
