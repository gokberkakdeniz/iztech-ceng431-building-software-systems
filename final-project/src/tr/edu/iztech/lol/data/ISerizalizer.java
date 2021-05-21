package tr.edu.iztech.lol.data;

import tr.edu.iztech.lol.model.IModel;

public interface ISerizalizer<T extends IModel> {
	String serizalize(T model);
}
