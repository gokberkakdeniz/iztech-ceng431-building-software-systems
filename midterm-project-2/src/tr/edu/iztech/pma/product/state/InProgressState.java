package tr.edu.iztech.pma.product.state;

import tr.edu.iztech.pma.product.AbstractProductWithChildren;
import tr.edu.iztech.pma.product.IProduct;

public class InProgressState extends AbstractProductState {
    @Override
    public void proceed(IProduct context) {
        context.setState(new CompleteState());

        if (context.hasParent()) {
            AbstractProductWithChildren parent = (AbstractProductWithChildren) context.getParent();
            boolean isAllChildrenCompleted = parent.getChildren().stream().allMatch(IProduct::isCompleted);

            if (isAllChildrenCompleted) parent.proceed();
        }
    }
}
