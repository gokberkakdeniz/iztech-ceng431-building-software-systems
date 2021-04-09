package tr.edu.iztech.pma.people;

import tr.edu.iztech.pma.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Admin extends AbstractPerson {
    private final List<Manager> managers;

    public Admin(String username, String password) {
        super(username, password);
        this.managers = new ArrayList<>();
    }

    public Manager createManagerWithProduct(String username, String password, String productTitle) {
        int id = managers.size() + 1;
        Product product = new Product(id, productTitle);
        Manager manager = new Manager(username, password, product.getId());
        managers.add(manager);
        return manager;
    }

}
