package tr.edu.iztech.pma.view.manager;

import tr.edu.iztech.pma.data.IDataContext;
import tr.edu.iztech.pma.io.KeyboardReader;
import tr.edu.iztech.pma.people.Manager;
import tr.edu.iztech.pma.utils.TreeTraverser;
import tr.edu.iztech.pma.view.Session;
import tr.edu.iztech.pma.view.View;

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
                        createPartWithEmployee();
                        break;
                    case 2:
                        createAssemblyWithEmployee();
                        break;
                    case 3:
//                        seeProductTree();
                        break;
                    case 4:
//                        seeEmployees();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean createPartWithEmployee() { // TO DO
//        AbstractProductWithChildren product = (AbstractProductWithChildren) user.getProduct();
//        List<IProduct> children = product.getChildren(); BURDA KALDIN AMK KELİ

        String username = keyboardReader.promptString("Enter username");
        String password = keyboardReader.promptString("Enter password");
        String productTitle = keyboardReader.promptString("Enter product title");

//        Part part = context.createEmployeeWithPart(username, password, productTitle); // TO DO
//        System.out.printf("%s is added.\n\n", part);
        return true;
    }

    private boolean createAssemblyWithEmployee() { // TO DO
        String username = keyboardReader.promptString("Enter username");
        String password = keyboardReader.promptString("Enter password");
        String productTitle = keyboardReader.promptString("Enter product title");

//        Assembly assembly = context.createAssemblyWithEmployee(username, password, productTitle); // TO DO
//        System.out.printf("%s is added.\n\n", assembly);
        return true;
    }

//    private boolean seeProductTree() {
//        user.getProduct()
////        treeTraverser.traverse(context.getProductOf(manager));
//        return true;
//    }
//
//    private boolean seeEmployees() {
//        return true;// TO DO
//    }
}
