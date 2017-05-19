package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ReservationManagerService;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private ReservationManagerService reservationService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reservationId = Integer.parseInt(request.getParameter("reservationId"));
		reservationService.DeleteReservation(reservationId);
		request.getRequestDispatcher("ReservationServlet").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int reservationId = Integer.parseInt(request.getParameter("reservationId"));
		reservationService.DeleteReservation(reservationId);
		request.getRequestDispatcher("ReservationServlet").forward(request, response);
	}

}
