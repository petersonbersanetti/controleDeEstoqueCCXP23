package br.com.ccxp23.estoque.exception;

public class NoItemException extends RuntimeException{

    public NoItemException(String message){
        super(message);
    }
}
