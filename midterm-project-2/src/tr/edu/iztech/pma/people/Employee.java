package tr.edu.iztech.pma.people;

import tr.edu.iztech.pma.product.IProduct;

public class Employee extends AbstractPerson implements IPersonnel {
    private final IProduct product;

    public Employee(String username, String password, IProduct product) {
        super(username, password);
        this.product = product;
    }

    public IProduct getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return super.getUsername() + "," + product.getId();
    }
}
