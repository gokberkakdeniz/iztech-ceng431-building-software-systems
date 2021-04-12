package tr.edu.iztech.pma.people;

import tr.edu.iztech.pma.product.IProduct;

/**
 * Manager and Employee are Personnel since they have Product/Assembly/Part.
 */
public interface IPersonnel {
    /**
     * Gets product of person
     *
     * @return product
     */
    IProduct getProduct();
}
