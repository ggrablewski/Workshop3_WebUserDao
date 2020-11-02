package ggrablewski.webuser.servlet;

import ggrablewski.webuser.dao.User;
import ggrablewski.webuser.dao.UserDao;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;

@WebServlet("/user/add") @Slf4j
public class UserAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/user/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User (userName, email, password);
        UserDao.createUser(user);

        resp.sendRedirect("/users/list.jsp");

    }
}
