package tr.edu.iztech.pma.view;

import tr.edu.iztech.pma.io.KeyboardReader;
import tr.edu.iztech.pma.utils.TreeTraverser;

public abstract class View {
    protected KeyboardReader keyboardReader;
    static protected TreeTraverser traverser;

    public View() {}

    public void bindKeyboardReader(KeyboardReader keyboardReader) {
        this.keyboardReader = keyboardReader;
    }

    public abstract boolean show();

}
