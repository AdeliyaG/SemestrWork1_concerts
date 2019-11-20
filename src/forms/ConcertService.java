package forms;

import models.Concerts;
import DAO.ConcertDAO;
import models.User;

import java.util.ArrayList;

public class ConcertService {
    ConcertDAO concertDAO = new ConcertDAO();

    public ArrayList<Concerts> getConcerts() {
        return concertDAO.getConcerts();
    }

    public ArrayList<Concerts> getConcertsBySoonDate(String query) {
        return concertDAO.getConcertsBySoonDate(query);
    }

    public Concerts getConcertsByID(int id) {
        return concertDAO.getConcertsByID(id);
    }

    public boolean isUserStarredConcert(User user, Concerts concerts) {
        return user != null && concertDAO.isUserStarredConcert(user, concerts);
    }

    public boolean isUserBougthTicketForConcert(User user, Concerts concerts) {
        return user != null && concertDAO.isUserBougthTicketForConcert(user, concerts);
    }

}
