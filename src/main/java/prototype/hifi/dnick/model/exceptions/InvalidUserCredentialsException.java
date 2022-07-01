package prototype.hifi.dnick.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException {

    public InvalidUserCredentialsException() {
        super("Невалидна комбинација на корисничко име и лозинка");
    }
}
