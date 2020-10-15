package business;

import common.Runtime.LogUtil;
import common.VO.User;

public class UserBusiness {
    public void createUser(User newUser) {
        //TODO - criar usario

        Runnable createLogRunnable = () -> {
            LogUtil log = LogUtil.getLogsInstance();

            log.createLog(newUser, "Foi criado");
        };

        new Thread(createLogRunnable).start();
    }
}
