package tr.edu.iztech.pma.product;

import tr.edu.iztech.pma.product.state.IProductState;

public interface IProduct {
    int getId();
    String getTitle();

    void setState(IProductState state);
    void proceed();

    boolean isCompleted();
    boolean isInProgress();
    boolean isNotStarted();

    IProduct getParent();
    void setParent(IProduct parent);
    boolean hasParent();

    void printState();
}