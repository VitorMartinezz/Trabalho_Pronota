package common.Runtime;

import common.VO.User;

public class LogUtil {
    private static LogUtil logs;

    public static LogUtil getLogsInstance() {
        if(logs == null) {
            logs = new LogUtil();
        }

        return logs;
    }

    public boolean createLog(User user, String description) {
        System.out.println(user.getUsername() + " " + description);
        return true;
    }
}
