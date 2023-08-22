package com.adobe.prj.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="vehicles")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Vehicle {
	
	@Column(name="reg_no")
	private String registrationNo;
	
	@Column(name="fuel_type")
	private String fuelType; // petrol or diesel
	
	@Column(name="per_day_cost")
	private double costPerDay;
	
	@Column(name="vehicle_type")
	private String vehicleType; // SEDAN , SUV, HATCHBACK
	
}
