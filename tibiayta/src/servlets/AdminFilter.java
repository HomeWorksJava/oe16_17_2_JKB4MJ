package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import services.ReservationManagerService;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/AdminDash.jsp" })
public class AdminFilter implements Filter {

	@EJB
	private ReservationManagerService reservationService;
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		request.setAttribute("reservations", reservationService.getReservations());
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
