package prototype.hifi.dnick.model.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(String username) {
        super(String.format("Корисничкото име: %s веќе постои", username));
    }
}