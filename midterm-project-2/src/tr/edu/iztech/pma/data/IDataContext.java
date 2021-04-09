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

    IProduct getProductOf(IPersonnel personnel);
    Manager createManagerWithProduct(String username, String password, String productTitle);
}
