package tr.edu.iztech.lol.data;

import tr.edu.iztech.lol.model.IModel;

public interface IDeserializer<T extends IModel> {
	T deserizalize(String s);
}
