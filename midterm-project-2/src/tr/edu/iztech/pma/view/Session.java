package tr.edu.iztech.pma.view;

import tr.edu.iztech.pma.data.IDataContext;
import tr.edu.iztech.pma.people.IPerson;

public class Session {
    private static IPerson user;
    private static IDataContext context;

    public static IPerson getUser() {
        return user;
    }

    public static void setUser(IPerson user) {
        Session.user = user;
    }

    public static IDataContext getContext() {
        return context;
    }

    public static void setContext(IDataContext context) {
        Session.context = context;
    }
}
