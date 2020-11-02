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

@WebServlet("/user/show") @Slf4j
public class UserShow extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = UserDao.readUser(id);

        req.setAttribute("user", user);

        getServletContext().getRequestDispatcher("/users/show.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/users/list.jsp");
    }
}
