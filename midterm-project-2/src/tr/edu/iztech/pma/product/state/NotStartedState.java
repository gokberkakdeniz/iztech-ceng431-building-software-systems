package tr.edu.iztech.pma.product.state;

import tr.edu.iztech.pma.product.AbstractProductWithChildren;
import tr.edu.iztech.pma.product.IProduct;

import java.util.List;

public class NotStartedState extends AbstractProductState {
    @Override
    public void proceed(IProduct context) {
        checkStatus(context);
        context.setState(new InProgressState());

        // updates parent's state if it is not started.
        if (context.hasParent() && context.getParent().isNotStarted()) context.getParent().proceed();
    }

    /**
     * checks invalid status of changing the state.
     */
    private void checkStatus(IProduct context) {
        if(context instanceof AbstractProductWithChildren) {
            List<IProduct> children = ((AbstractProductWithChildren) context).getChildren();
            if(!children.isEmpty()
                    && children.stream().noneMatch(c->c.isCompleted() || c.isInProgress())) {
                throw new ProductStateException("State can not be updated, because none of your children " +
                        "is neither completed nor in progress.");
            }
        }
    }
}
