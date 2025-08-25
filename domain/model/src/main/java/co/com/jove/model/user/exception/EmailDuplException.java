package co.com.jove.model.user.exception;

public class EmailDuplException extends RuntimeException {
    public EmailDuplException(String emailDupl) {
        super("Email found duplicated : " + emailDupl);
    }
}
