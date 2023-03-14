package com.ap.reservationSystem;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ap.reservationSystem.dto.ReservationDTO;

import jakarta.transaction.Transactional;

public interface ReservationRepository extends CrudRepository<Reservation,Long>{

	  @Query("SELECT new com.ap.reservationSystem.dto.ReservationDTO(idReservation, nameReservation, dateReservation, "
	  		+ "hoursReservation, fieldReservation) FROM Reservation WHERE nameReservation = :name")
	  public List<ReservationDTO> getReservationsByNameReservation(String name);
	 
	  @Modifying
	  @Transactional
	  @Query("DELETE FROM Reservation WHERE nameReservation = :name AND dateReservation = :date AND hoursReservation = :hour")
	  public void deleteReservationByNameAndDate(String name, Date date, Long hour);
	  
	  @Query("SELECT new com.ap.reservationSystem.dto.ReservationDTO(idReservation, nameReservation, dateReservation, "
		  		+ "hoursReservation, fieldReservation) FROM Reservation WHERE dateReservation = :date")
	  public List<ReservationDTO> getReservationsOfADay(Date date);

	  @Query("SELECT new com.ap.reservationSystem.dto.ReservationDTO(idReservation, nameReservation, dateReservation, "
		  		+ "hoursReservation, fieldReservation) FROM Reservation WHERE dateReservation BETWEEN :dateFrom AND :dateTo")
	  public List<ReservationDTO> getReservationsBetweenDates(Date dateFrom, Date dateTo);
}
