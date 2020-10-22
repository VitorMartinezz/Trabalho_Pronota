package business;

import DAO.UserMySQLDAO;
import common.VO.User;
import org.mindrot.jbcrypt.BCrypt;


public class UserBusiness {
    public boolean createUser(User newUser) {
        String pw = newUser.getPassword();
        String hash = BCrypt.hashpw(pw, BCrypt.gensalt());
        newUser.setPassword(hash);

        return UserMySQLDAO.insert(newUser);
    }

    public User login(String email, String password) {
        User user = UserMySQLDAO.selectByEmail(email);
        if(user == null) {
            return null;
        }
        if(BCrypt.checkpw(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }
}
