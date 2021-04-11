package tr.edu.iztech.pma.data;

public class LoadFailedException extends RuntimeException {
    public LoadFailedException(String message) {
        super(message);
    }
}
