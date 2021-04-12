package tr.edu.iztech.pma.data.json;

/**
 * A repository to solve reference problems in serialization
 *
 * @param <T> id type
 * @param <K> element type
 */
public interface ISerializationRepository<T, K> {
    /**
     * Adds new element to repository
     *
     * @param product element to be added
     */
    void add(K product);

    /**
     * Gets element by id
     *
     * @param id element id
     * @return found element
     */
    K get(T id);
}
