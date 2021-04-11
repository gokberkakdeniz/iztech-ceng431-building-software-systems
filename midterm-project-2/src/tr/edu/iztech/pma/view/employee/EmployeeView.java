package tr.edu.iztech.pma.view.employee;

import tr.edu.iztech.pma.data.IDataContext;
import tr.edu.iztech.pma.io.KeyboardReader;
import tr.edu.iztech.pma.people.Employee;
import tr.edu.iztech.pma.product.IProduct;
import tr.edu.iztech.pma.view.Session;
import tr.edu.iztech.pma.view.View;

public class EmployeeView extends View {
    private IDataContext context;
    private Employee user;

    public EmployeeView() {
        this.context = Session.getContext();
        this.user = (Employee) Session.getUser();
    }

    @Override
    public void show() {
        while (true) {
            KeyboardReader.Options options = new KeyboardReader.Options("What would you like to do?",
            new String[] {
                "See state of your assembly / part", "Update state of your assembly / part"
            });

            options.printOptions();

            int choice = keyboardReader.promptInteger("Please enter a number between 0-2", options.getPredicate());
            try {
                switch (choice) {
                    case 0:
                        return;
                    case 1:
                        seeStateOfProduct();
                        break;
                    case 2:
                        updateStateOfProduct();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            context.save();
        }
    }

    private void seeStateOfProduct() {
        System.out.println(user.getProduct());
    }

    private void updateStateOfProduct() {
        IProduct product = user.getProduct();
        System.out.println("Current state: " + product);
        product.proceed();
        System.out.println("Updated state: " + product);
    }

}
