package edu.uoc.abarrena.users.domain.exceptions;

public class IncorrectCredentialsException extends AbstractBusinessLogicException {

    public IncorrectCredentialsException() {
        super("The username or password is incorrect");
    }
}
