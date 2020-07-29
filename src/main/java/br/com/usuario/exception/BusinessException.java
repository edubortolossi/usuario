package br.com.usuario.exception;

public class BusinessException extends Exception {

    private String messageKey;

    public BusinessException( String message, String messageKey ) {
        super(message);
        this.messageKey = messageKey;
    }
}
