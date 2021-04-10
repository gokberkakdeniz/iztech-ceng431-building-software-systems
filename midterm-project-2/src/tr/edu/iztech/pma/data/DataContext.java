package tr.edu.iztech.pma.data;

import tr.edu.iztech.pma.people.*;
import tr.edu.iztech.pma.product.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataContext implements IDataContext {
    private final List<IPerson> people;
    private final List<Product> products;

    public DataContext() {
        this.people = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    @Override
    public IPerson getPerson(String username, String password) {
        return new Admin(username, password);
//        return people.stream().filter(u -> u.getUsername().equals(username) && u.login(password)).findFirst().orElse(null);
    }

    @Override
    public List<IPerson> getPeople() {
        return new ArrayList<>(people);
    }

    @Override
    public List<Admin> getAdmins() {
        return people.stream().filter(u -> u instanceof Admin).map(u -> (Admin) u).collect(Collectors.toList());
    }

    @Override
    public List<Manager> getManagers() {
        return people.stream().filter(u -> u instanceof Manager).map(u -> (Manager) u).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployees() {
        return people.stream().filter(u -> u instanceof Employee).map(u -> (Employee) u).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployees(Manager manager) {
        Product product = (Product) getProductOf(manager);

        return null;
    }

    @Override
    public Product getProductOf(Manager personnel) {
        return products.stream().filter(p -> p.getId() == personnel.getProductId()).findFirst().orElse(null);
    }

    @Override
    public List<Product> getProducts() {
        return people.stream().filter(u -> u instanceof Product).map(u -> (Product) u).collect(Collectors.toList());
    }

    public Product createProductWithManager(String username, String password, String productTitle) {
        int id = people.size() + 1;

        Product product = new Product(id, productTitle);
        Manager manager = new Manager(username, password, product.getId());

        people.add(manager);
        products.add(product);

        return product;
    }

    @Override
    public Part createPartWithEmployee(AbstractProductWithChildren root, String username, String password, String productTitle) {
        int id = people.size() + 1;

        Part part = new Part(id, productTitle);
        Employee employee = new Employee(username, password, part.getId());

        root.add(part);
        people.add(employee);

        return part;
    }

    @Override
    public Assembly createAssemblyWithEmployee(AbstractProductWithChildren root, String username, String password, String productTitle) {
        int id = people.size() + 1;

        Assembly assembly = new Assembly(id, productTitle);
        Employee employee = new Employee(username, password, assembly.getId());

        root.add(assembly);
        people.add(employee);

        return assembly;
    }
}
