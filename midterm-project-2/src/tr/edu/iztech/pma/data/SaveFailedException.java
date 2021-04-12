package tr.edu.iztech.pma.data;

/**
 * A customized exception for DataSaver
 */
public class SaveFailedException extends RuntimeException {
    public SaveFailedException(Throwable cause) {
        super(cause);
    }
}
