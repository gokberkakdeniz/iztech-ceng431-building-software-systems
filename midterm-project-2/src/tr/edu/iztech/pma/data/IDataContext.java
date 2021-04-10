package tr.edu.iztech.pma.data;

import tr.edu.iztech.pma.people.*;
import tr.edu.iztech.pma.product.*;

import java.util.List;

public interface IDataContext {
    IPerson getPerson(String username, String password);

    List<IPerson> getPeople();
    List<Admin> getAdmins();
    List<Manager> getManagers();
    List<Employee> getEmployees();
    List<Employee> getEmployees(Manager manager);
    List<Product> getProducts();

    Product getProductOf(Manager personnel);

    Product createProductWithManager(String username, String password, String productTitle);
    Part createPartWithEmployee(AbstractProductWithChildren root, String username, String password, String productTitle);
    Assembly createAssemblyWithEmployee(AbstractProductWithChildren root, String username, String password, String productTitle);
}