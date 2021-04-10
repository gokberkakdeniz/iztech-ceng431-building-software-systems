package tr.edu.iztech.pma.product;

public class Part extends AbstractProduct {
    public Part(int id, String title) {
        super(id, title);
    }

    @Override
    public String toString() {
        return this.getTitle() + ", id:" + this.getId();
    }
}
