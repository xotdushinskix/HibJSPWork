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
    public void deleteUser(User user) throws SQLException;
    public User getUser(Long userId) throws SQLException;
    public void editUser(User user) throws SQLException;

}
