package bestcommerce.test.Exceptions;

public class OwnerException extends RuntimeException {
    public OwnerException() {
        super("You cannot edit this data !");
    }
}
