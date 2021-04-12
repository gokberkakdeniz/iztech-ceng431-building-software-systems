package tr.edu.iztech.pma.data;

import tr.edu.iztech.pma.people.Employee;
import tr.edu.iztech.pma.people.IPerson;
import tr.edu.iztech.pma.people.Manager;
import tr.edu.iztech.pma.product.AbstractProductWithChildren;
import tr.edu.iztech.pma.product.Product;

import java.util.List;

public interface IDataContext {
    /**
     * Persists data
     */
    void save();

    /**
     * Get user by username and password
     * @param username username of user
     * @param password password of user
     * @return found user
     */
    IPerson getPerson(String username, String password);

    /**
     * Finds all managers
     *
     * @return managers
     */
    List<Manager> getManagers();

    /**
     * Finds all employees
     *
     * @return employees
     */
    List<Employee> getEmployees();

    /**
     * Finds all employees of given manager
     *
     * @return managers
     */
    List<Employee> getEmployees(Manager manager);

    /**
     * Finds all products
     *
     * @return products
     */
    List<Product> getProducts();

    /**
     * Creates new manager and its product
     *
     * @param username username of new manager
     * @param password password of new manager
     * @param productTitle title of new product
     *
     * @return created manager
     */
    Manager createManagerWithProduct(String username, String password, String productTitle);

    /**
     * Creates new employee and its part
     *
     * @param username username of new employee
     * @param password password of new employee
     * @param productTitle title of new part
     *
     * @return created employee
     */
    Employee createEmployeeWithPart(AbstractProductWithChildren root, String username, String password, String productTitle);

    /**
     * Creates new employee and its assembly
     *
     * @param username username of new employee
     * @param password password of new employee
     * @param productTitle title of new assembly
     *
     * @return created employee
     */
    Employee createEmployeeWithAssembly(AbstractProductWithChildren root, String username, String password, String productTitle);
}