package pe.indigital.yape.transactionservice.infrastructure.errors;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
