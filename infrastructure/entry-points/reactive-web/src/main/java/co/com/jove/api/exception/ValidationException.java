package co.com.jove.api.exception;

public class ValidationException extends RuntimeException{

    /*private final ValidationErrorResponse errors;

    public ValidationException(Map<String, List<String>> fieldErrors) {
        super("Validation failed");
        this.errors = new ValidationErrorResponse(
                List.of(fieldErrors)
        );
    }

    public ValidationErrorResponse getErrors() {
        return errors;
    }*/
}
