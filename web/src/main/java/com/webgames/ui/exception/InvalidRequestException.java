package com.webgames.ui.exception;

public class InvalidRequestException extends RestException
{
    public InvalidRequestException()
    {
    }

    public InvalidRequestException(String message)
    {
        super(message);
    }

    public InvalidRequestException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
