package com.treinamento.exception;

public class OpcaoInvalidaException extends RuntimeException{
	
    private Integer code = 4;

    public OpcaoInvalidaException(String message) {
        super(message);
    }

    public Integer getCode() {
        return code;
    }

}
