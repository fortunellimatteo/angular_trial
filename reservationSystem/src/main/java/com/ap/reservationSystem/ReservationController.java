package com.ap.reservationSystem;

import java.sql.Date;
import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ap.reservationSystem.dto.ReservationDTO;

@RestController
public class ReservationController {
	
	public final ReservationRepository reservationRepos;
	
	public ReservationController(ReservationRepository repository) {
		this.reservationRepos = repository;
	}

	@GetMapping("/reservations")
	public Iterable<Reservation> getReservations() {
		return reservationRepos.findAll();
	}
	
	@GetMapping("/reservation/{id}")
	public Reservation getReservationByIdReservation(@PathVariable Long id) {
		return reservationRepos.findById(id).orElseThrow();
	}
	
	@PostMapping("/reservation")
	public Reservation createReservation(@RequestBody Reservation newReservation) {
		return reservationRepos.save(newReservation);
	}
	
	@DeleteMapping("/reservation/{id}")
	public void deleteReservationById(@PathVariable Long id) {
		reservationRepos.deleteById(id);
	}
	
	/* reservations by name (plural because they can be with the same name) */
	@GetMapping("/reservations/{name}")
	public List<ReservationDTO> getReservationsByNameReservation(@PathVariable String name) {
		return reservationRepos.getReservationsByNameReservation(name);
	}

	/* delete by name and date */
	@DeleteMapping("/reservation/delete/{name}/{date}/{hour}")
	public void deleteReservationByName(@PathVariable String name, @PathVariable Date date, @PathVariable Long hour) {
		reservationRepos.deleteReservationByNameAndDate(name, date, hour);
	}
	
	/* reservations of a day */
	@GetMapping("/reservations/day/{date}")
	public List<ReservationDTO> getReservationsOfADay(@PathVariable Date date) {
		return reservationRepos.getReservationsOfADay(date);
	}
	
	/* reservations between 2 date */
	@GetMapping("/reservations/days/{dateFrom}/{dateTo}")
	public List<ReservationDTO> getReservationsOfADay(@PathVariable Date dateFrom, @PathVariable Date dateTo) {
		return reservationRepos.getReservationsBetweenDates(dateFrom, dateTo);
	}
	
	/* reservations of the current week */
	@GetMapping("reservations/current/week")
	public List<ReservationDTO> getReservationsOfCurrentWeek() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		
		java.util.Date mondayC = c.getTime();
		c.add(Calendar.DATE, 6);
		java.util.Date sundayC = c.getTime();

		Date monday = new Date(mondayC.getTime());
		Date sunday = new Date(sundayC.getTime());

		return reservationRepos.getReservationsBetweenDates(monday, sunday);
	}
	
	/* reservations of the current month */
	@GetMapping("reservations/current/month")
	public List<ReservationDTO> getReservationsOfCurrentMonth() {
		Integer cMax = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
		Integer cMin = Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH);

		int year = Year.now().getValue();
		java.util.Date dateMin = new GregorianCalendar(year, Calendar.MONTH, cMin).getTime();
		java.util.Date dateMax = new GregorianCalendar(year, Calendar.MONTH, cMax).getTime();

		Date firstDayOfMonth = new Date(dateMin.getTime());
		Date lastDayOfMonth = new Date(dateMax.getTime());

		return reservationRepos.getReservationsBetweenDates(firstDayOfMonth, lastDayOfMonth);
	}
	
}
