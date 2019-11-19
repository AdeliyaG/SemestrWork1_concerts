package forms;

import models.Concerts;
import DAO.ConcertDAO;

import java.util.ArrayList;

public class ConcertService {
    ConcertDAO concertDAO = new ConcertDAO();

    public ArrayList<Concerts> getConcerts(){
        return concertDAO.getConcerts();
    }

    public ArrayList<Concerts> getConcertsBySoonDate(String query){
        return concertDAO.getConcertsBySoonDate(query);
    }

    public ArrayList<Concerts> getConcertsByLateDate(){
        return concertDAO.getConcertsByLateDate();
    }
}
