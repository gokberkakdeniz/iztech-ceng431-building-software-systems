package tr.edu.iztech.pma.data;

import tr.edu.iztech.pma.people.*;
import tr.edu.iztech.pma.product.IProduct;

import java.util.List;

public class DataContext implements IDataContext {
    @Override
    public IPerson getPerson(String username, String password) {
        return null;
    }

    @Override
    public List<IPerson> getPeople() {
        return null;
    }

    @Override
    public List<Admin> getAdmins() {
        return null;
    }

    @Override
    public List<Manager> getManagers() {
        return null;
    }

    @Override
    public List<Employee> getEmployees() {
        return null;
    }

    @Override
    public IProduct getProductOf(IPersonnel personnel) {
        return null;
    }
}
