package com.ap.reservationSystem.dto;

import java.sql.Date;

public class ReservationDTO {
		
	private Long idReservation;
	private String nameReservation;
	private Date dateReservation;
	private Long hoursReservation;
	private Long fieldReservation;
	
	ReservationDTO() {}
	
	public ReservationDTO(Long idReservation, String nameReservation, Date dateReservation,Long hoursReservation, Long fieldReservation) {
		this.idReservation = idReservation;
		this.nameReservation = nameReservation;
		this.dateReservation = dateReservation;
		this.hoursReservation = hoursReservation;
		this.fieldReservation = fieldReservation;
	}
	
	public Long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}
	public String getNameReservation() {
		return nameReservation;
	}
	public void setNameReservation(String nameReservation) {
		this.nameReservation = nameReservation;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	public Long getHoursReservation() {
		return hoursReservation;
	}
	public void setHoursReservation(Long hoursReservation) {
		this.hoursReservation = hoursReservation;
	}
	public Long getFieldReservation() {
		return fieldReservation;
	}
	public void setFieldReservation(Long fieldReservation) {
		this.fieldReservation = fieldReservation;
	}

}
