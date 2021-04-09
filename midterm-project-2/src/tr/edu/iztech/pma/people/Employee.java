package tr.edu.iztech.pma.people;

public class Employee extends AbstractPerson implements IPersonnel {
    private final int productId;

    public Employee(String username, String password, int productId) {
        super(username, password);
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }
}
