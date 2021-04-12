package tr.edu.iztech.pma.product;

import com.google.gson.annotations.Expose;
import tr.edu.iztech.pma.product.state.CompleteState;
import tr.edu.iztech.pma.product.state.IProductState;
import tr.edu.iztech.pma.product.state.InProgressState;
import tr.edu.iztech.pma.product.state.NotStartedState;

public abstract class AbstractProduct implements IProduct {
    @Expose()
    private final int id;

    @Expose()
    private final String title;

    @Expose()
    private final String type; // class name for serialization

    @Expose()
    protected IProductState state;

    private IProduct parent;

    public AbstractProduct(int id, String title) {
        this.id = id;
        this.title = title;
        this.type = getClass().getSimpleName();
        this.state = new NotStartedState();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void proceed() {
        state.proceed(this);
    }

    @Override
    public void setState(IProductState state) {
        this.state = state;
    }

    @Override
    public IProduct getParent() {
        return parent;
    }

    @Override
    public void setParent(IProduct parent) {
        this.parent = parent;
    }

    @Override
    public boolean hasParent() {
        return parent != null;
    }

    @Override
    public boolean isCompleted() {
        return state instanceof CompleteState;
    }

    @Override
    public boolean isInProgress() {
        return state instanceof InProgressState;
    }

    @Override
    public boolean isNotStarted() {
        return state instanceof NotStartedState;
    }

    @Override
    public String toString() {
        return String.format("%s(%s, #%d, %s)", type, getTitle(), getId(), state);
    }
}
