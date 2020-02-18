package dev.knacion.servlet;

import dev.knacion.database.UserAccountDao;
import dev.knacion.model.UserAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("login_username");
        String password = request.getParameter("login_password");

        UserAccount user = UserAccountDao.getUser(username, password);

        if (user != null) {
            getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/error.jsp")
                    .forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
