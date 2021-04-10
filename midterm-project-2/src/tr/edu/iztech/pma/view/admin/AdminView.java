package tr.edu.iztech.pma.view.admin;

import tr.edu.iztech.pma.data.IDataContext;
import tr.edu.iztech.pma.io.KeyboardReader;
import tr.edu.iztech.pma.people.*;
import tr.edu.iztech.pma.product.*;
import tr.edu.iztech.pma.utils.TreeTraverser;
import tr.edu.iztech.pma.view.Session;
import tr.edu.iztech.pma.view.View;

import java.util.List;

public class AdminView extends View {
    private IDataContext context;

    public AdminView() {
        this.context = Session.getContext();
    }

    @Override
    public boolean show() {
        while (true) {
            KeyboardReader.Options options = new KeyboardReader.Options("What would you like to do?", new String[]{
                    "Create Product and Manager", "See all managers", "See all employees", "See all products"
            });
            options.printOptions();
            int choice = keyboardReader.promptInteger("Please enter a number between 0-4", options.getPredicate());
            try {
                switch (choice) {
                    case 0:
                        return false;
                    case 1:
                        createProductWithManager();
                        break;
                    case 2:
                        seeManagers();
                        break;
                    case 3:
                        seeEmployees();
                        break;
                    case 4:
                        seeProducts();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean createProductWithManager() {
        String username = keyboardReader.promptString("Enter username");
        String password = keyboardReader.promptString("Enter password");
        String productTitle = keyboardReader.promptString("Enter product title");

        Manager manager = context.createManagerWithProduct(username, password, productTitle);
        System.out.printf("%s is added.\n\n", manager.getProduct());
        return true;
    }

    private boolean seeManagers() {
        List<Manager> managers = context.getManagers();

        KeyboardReader.Options options = new KeyboardReader.Options("List of managers", managers.toArray());
        options.printOptions();

        int choice = keyboardReader.promptInteger(String.format("Please enter a number between 0-%s to see its " +
                "product, 0 to quit", managers.size()), options.getPredicate());
        if (choice == 0) {
            return false;
        }

        Manager selectedManager = managers.get(choice - 1);
        TreeTraverser.traverse(selectedManager.getProduct());
        return true;
    }

    private boolean seeEmployees() {
        List<Employee> employees = context.getEmployees();

        KeyboardReader.Options options = new KeyboardReader.Options("List of employees", employees.toArray());
        options.printOptions();

        int choice = keyboardReader.promptInteger(String.format("Enter a number between 0-%s to see its part or" +
                " assembly, 0 to quit", employees.size()), options.getPredicate());
        if (choice == 0) {
            return false;
        }

        Employee selectedEmployee = employees.get(choice - 1);
        Product product = (Product) selectedEmployee.getProduct();
        System.out.println(product);
        return true;
    }

    private boolean seeProducts() {
        List<Product> products = context.getProducts();

        KeyboardReader.Options options = new KeyboardReader.Options("List of products", products.toArray());
        options.printOptions();

        int choice = keyboardReader.promptInteger(String.format("Enter a number between 0-%s to see its product tree," +
                " 0 to quit", products.size()), options.getPredicate());
        if (choice == 0) {
            return false;
        }

        Product selectedProduct = products.get(choice - 1);
        TreeTraverser.traverse(selectedProduct);
        return true;
    }
}
