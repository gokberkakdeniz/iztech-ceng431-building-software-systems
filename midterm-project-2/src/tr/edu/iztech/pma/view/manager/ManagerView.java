package tr.edu.iztech.pma.view.manager;

import tr.edu.iztech.pma.data.IDataContext;
import tr.edu.iztech.pma.io.KeyboardReader;
import tr.edu.iztech.pma.people.*;
import tr.edu.iztech.pma.product.*;
import tr.edu.iztech.pma.utils.TreeTraverser;
import tr.edu.iztech.pma.view.Session;
import tr.edu.iztech.pma.view.View;

import java.util.List;

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

    private boolean createEmployeeWithPart() { // TO DO
        List<IProduct> children = ((AbstractProductWithChildren) user.getProduct()).getChildren();

        int choice = 99;
        while(choice != 0) {
            KeyboardReader.Options options = new KeyboardReader.Options("List of parts and assemblies", children.toArray());
            options.printOptions();
            choice = keyboardReader.promptInteger(String.format("Please enter a number between 0-%s to see its " +
                    "product, 0 to here", children.size()), options.getPredicate());
            if(choice != 0) {
                //iF PART İSE ONU SEÇİYORSUN, ASSEMBLY İSE DEVAM EDEBİLİYOR SADECE
                children = ((AbstractProductWithChildren) children.get(choice-1)).getChildren();
            } else {
//                selected = children.get(0);
            }
        }

        String username = keyboardReader.promptString("Enter username");
        String password = keyboardReader.promptString("Enter password");
        String productTitle = keyboardReader.promptString("Enter product title");

//        Part part = context.createEmployeeWithPart(username, password, productTitle); // TO DO
//        System.out.printf("%s is added.\n\n", part);
        return true;
    }

    private boolean createEmployeeWithAssembly() { // TO DO
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
