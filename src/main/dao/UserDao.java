package dao;

import table.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by nikita on 10.05.16.
 */
public interface UserDao {

    public void addUser(User user) throws SQLException;
    public List<User> getAllUsers() throws SQLException;

}
