package forms;

import DAO.UserDAO;
import HelperMethods.CookieHelper;
import models.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class UserService {

    UserDAO userDAO = new UserDAO();
    CookieHelper cookieHelper = new CookieHelper();

    public void signUp(HttpServletRequest req, HttpServletResponse resp) {
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String login = req.getParameter("login");
        LocalDate birthdate = LocalDate.parse(req.getParameter("birthdate"));
        String password = req.getParameter("password");
        String password_ver = req.getParameter("password_ver");
        if (req.getParameter("singUpButton") != null) {
            if (userDAO.loginIsContained(login)) {
                //todo if user with this username already exists
            } else {
                userDAO.saveUser(new User(first_name, last_name, login, birthdate, password));
                try {
                    resp.sendRedirect("/login");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            if (userDAO.checkUser(username, password)) {
                cookieHelper.addCookie(req, resp, username);
                resp.sendRedirect("/profile");
            } else {
                //todo if user is not found
            }
        } catch (IOException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
    }
}
