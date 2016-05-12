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

public class MainServlet extends ForwardServlet {


    private static String EDIT_JSP = "/insert.jsp";
    private static String SHOW_ALL = "/showAll.jsp";
    private Factory factory = Factory.getInstance();
    private UserDao userDao = factory.getUserDao();
    private User user = new User();


//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user = new User();
//        Factory factory = Factory.getInstance();
//        UserDao userDao = factory.getUserDao();
//
//        HibernateUtil.getSessionFactory();
//
//        response.setContentType("text/html");
//
//
////        if(request.getParameter("enter") !=null){         //add
//            String fName = request.getParameter("firstname");
//            String lName = request.getParameter("lastname");
//            String age = request.getParameter("age");
//
//            user.setFirstName(fName);
//            user.setLastName(lName);
//            user.setAge(Integer.parseInt(age));
//
//            try {
//                userDao.addUser(user);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
////
////
////        } else if (request.getParameter("editUser") !=null) {        //edit
////            Long editId = Long.valueOf(request.getParameter("idEdit"));
////            try {
////                userDao.editUser(userDao.getUser(editId));
////            } catch (SQLException e1) {
////                e1.printStackTrace();
////            }
////        }
//
//
//
//        //show all
//        try {
//            request.setAttribute("getAllUser", userDao.getAllUsers());
//            super.forward("useinfojsp, request, response);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//  }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardString = null;
        String action = request.getParameter("action");
        if(action.equals("delete")) {
            long userId = Long.parseLong(request.getParameter("userid"));
            try {
                userDao.deleteUser(userId);
                request.setAttribute("users", userDao.getAllUsers());
                forwardString = SHOW_ALL;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equals("edit")) {
            long userId = Long.parseLong(request.getParameter("userid"));
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
        String fName = request.getParameter("firstname");
        String lName = request.getParameter("lastname");
        String age = request.getParameter("age");

        user.setFirstName(fName);
        user.setLastName(lName);
        user.setAge(Integer.parseInt(age));

        String userId = request.getParameter("userIdInsertEdit");
        if (userId == null) {
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
        super.forward(SHOW_ALL, request, response);
    }
}
