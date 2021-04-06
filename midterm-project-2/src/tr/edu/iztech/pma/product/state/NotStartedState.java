package tr.edu.iztech.pma.product.state;

import tr.edu.iztech.pma.product.IProduct;

public class NotStartedState implements IProductState {
    @Override
    public void proceed(IProduct context) {
        context.setState(new InProgressState());

        if (context.hasParent() && context.getParent().isNotStarted()) context.getParent().proceed();
    }
}
