package tr.edu.iztech.pma.view;

import tr.edu.iztech.pma.io.KeyboardReader;

public abstract class View {
    protected KeyboardReader keyboardReader;

    public View() {}

    public void bindKeyboardReader(KeyboardReader keyboardReader) {
        this.keyboardReader = keyboardReader;
    }

    /**
     * Displays User Interface.
     */
    public abstract void show();

}
