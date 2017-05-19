package services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;

import entities.*;
import facade.ReservationFacade;
import facade.TableFacade;


@Singleton
@LocalBean

public class ReservationManagerService {
	
	@Inject
	private ReservationFacade rf;
	@Inject
	private TableFacade tf;

    
    @PostConstruct
    private void init(){
    
    }
    

    
    

	public List<Reservation> getReservations() {
	  return rf.getAllReservation();
	}
	
	public List<Reservation> getUserReservations(String name){
		return rf.getUsersReservation(name);
	}
	
	public Reservation getReservation (int Id){
		return rf.GetById(Id);
	}

	
	
	public String reserveTable(String clientName, int tableNumber,Date from, Date to,int  reservationId ){
		
		Optional<Reservation> res = rf.getAllReservation().stream().filter(x-> x.getTableNumber() == tableNumber 
				&& ( from.before(x.getReservedTo()) &&  to.after(x.getReservedFrom()) )).findFirst();
		if(!res.isPresent()|| ( res.isPresent() && res.get() == null ) )
		{
			Reservation newReservation =(new Reservation(clientName, tableNumber,from,to));
			if( reservationId>0)
			{
				newReservation.setId(reservationId);
				rf.EditReservation(newReservation);
			}
			else
			{			
			rf.reserveTable(newReservation);
			tf.BookTable(tableNumber);
			}
			return "Your reservation was successful";
		}
		else
			return "That table is already booked. Pleas try another one";
	}
	
	public List<Integer> getTableNumbers(){
		 
		return tf.GetAllTableNumbers();
	}
	
	public List<Date> GetDates(String strFrom, String strTo)
	{
		List<Date> result = new ArrayList<>();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date from = null;
		Date to = null;
		try {
			
			if (strFrom.length()> 0&& strTo.length()> 0) {
				result.add(format.parse(strFrom));
				result.add(format.parse(strTo));
			}
			else
			{
				result = null;
			}
		} catch (ParseException e) {
			result = null;
		}
		return result;
	}
	
	
    public void DeleteReservation(int id)
    {
    	rf.deleteReservation(id);
    }
    

}
