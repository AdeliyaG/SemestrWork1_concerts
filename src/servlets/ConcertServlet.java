package servlets;

import forms.ConcertService;
import forms.UserService;
import models.Concerts;
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

@WebServlet("/concert")
public class ConcertServlet extends HttpServlet {

    private ConcertService concertService = new ConcertService();
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> model = new HashMap<>();

        User user = null;
        String id = req.getParameter("id");
        if (req.getSession().getAttribute("current_user") != null) {
            user = userService.getUserByUsername((String) req.getSession().getAttribute("current_user"));
            model.put("user", user);
        }
        if (id != null) {
            Concerts concerts = concertService.getConcertsByID(Integer.parseInt(id));
            model.put("concert", concerts);
            model.put("starred", concertService.isUserStarredConcert(user, concerts));
            model.put("bought", concertService.isUserBougthTicketForConcert(user, concerts));
            JadeConf.render("concert", model, resp);
        } else {
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
