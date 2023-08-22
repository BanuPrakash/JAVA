package com.adobe.prj.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="rentals")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="vehicle_fk")
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name="customer_fk")
	private Customer customer;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "rental_start_date")
	private Date rentalStartDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "rental_return_date")
	private Date rentalReturnDate;
	
	private double rentalAmount; // computed
}
