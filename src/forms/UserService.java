package forms;

import DAO.UserDAO;
import HelperMethods.AvatarAdd;
import HelperMethods.CookieHelper;
import HelperMethods.HashPassword;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserService {

    private UserDAO userDAO = new UserDAO();
    private CookieHelper cookieHelper = new CookieHelper();
    private HashPassword hashPassword = new HashPassword();

    public void signUp(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
//        LocalDate birthdate = LocalDate.parse(req.getParameter("birthdate"));
        String password = req.getParameter("password");
        String password_ver = req.getParameter("password_ver");
        if (req.getParameter("signUpButton") != null) {
            if (!userDAO.loginIsContained(login)) {
                password = hashPassword.getHashPassword(password);
                userDAO.saveUser(new User(login, first_name, last_name, password));
                try {
                    resp.sendRedirect("/login");
                } catch (IOException e) {
                    System.out.println("exception");
                    throw new IllegalArgumentException();
                }
            } else {
                //todo if user with this username already exists
            }
        }
    }


    public void login(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            if (userDAO.checkUser(username, hashPassword.getHashPassword(password))) {
                cookieHelper.addCookie(req, resp, username);
                resp.sendRedirect("/");
            } else {
                //todo if user is not found
                resp.sendRedirect("/login");
            }
        } catch (IOException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
    }

    public User getUserByUsername(String username){
        return userDAO.getUserByUsername(username);
    }

    public void editProfile(HttpServletRequest req, HttpServletResponse resp) {
        AvatarAdd m = new AvatarAdd();
        String img;
        try {
            img = m.addMedia(req, "avatar");
        } catch (IOException | ServletException e) {
            System.out.println("Exception during avatar adding");
            throw new IllegalArgumentException(e);
        }
        try {
            if (req.getParameter("saveChanges") != null) {
                if (req.getParameter("password").equals("")) {
                    userDAO.updateDataWithoutPassword(req.getParameter("first_name"), req.getParameter("last_name"), img, (String) req.getSession().getAttribute("current_user"));
                    resp.sendRedirect("/lk");
                } else {
                    userDAO.updateData(req.getParameter("first_name"), req.getParameter("last_name"), img, hashPassword.getHashPassword(req.getParameter("password")), (String) req.getSession().getAttribute("current_user"));
                    resp.sendRedirect("/lk");
                }
            }
        } catch (IOException e) {
            System.out.println("Exception during edit profile");
            throw new IllegalArgumentException();
        }
    }
}

