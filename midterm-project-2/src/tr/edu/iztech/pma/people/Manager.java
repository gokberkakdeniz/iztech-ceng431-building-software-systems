package tr.edu.iztech.pma.people;

import tr.edu.iztech.pma.product.IProduct;
import tr.edu.iztech.pma.product.Product;

public class Manager extends AbstractPerson implements IPersonnel {
    private final IProduct product;

    public Manager(String username, String password, Product product) {
        super(username, password);
        this.product = product;
    }

    public IProduct getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return super.getUsername() + ", " + product.getId();
    }
}
