package servlets;

import HelperMethods.CookieHelper;
import forms.UserService;
import servlets.jade.JadeConf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private CookieHelper cookieHelper = new CookieHelper();
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("current_user") != null || cookieHelper.checkCookie(req)) {
            resp.sendRedirect("/");
        } else {
            Map<String, Object> model = new HashMap<>();
            JadeConf.render("login", model, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.login(req, resp);
    }
}
