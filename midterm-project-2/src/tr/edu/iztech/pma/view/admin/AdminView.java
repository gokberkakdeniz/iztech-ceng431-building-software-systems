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
                    "Create Manager and Product", "See all managers", "See all employees", "See all products"
            });
            options.printOptions();
            int choice = keyboardReader.promptInteger("Please enter a number between 0-4", options.getPredicate());
            try {
                switch (choice) {
                    case 0:
                        return false;
                    case 1:
                        createManagerWithProduct();
                        break;
                    case 2:
                        seeManagers();
                        break;
                    case 3:
                        if (seeEmployees())
                            return true;
                        break;
                    case 4:
                        if (seeProducts())
                            return true;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean createManagerWithProduct() {
        String username = keyboardReader.promptString("Enter username");
        String password = keyboardReader.promptString("Enter password");
        String productTitle = keyboardReader.promptString("Enter product title");

        Product product = context.createProductWithManager(username, password, productTitle);
        System.out.printf("%s is added.\n\n", product);
        return true;
    }

    private boolean seeManagers() {
        List<Manager> managers = context.getManagers();
        System.out.println("[#] List of managers:");
        int i = 1;
        for (Manager manager : managers) {
            System.out.printf("[%d] %s\n", i, manager);
            i++;
        }
        int choice = keyboardReader.promptInteger("Enter a number to see its product, 0 to quit");
        if (choice == 0 || managers.size() < choice) {
            System.out.println("Wrong input provided.");
            return false;
        }

        Manager selectedManager = managers.get(choice - 1);
        IProduct product = context.getProductOf(selectedManager);
        System.out.println(product.getId());
        return true;
    }

    private boolean seeEmployees() {
        List<Employee> employees = context.getEmployees();
        System.out.println("[#] List of employees:");
        int i = 1;
        for (Employee employee: employees) {
            System.out.printf("[%d] %s\n", i, employee);
            i++;
        }
        int choice = keyboardReader.promptInteger("Enter a number to see its part or assembly, 0 to quit");
        if (choice == 0 || employees.size() < choice) {
            System.out.println("Wrong input provided.");
            return false;
        }

        Employee selectedEmployee = employees.get(choice - 1);
        IProduct product = context.getProductOf(selectedEmployee);
        System.out.println(product.getId());
        return true;
    }

    private boolean seeProducts() {
        List<Product> products = context.getProducts();
        System.out.println("[#] List of products:");
        int i = 1;
        for (Product product: products) {
            System.out.printf("[%d] %s\n", i, product);
            i++;
        }
        int choice = keyboardReader.promptInteger("Enter a number to see its product tree, 0 to quit");
        if (choice == 0 || products.size() < choice) {
            System.out.println("Wrong input provided.");
            return false;
        }

        Product selectedProduct = products.get(choice - 1);
        TreeTraverser.traverse(selectedProduct);
        return true;
    }
}
