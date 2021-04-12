package tr.edu.iztech.pma.product;

import tr.edu.iztech.pma.product.state.IProductState;

public interface IProduct {
    /**
     * Gets id of the product
     *
     * @return id
     */
    int getId();

    /**
     * Gets title of the product
     *
     * @return title
     */
    String getTitle();

    /**
     * Changes state to next state
     */
    void proceed();

    /**
     * Changes state explicitly
     *
     * @param state next state
     */
    void setState(IProductState state);

    /**
     * Checks if the product is completed or not.
     *
     * @return if the product is completed returns true, otherwise false
     */
    boolean isCompleted();

    /**
     * Checks if the product is in progress or not.
     *
     * @return if the product is in progress returns true, otherwise false
     */
    boolean isInProgress();

    /**
     * Checks if the product is not started or not.
     *
     * @return if the product is not started returns true, otherwise false
     */
    boolean isNotStarted();

    /**
     * Gets parent of the product
     *
     * @return parent
     */
    IProduct getParent();

    /**
     * Changes parent explicitly
     *
     * @param parent parent
     */
    void setParent(IProduct parent);

    /**
     * Checks if the product has a parent or not
     *
     * @return if the product has a parent returns true, otherwise false
     */
    boolean hasParent();
}