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
import java.util.List;

@WebServlet("/user/list") @Slf4j
public class UserList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User[] users = UserDao.findAllUsers();
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/user/list.jsp").forward(req, resp);
    }
}
