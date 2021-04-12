package tr.edu.iztech.pma.data;

/**
 * A customized exception for DataLoader
 */
public class LoadFailedException extends RuntimeException {
    public LoadFailedException(Throwable cause) {
        super(cause);
    }
}
