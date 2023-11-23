package br.com.ccxp23.estoque.exception;

public class InvalidOperationException extends RuntimeException{

    public InvalidOperationException (String message){
        super(message);
    }
}
