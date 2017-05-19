package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Reservation;
import services.ReservationManagerService;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ReservationManagerService reservationService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int reservationId = Integer.parseInt(request.getParameter("reservationId"));
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Reservation res = reservationService.getReservation(reservationId);
		request.setAttribute("from", formater.format(res.getReservedFrom()));
	    request.setAttribute("to", formater.format(res.getReservedTo()));
	    request.setAttribute("id", res.getId());
	    request.setAttribute("tableNumber", res.getTableNumber());
	    request.setAttribute("clientName", res.getName());
		request.getRequestDispatcher("Edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int reservationId = Integer.parseInt(request.getParameter("reservationId"));
		String name = request.getRemoteUser();
		int tableNumber = Integer.parseInt(request.getParameter("tableNumber"));
		List<Date> dates = reservationService.GetDates(request.getParameter("from"), request.getParameter("to"));
		Date from = null;
		Date to = null;
		if(dates == null)
		{
			request.setAttribute("response", "Both dates are required!");
		}
		else
		{
			from = dates.get(0);
			to = dates.get(1);
		}
		 // TODO SAVE
		reservationService.reserveTable(name, tableNumber, from, to, reservationId);
		//
		
		request.getRequestDispatcher("ReservationServlet").forward(request, response);
	}

}
