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
import java.util.List;

/**
 * Created by nikita on 10.05.16.
 */
@WebServlet("/user.info")
public class MainServlet extends ForwardServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HibernateUtil.getSessionFactory();

        response.setContentType("text/html");


        String fName = request.getParameter("firstname");
        String lName = request.getParameter("lastname");
        String age = request.getParameter("age");


        Factory factory = Factory.getInstance();
        UserDao userDao = factory.getUserDao();


        User user = new User();

        user.setFirstName(fName);
        user.setLastName(lName);
        user.setAge(Integer.parseInt(age));

        try {
            userDao.addUser(user);
            if (userDao == null) {
                super.forward("/error.jsp", request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            List<User> users = userDao.getAllUsers();
            for(User user1 : users){
                System.out.println("User id = " + user1.getUserId() + " user first name " + user1.getFirstName()
                        + " user last name " + user1.getLastName() + " user age " + user1.getAge());
            }
            super.forward("/user.info.jsp", request, response);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
