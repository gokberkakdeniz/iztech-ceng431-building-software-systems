package tr.edu.iztech.pma;

import tr.edu.iztech.pma.data.DataContext;
import tr.edu.iztech.pma.data.DataLoader;
import tr.edu.iztech.pma.data.DataSaver;
import tr.edu.iztech.pma.people.Employee;
import tr.edu.iztech.pma.people.Manager;
import tr.edu.iztech.pma.product.AbstractProductWithChildren;
import tr.edu.iztech.pma.product.Assembly;
import tr.edu.iztech.pma.product.Part;
import tr.edu.iztech.pma.product.Product;
import tr.edu.iztech.pma.utils.TreeTraverser;
import tr.edu.iztech.pma.view.MainView;
import tr.edu.iztech.pma.view.Session;


public class Main {
    public static void main(String[] args) {
        DataContext context = new DataContext(new DataLoader(), new DataSaver());
        Session.setContext(context);
        MainView view = new MainView();
        view.show();
        view.kill();
        context.save();
//        serde_test();
    }

    private static void serde_test() {
        DataContext context = new DataContext(new DataLoader(), new DataSaver());
        TreeTraverser.traverse(context.getManagers().get(0).getProduct());
//        Manager managerA = context.createManagerWithProduct("managerA", "123456", "car");
//        Employee employeeA = context.createEmployeeWithAssembly((AbstractProductWithChildren) managerA.getProduct(), "employeeA", "123456", "assemblyA");
//        Employee employeeB = context.createEmployeeWithAssembly((AbstractProductWithChildren) managerA.getProduct(), "employeeB", "123456", "assemblyB");
//        Employee employeeAA = context.createEmployeeWithAssembly((AbstractProductWithChildren) employeeA.getProduct(), "employeeAA", "", "partAA");
//        Employee assemblyAA = context.createEmployeeWithAssembly((AbstractProductWithChildren) employeeA.getProduct(), "employeeAA", "", "assemblyAA");
//        Employee partAAA = context.createEmployeeWithPart((AbstractProductWithChildren) employeeAA.getProduct(), "employeeAAA", "", "partAAA");
//        Employee partAAB = context.createEmployeeWithPart((AbstractProductWithChildren) employeeAA.getProduct(), "employeeAAB", "", "partAAB");
//        context.getEmployees(context.getManagers().get(0)).forEach(System.out::println);
        context.save();
    }
}
