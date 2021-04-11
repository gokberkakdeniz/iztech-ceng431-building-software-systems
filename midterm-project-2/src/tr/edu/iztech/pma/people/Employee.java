package tr.edu.iztech.pma.people;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import tr.edu.iztech.pma.data.json.ProductAsIdSerializer;
import tr.edu.iztech.pma.product.IProduct;

public class Employee extends AbstractPerson implements IPersonnel {
    @Expose()
    @SerializedName("productId")
    @JsonAdapter(ProductAsIdSerializer.class)
    private final IProduct product;

    public Employee(String username, String password, IProduct product) {
        super(username, password);
        this.product = product;
    }

    public IProduct getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return super.getUsername() + "," + product.getId();
    }
}
