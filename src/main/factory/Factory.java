package factory;

import dao.UserDao;
import dao_impl.User_Dao_Impl;

/**
 * Created by nikita on 10.05.16.
 */
public class Factory {

    private static UserDao userDao;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }


    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new User_Dao_Impl();
        }
        return userDao;
    }

}
