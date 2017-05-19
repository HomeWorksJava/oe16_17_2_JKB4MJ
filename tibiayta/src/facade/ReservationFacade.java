package facade;

import java.sql.Date;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Reservation;

@Dependent
public class ReservationFacade {
	
	@PersistenceContext
	private EntityManager em;
	
	public void reserveTable(Reservation res) {
		em.persist(res);
	}
	
	public Reservation EditReservation(Reservation res) {
		Reservation existingRes = em.find(Reservation.class, res.getId());
		existingRes.setReservedFrom(res.getReservedFrom());
		existingRes.setReservedTo(res.getReservedTo());
		em.merge(existingRes);
		return null;
	}
	
	public Reservation GetById (int id)
	{
		return em.find(Reservation.class,id);
	}
	
	public void deleteReservation(int id) {
		Reservation res = em.find(Reservation.class, id);
		em.remove(res);
	}
	
	public List<Reservation> getAllReservation() 
	{
	    List<Reservation> depts = em.createQuery("Select a From Reservation a").getResultList();
	    return depts;
	}
	
	public List<Reservation> getUsersReservation(String name)
	{
		List<Reservation> depts = em.createQuery("Select a From Reservation a where a.name = :name ").setParameter("name", name).getResultList();
	    return depts;
	}
}
