package tr.edu.iztech.teamstech.view;

import tr.edu.iztech.teamstech.entity.EntityDirector;
import tr.edu.iztech.teamstech.io.KeyboardReader;

public abstract class View {
    protected KeyboardReader keyboardReader;
    protected EntityDirector director;

    public View(EntityDirector director) {
        this.director = director;
    }

    public void bindKeyboardReader(KeyboardReader keyboardReader) {
        this.keyboardReader = keyboardReader;
    }

    public abstract boolean show();

}
