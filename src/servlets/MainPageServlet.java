package servlets;

import HelperMethods.CookieHelper;
import forms.ConcertService;
import forms.UserService;
import models.User;
import servlets.jade.JadeConf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/")
public class MainPageServlet extends HttpServlet {
    private ConcertService concertService = new ConcertService();
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> model = new HashMap<>();
        model.put("concerts", concertService.getConcerts());
        if (req.getSession().getAttribute("current_user") != null) {
            model.put("user", userService.getUserByUsername((String) req.getSession().getAttribute("current_user")));
        }
        JadeConf.render("index", model, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
