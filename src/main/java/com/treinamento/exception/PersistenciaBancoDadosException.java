package com.treinamento.exception;

public class PersistenciaBancoDadosException extends RuntimeException{
	
    private Integer code = 3;

    public PersistenciaBancoDadosException(String message) {
        super(message);
    }

    public Integer getCode() {
        return code;
    }

}
