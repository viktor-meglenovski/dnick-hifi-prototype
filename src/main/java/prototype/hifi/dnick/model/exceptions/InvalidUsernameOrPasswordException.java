package prototype.hifi.dnick.model.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException{
    public InvalidUsernameOrPasswordException() {
        super("Невалидни податоци за име и/или лозинка");
    }
}
