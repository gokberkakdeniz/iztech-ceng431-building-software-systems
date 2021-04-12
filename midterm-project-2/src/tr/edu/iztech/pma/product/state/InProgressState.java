package tr.edu.iztech.pma.product.state;

import tr.edu.iztech.pma.product.AbstractProductWithChildren;
import tr.edu.iztech.pma.product.IProduct;

import java.util.List;

public class InProgressState extends AbstractProductState {
    @Override
    public void proceed(IProduct context) {
        checkStatus(context);
        context.setState(new CompleteState());

        // updates parent's state if all the siblings are in Completed state.
        if (context.hasParent()) {
            AbstractProductWithChildren parent = (AbstractProductWithChildren) context.getParent();
            boolean isAllChildrenCompleted = parent.getChildren().stream().allMatch(IProduct::isCompleted);

            if (isAllChildrenCompleted) parent.proceed();
        }
    }

    /**
     * checks invalid status of changing the state.
     */
    private void checkStatus(IProduct context) {
        if(context instanceof AbstractProductWithChildren) {
            List<IProduct> children = ((AbstractProductWithChildren) context).getChildren();
            if(!children.isEmpty()
                    && children.stream().anyMatch(c->!c.isCompleted())) {
                throw new ProductStateException("State can not be updated, because some of your children " +
                        "is not completed.");
            }
        }
    }
}
