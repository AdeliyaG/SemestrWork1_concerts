package servlets;

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

@WebServlet("/lk/edit")
public class ProfileSettingsServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object> model = new HashMap<>();
        if (req.getSession().getAttribute("current_user") != null) {
            model.put("user", userService.getUserByUsername((String) req.getSession().getAttribute("current_user")));
        } else {
            resp.sendRedirect("/");
        }
        JadeConf.render("profile_edit", model, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.editProfile(req, resp);
    }
}
