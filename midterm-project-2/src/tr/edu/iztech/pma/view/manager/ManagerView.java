package tr.edu.iztech.pma.view.manager;

import tr.edu.iztech.pma.data.IDataContext;
import tr.edu.iztech.pma.io.KeyboardReader;
import tr.edu.iztech.pma.people.*;
import tr.edu.iztech.pma.product.*;
import tr.edu.iztech.pma.utils.TreeTraverser;
import tr.edu.iztech.pma.view.Session;
import tr.edu.iztech.pma.view.View;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ManagerView extends View {
    private IDataContext context;
    private Manager user;
    private TreeTraverser treeTraverser;

    public ManagerView() {
        this.context = Session.getContext();
        this.user = (Manager) Session.getUser();
    }

    @Override
    public boolean show() {
        while (true) {
            KeyboardReader.Options options = new KeyboardReader.Options("What would you like to do?", new String[]{
                    "Create part and employee", "Create assembly and employee", "See product tree", "See employees"
            });
            options.printOptions();
            int choice = keyboardReader.promptInteger("Please enter a number between 0-4", options.getPredicate());
            try {
                switch (choice) {
                    case 0:
                        return false;
                    case 1:
                        createEmployeeWithPart();
                        break;
                    case 2:
                        createEmployeeWithAssembly();
                        break;
                    case 3:
                        seeProductTree();
                        break;
                    case 4:
                        seeEmployees();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            context.save();
        }
    }

    private List<IProduct> filterProduct(List<IProduct> products, Predicate<IProduct> predicate) {
        return products.stream().filter(predicate).collect(Collectors.toList());
    }

    private void createProduct(String type) {
        AbstractProductWithChildren selectedProduct = (AbstractProductWithChildren) user.getProduct();
        List<IProduct> assemblies = filterProduct(selectedProduct.getChildren(), p->p instanceof Assembly);

        int i = 1;
        int choice = 99;
        while(choice != 1) {
            System.out.println("[#] List of assemblies:");
            System.out.println("[1] Create Here");
            for (IProduct assembly : assemblies) {
                System.out.printf("[%d] %s", ++i, assembly);
            }

            if (choice != 1) {
                selectedProduct = (Assembly) assemblies.get(choice - 2);
                assemblies = filterProduct(selectedProduct.getChildren(), p -> p instanceof Assembly);
            }

            String username = keyboardReader.promptString("Enter username");
            String password = keyboardReader.promptString("Enter password");
            String productTitle = keyboardReader.promptString("Enter product title");

            Employee employee;
            if (type.equals("Part")) {
                employee = context.createEmployeeWithPart(selectedProduct, username, password, productTitle);
            } else {
                employee = context.createEmployeeWithAssembly(selectedProduct, username, password, productTitle);
            }
            System.out.printf("%s is assigned to %s.", employee.getProduct().getTitle(), employee.getUsername());
        }
    }

    private boolean createEmployeeWithPart() {
        createProduct("Part");
        return true;
    }

    private boolean createEmployeeWithAssembly() {
        createProduct("Assembly");
        return true;
    }

    private boolean seeProductTree() {
        return true;
    }

    private boolean seeEmployees() {
        return true;// TO DO
    }
}
