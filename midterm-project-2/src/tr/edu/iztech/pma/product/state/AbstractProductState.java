package tr.edu.iztech.pma.product.state;

import com.google.gson.annotations.Expose;

public abstract class AbstractProductState implements IProductState{
    @Expose
    private final String type;

    public AbstractProductState() {
        this.type = this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return type;
    }
}