package edu.uoc.abarrena.users.domain.exceptions;

public class DuplicateUserException extends AbstractBusinessLogicException {

        public DuplicateUserException() {
            super("The user already exists");
        }
}
