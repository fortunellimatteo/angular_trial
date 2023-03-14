package com.ap.reservationSystem;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Reservation {
	
	private @Id @GeneratedValue Long idReservation;
	private String nameReservation;
	private Date dateReservation;
	private Long hoursReservation;
	private Long fieldReservation;
	
	Reservation() {}
	
	public Reservation (Long idReservation, String nameReservation, Date dateReservation, Long hoursReservation, Long fieldReservation) {
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
