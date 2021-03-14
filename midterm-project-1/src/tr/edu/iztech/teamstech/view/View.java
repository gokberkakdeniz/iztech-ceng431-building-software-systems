package tr.edu.iztech.teamstech.view;

import tr.edu.iztech.teamstech.io.KeyboardReader;

public abstract class View {
    protected KeyboardReader keyboardReader;

    public void bindKeyboardReader(KeyboardReader keyboardReader) {
        this.keyboardReader = keyboardReader;
    }

    public abstract boolean show();

}
