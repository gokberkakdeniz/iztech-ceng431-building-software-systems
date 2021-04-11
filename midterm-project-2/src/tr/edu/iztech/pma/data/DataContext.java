package tr.edu.iztech.pma.data;

import tr.edu.iztech.pma.people.Admin;
import tr.edu.iztech.pma.people.Employee;
import tr.edu.iztech.pma.people.IPerson;
import tr.edu.iztech.pma.people.Manager;
import tr.edu.iztech.pma.product.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class DataContext implements IDataContext {
    private final List<IPerson> people;
    private final IDataSaver saver;

    public DataContext(IDataLoader loader, IDataSaver saver) {
        this.people = new ArrayList<>();
        this.saver = saver;

        this.people.addAll(loader.load());
    }

    @Override
    public void save() {
        saver.save(people);
    }

    @Override
    public IPerson getPerson(String username, String password) {
        return new Admin(username, password);
//        return people.stream().filter(u -> u.getUsername().equals(username) && u.login(password)).findFirst().orElse(null);
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
        Product product = (Product) manager.getProduct();

        List<IProduct> flatProducts = new LinkedList<>();
        Queue<IProduct> queue = new LinkedList<>();
        queue.add(product);

        while (!queue.isEmpty()) {
            IProduct current = queue.poll();

            if (current instanceof AbstractProductWithChildren) {
                flatProducts.addAll(((AbstractProductWithChildren) current).getChildren());
                queue.addAll(((AbstractProductWithChildren) current).getChildren());
            } else {
                flatProducts.add(current);
            }
        }

        return people.stream()
            .filter(p -> p instanceof Employee && flatProducts.contains(((Employee) p).getProduct()))
            .map(p -> (Employee) p)
            .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProducts() {
        return people.stream()
            .filter(p -> p instanceof Manager)
            .map(p -> (Product)((Manager) p).getProduct())
            .collect(Collectors.toList());
    }

    public Manager createManagerWithProduct(String username, String password, String productTitle) {
        int id = people.size() + 1;

        Product product = new Product(id, productTitle);
        Manager manager = new Manager(username, password, product);

        people.add(manager);

        return manager;
    }

    @Override
    public Employee createEmployeeWithPart(AbstractProductWithChildren root, String username, String password, String productTitle) {
        int id = people.size() + 1;

        Part part = new Part(id, productTitle);
        Employee employee = new Employee(username, password, part);

        root.add(part);
        people.add(employee);

        return employee;
    }

    @Override
    public Employee createEmployeeWithAssembly(AbstractProductWithChildren root, String username, String password, String productTitle) {
        int id = people.size() + 1;

        Assembly assembly = new Assembly(id, productTitle);
        Employee employee = new Employee(username, password, assembly);

        root.add(assembly);
        people.add(employee);

        return employee;
    }
}
