package system;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private static ThreadLocal<UserSession> currentSession = new ThreadLocal<>();

    public static void setSession(UserSession session) {
        currentSession.set(session);
    }

    public static UserSession getSession() {
        return currentSession.get();
    }

    public static void clearSession() {
        currentSession.remove();
    }
}
