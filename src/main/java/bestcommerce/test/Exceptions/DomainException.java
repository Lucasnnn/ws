package bestcommerce.test.Exceptions;

public class DomainException extends RuntimeException {
    public DomainException() {
        super("Not valid domain !");
    }
}
