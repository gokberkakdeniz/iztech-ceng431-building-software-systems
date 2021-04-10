package tr.edu.iztech.pma.product;

public class Assembly extends AbstractProductWithChildren {
    public Assembly(int id, String title) {
        super(id, title);
    }

    @Override
    public String toString() {
        return this.getTitle() + ", id:" + this.getId();
    }
}
