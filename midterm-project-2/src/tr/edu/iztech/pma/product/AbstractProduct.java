package tr.edu.iztech.pma.product;

public abstract class AbstractProduct implements IProduct {
    private final int id;
    private final String title;
    private final String type;

    public AbstractProduct(int id, String title) {
        this.id = id;
        this.title = title;
        this.type = getClass().getSimpleName();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
