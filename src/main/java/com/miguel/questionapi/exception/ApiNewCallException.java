package com.miguel.questionapi.exception;

import java.io.IOException;

public class ApiNewCallException extends IOException {
    public ApiNewCallException(String exception) {
        super(exception);
    }
}
