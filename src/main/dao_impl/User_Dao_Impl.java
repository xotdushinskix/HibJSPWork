package dao_impl;

import dao.UserDao;
import org.hibernate.Session;
import table.User;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by nikita on 10.05.16.
 */
public class User_Dao_Impl implements UserDao {
    public void addUser(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session == null) && (session.isOpen())) {
                session.close();
            }
        }
    }




    public List<User> getAllUsers() throws SQLException {
        List<User> users = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            users = session.createCriteria(User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session == null) && (session.isOpen())) {
                session.close();

            }
        }
        return users;
    }




    public void deleteUser(User user) throws SQLException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session == null) && (session.isOpen())) {
                session.close();
            }
        }
    }




    public User getUser(Long userId) throws SQLException {
        User result = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.get(User.class, userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session == null) && (session.isOpen())) {
                session.close();
            }
        }
        return result;
    }



    public void editUser(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session == null) && (session.isOpen())) {
                session.close();
            }
        }
    }
}
