package com.xworkz.Fuel.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Fuel_table")
@Data
@NamedQuery(name="findByBrandName",query="select ent from FuelEntity ent where ent.brandName=:comp")
public class FuelEntity {
	@Id
	@Column(name="f_id")
	private int id;
	@Column(name="f_name")
	private String name;
	@Column(name="f_brandName")
	private String brandName;
	@Column(name="f_type")
	private String type;
	@Column(name="f_price")
	private double price;
	
	

	
		
	}



