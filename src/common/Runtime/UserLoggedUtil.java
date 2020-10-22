package common.Runtime;


import common.VO.User;

public class UserLoggedUtil {
    private static User user = null;

    public static User getSession() {
        return user;
    }

    public static void setSession(User loginUser) {
        if(user == null) {
            user = loginUser;
        }
    }
}
