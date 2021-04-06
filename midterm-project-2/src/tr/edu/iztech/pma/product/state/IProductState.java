package tr.edu.iztech.pma.product.state;

import tr.edu.iztech.pma.product.IProduct;

public interface IProductState {
     void proceed(IProduct context);
}
