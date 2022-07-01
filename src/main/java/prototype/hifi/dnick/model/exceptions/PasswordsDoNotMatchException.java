package prototype.hifi.dnick.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException() {
        super("Лозинките не се совпаѓаат");
    }
}
