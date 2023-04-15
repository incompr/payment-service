package payment.service.skf.utils;

public class ResponseEntity {
    private final int result;
    private final String message;

    public ResponseEntity(int result, String message) {
        this.result = result;
        this.message = message;
    }

    public int getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
