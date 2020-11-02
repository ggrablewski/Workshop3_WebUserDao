package ggrablewski.webuser.servlet;

import ggrablewski.webuser.dao.User;
import ggrablewski.webuser.dao.UserDao;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/edit") @Slf4j
public class UserEdit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User currUser = UserDao.readUser(id);

        req.setAttribute("currUser", currUser);

        getServletContext().getRequestDispatcher("/users/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User (userName, email, password);
        UserDao.updateUser(id, user);

        resp.sendRedirect("/users/list.jsp");

    }
}
