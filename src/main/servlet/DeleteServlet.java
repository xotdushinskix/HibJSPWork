//package servlet;

import dao.UserDao;
import factory.Factory;
import table.User;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by nikita on 12.05.16.
// */
//public class DeleteServlet extends ForwardServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Factory factory = Factory.getInstance();
//        UserDao userDao = factory.getUserDao();
//
//        HibernateUtil.getSessionFactory();
//
//        response.setContentType("text/html");
//
//        Long deleteId = Long.valueOf(request.getParameter("idDelete"));
//        try {
//                userDao.deleteUser(userDao.getUser(deleteId));
//                request.setAttribute("getAllUser", userDao.getAllUsers());
//                super.forward("/user.info.jsp", request, response);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//
//    }
//}
