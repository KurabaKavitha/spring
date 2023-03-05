package com.xworkz.Fuel.Repository;

import java.util.Collections;
import java.util.List;
import com.xworkz.Fuel.Entity.FuelEntity;

public interface FuelRepository {
	boolean save(FuelEntity fuelEntity);
	boolean update(FuelEntity entity);
	
	default FuelEntity deleteById(int id) {
		return null;
		
	}
	default FuelEntity find(int id) {
		return null;
	}
	default List<FuelEntity>findByBrandName(String brandName){
		return Collections.emptyList();
	}
	
	
}
