package tr.edu.iztech.pma.data.json;

public interface ISerializationRepository<T, K> {
    void add(K product);
    K get(T id);
}
