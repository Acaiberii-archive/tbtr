package me.acaiberii.tbtr.exception;

public class NetNotReachableException extends Exception {
    public NetNotReachableException(String errorMessage, Throwable errorThrowable) {
        super(errorMessage, errorThrowable);
    }

    public NetNotReachableException(String errorMessage) {
        super(errorMessage);
    }
}
