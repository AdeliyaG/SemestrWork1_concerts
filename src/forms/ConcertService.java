package forms;

import DAO.ConcertDAO;
import models.Concerts;

import java.util.ArrayList;

public class ConcertService {
    ConcertDAO concertDAO = new ConcertDAO();

    public ArrayList<Concerts> getConcerts(){
        return concertDAO.getConcerts();
    }
}
