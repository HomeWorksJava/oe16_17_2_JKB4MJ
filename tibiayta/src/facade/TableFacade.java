package facade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Reservation;
import entities.RestaurantTable;

@Dependent
public class TableFacade {
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	
	
	public void BookTable (int id)
	{
		RestaurantTable table = em.find(RestaurantTable.class, id);
		table.setBooked(true);
		 em.merge(table);
	}
	
	public List<Integer> GetAllTableNumbers() {
		List<Integer> nums = new ArrayList<>();
		try
		{
		 List<RestaurantTable> tables = em.createQuery("Select a From RestaurantTable a").getResultList();
		 for (RestaurantTable t :tables )
		 {
			 nums.add(t.getNumber());
		 }
		}
		catch(Exception ex)
		{
	      Exception x = ex;
		}
		
		    return nums;
	}
	
	
}
