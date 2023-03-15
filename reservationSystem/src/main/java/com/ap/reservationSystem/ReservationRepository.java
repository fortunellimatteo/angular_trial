package com.ap.reservationSystem;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ap.reservationSystem.dto.ReservationDTO;

import jakarta.transaction.Transactional;

public interface ReservationRepository extends CrudRepository<Reservation,Long>{

	  @Query("SELECT new com.ap.reservationSystem.dto.ReservationDTO(idReservation, nameReservation, dateReservation, "
	  		+ "hoursReservation, fieldReservation) FROM Reservation WHERE nameReservation = :name")
	  public List<ReservationDTO> getReservationsByNameReservation(@Param("name") String name);
	 
	  @Modifying
	  @Transactional
	  @Query("DELETE FROM Reservation WHERE nameReservation = :name AND dateReservation = :date AND hoursReservation = :hour")
	  public void deleteReservationByNameAndDate(@Param("name") String name, @Param("date") Date date, @Param("hour") Long hour);
	  
	  @Query("SELECT new com.ap.reservationSystem.dto.ReservationDTO(idReservation, nameReservation, dateReservation, "
		  		+ "hoursReservation, fieldReservation) FROM Reservation WHERE dateReservation = :date")
	  public List<ReservationDTO> getReservationsOfADay(@Param("date") Date date);

	  @Query("SELECT new com.ap.reservationSystem.dto.ReservationDTO(idReservation, nameReservation, dateReservation, "
		  		+ "hoursReservation, fieldReservation) FROM Reservation WHERE dateReservation BETWEEN :dateFrom AND :dateTo")
	  public List<ReservationDTO> getReservationsBetweenDates(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);
}
