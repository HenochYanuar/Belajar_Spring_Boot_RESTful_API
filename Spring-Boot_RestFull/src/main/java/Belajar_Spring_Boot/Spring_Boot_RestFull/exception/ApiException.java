package Belajar_Spring_Boot.Spring_Boot_RestFull.exception;

public class ApiException extends RuntimeException{

    public ApiException(String message) {
        super(message);
    }

}
