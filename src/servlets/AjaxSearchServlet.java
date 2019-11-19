package servlets;

import forms.ConcertService;
import models.Concerts;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/doSearch")
public class AjaxSearchServlet extends HttpServlet {
    private ConcertService concertService = new ConcertService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query");
        String searchParam = req.getParameter("search_param");
        ArrayList<Concerts> concerts = new ArrayList<>();
        switch (searchParam){
            case "soon":
                concerts = concertService.getConcertsBySoonDate(query);
                break;
        }

        JSONArray ja = new JSONArray();
        for (Concerts concert: concerts) {
            ja.put(new JSONObject(concert));
        }
        JSONObject jo = new JSONObject();
        jo.put("concerts", ja);

        resp.setContentType("text/json");
        resp.getWriter().write(jo.toString());
    }

}
