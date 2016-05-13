package servlet;

import dao.UserDao;
import factory.Factory;
import table.User;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by nikita on 10.05.16.
 */

@SuppressWarnings("ALL")
public class MainServlet extends ForwardServlet {


    private static String EDIT_JSP = "/insert.jsp";
    private static String SHOW_ALL = "/showAll.jsp";
    private Factory factory = Factory.getInstance();
    private UserDao userDao = factory.getUserDao();
    private User user = new User();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HibernateUtil.getSessionFactory();
        String forwardString = null;
        String action = request.getParameter("action");
        if(action.equals("delete")) {
            long userId = Long.parseLong(request.getParameter("userId"));
            try {
                userDao.deleteUser(userDao.getUser(userId));
                request.setAttribute("users", userDao.getAllUsers());
                forwardString = SHOW_ALL;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equals("edit")) {
            long userId = Long.parseLong(request.getParameter("userId"));
            try {
                user = userDao.getUser(userId);
                request.setAttribute("user", user);
                forwardString = EDIT_JSP;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equals("showAll")) {
            try {
                request.setAttribute("users", userDao.getAllUsers());
                forwardString = SHOW_ALL;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            forwardString = EDIT_JSP;
        }
        super.forward(forwardString, request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HibernateUtil.getSessionFactory();
        String fName = request.getParameter("firstname");
        String lName = request.getParameter("lastname");
        String age = request.getParameter("age");

        user.setFirstName(fName);
        user.setLastName(lName);
        user.setAge(Integer.parseInt(age));

        String userId = request.getParameter("userid");
        if (userId.isEmpty()) {
            try {
                userDao.addUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            user.setUserId(Long.parseLong(userId));
            try {
                userDao.editUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            request.setAttribute("users", userDao.getAllUsers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.forward(SHOW_ALL, request, response);
    }
}
