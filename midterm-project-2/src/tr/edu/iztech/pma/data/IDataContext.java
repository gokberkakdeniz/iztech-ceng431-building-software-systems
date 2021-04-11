package tr.edu.iztech.pma.data;

import tr.edu.iztech.pma.people.Admin;
import tr.edu.iztech.pma.people.Employee;
import tr.edu.iztech.pma.people.IPerson;
import tr.edu.iztech.pma.people.Manager;
import tr.edu.iztech.pma.product.AbstractProductWithChildren;
import tr.edu.iztech.pma.product.Product;

import java.util.List;

public interface IDataContext {
    void save();

    IPerson getPerson(String username, String password);

    List<Admin> getAdmins();
    List<Manager> getManagers();
    List<Employee> getEmployees();
    List<Employee> getEmployees(Manager manager);
    List<Product> getProducts();

    Manager createManagerWithProduct(String username, String password, String productTitle);
    Employee createEmployeeWithPart(AbstractProductWithChildren root, String username, String password, String productTitle);
    Employee createEmployeeWithAssembly(AbstractProductWithChildren root, String username, String password, String productTitle);
}