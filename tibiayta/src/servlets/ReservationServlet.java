package servlets;

import java.io.IOException;
import java.text.DateFormat;
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

import services.ReservationManagerService;

@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ReservationManagerService reservationService;

	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result;
		//String clientName = request.getParameter("clientName");;
		String tableNumberStr = request.getParameter("tableNumber");
		Integer tableNumber = Integer.valueOf(request.getParameter("tableNumber"));
		String name = request.getRemoteUser();
		int reservationId = -1;
		if(request.getParameter("reservationId") != null && request.getParameter("reservationId").length() > 0)
		{
			reservationId = Integer.parseInt(request.getParameter("reservationId"));
		}
		Date from = null;
		Date to = null;
		List<Date> dates = reservationService.GetDates(request.getParameter("from"), request.getParameter("to"));
		if(dates == null)
		{
			request.setAttribute("response", "Both dates are required!");
		//	request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else
		{
			 from = dates.get(0);
			 to = dates.get(1);
		}

		if (tableNumberStr == null || tableNumberStr.equals("")) {
			result = "Pleas select table-number!";
		} else if( reservationId > 0)
		{
			result = reservationService.reserveTable(name, tableNumber, from, to, reservationId);
		}
		else
		{
		
			result = reservationService.reserveTable(name, tableNumber, from, to,reservationId);
		}
		
		request.setAttribute("reservations", reservationService.getUserReservations(name));
		request.setAttribute("numbers", reservationService.getTableNumbers());
		request.setAttribute("resultOfReservation", result);

		request.getRequestDispatcher("UserDash.jsp").forward(request, response);

	}
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getRemoteUser();
		request.setAttribute("reservations", reservationService.getUserReservations(name));
		request.setAttribute("numbers", reservationService.getTableNumbers());


		request.getRequestDispatcher("UserDash.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
