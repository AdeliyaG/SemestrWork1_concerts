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

    private UserDAO userDAO = new UserDAO();
    private CookieHelper cookieHelper = new CookieHelper();

    public void signUp(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
//        LocalDate birthdate = LocalDate.parse(req.getParameter("birthdate"));
        String password = req.getParameter("password");
        String password_ver = req.getParameter("password_ver");
        if (req.getParameter("signUpButton") != null) {
            if (!userDAO.loginIsContained(login)) {
                userDAO.saveUser(new User(login, first_name, last_name, password));
                try {
                    resp.sendRedirect("/login");
                } catch (IOException e) {
                    System.out.println("exception");
                    throw new IllegalArgumentException();
                }

            } else {
                System.out.println("ccg ");
                //todo if user with this username already exists
            }
        }
    }
    //}

    public void login(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            if (userDAO.checkUser(username, password)) {
                cookieHelper.addCookie(req, resp, username);
                resp.sendRedirect("/");
            } else {
                //todo if user is not found
            }
        } catch (IOException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
    }
}

