package edu.uoc.abarrena.users.domain.exceptions;

public class EntityNotFoundException extends RuntimeException {

        public EntityNotFoundException(String message) {
            super(message);
        }
}
