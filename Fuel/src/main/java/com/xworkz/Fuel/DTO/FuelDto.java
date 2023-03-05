package com.xworkz.Fuel.DTO;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FuelDto {
	
	@Id
	private int id;
	@NotBlank(message="fuel has good quantity")
	private String name;
	@Size(min=3,max=20,message="Brandname cannot be less than 3 or more than 20 characters")
	private String brandName;
	@NotBlank(message="fuel should be selected")
	private String type;
	@NotNull(message="price should not be null")
	private double price;
	
	}
	
	
	

