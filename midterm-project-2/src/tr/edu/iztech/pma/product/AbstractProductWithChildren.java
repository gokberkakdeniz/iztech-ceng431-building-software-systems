package tr.edu.iztech.pma.product;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class AbstractProductWithChildren extends AbstractProduct {
    @Expose()
    private final List<IProduct> children;

    public AbstractProductWithChildren(int id, String title) {
        super(id, title);
        children = new ArrayList<>();
    }

    public boolean add(IProduct child) {
        if (children.contains(child)) return false;

        child.setParent(this);

        return children.add(child);
    }

    public boolean remove(IProduct child) {
        return children.remove(child);
    }

    public List<IProduct> getChildren() {
        return new ArrayList<>(children);
    }
}