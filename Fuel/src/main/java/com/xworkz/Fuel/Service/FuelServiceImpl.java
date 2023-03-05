package com.xworkz.Fuel.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.Fuel.DTO.FuelDto;
import com.xworkz.Fuel.Entity.FuelEntity;
import com.xworkz.Fuel.Repository.FuelRepository;

@Service
public class FuelServiceImpl implements FuelService {

	@Autowired
	private FuelRepository fuelRepository;

	@Override
	public Set<ConstraintViolation<FuelDto>> validateAndSave(FuelDto dto) {
		System.out.println("Running validateAndSave in FuelServiceImpl...");

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<FuelDto>> violations = validator.validate(dto);
		if (violations != null && !violations.isEmpty()) {
			System.err.println("violations in dto:" + dto);
			return violations;
		} else {
			System.out.println("validation is not therein dto can save");

			FuelEntity fuelEntity = new FuelEntity();
			fuelEntity.setName(dto.getName());
			fuelEntity.setBrandName(dto.getBrandName());
			fuelEntity.setType(dto.getType());
			fuelEntity.setPrice(dto.getPrice());

			boolean saved = fuelRepository.save(fuelEntity);
			System.out.println("Entity is saved:" + saved);
			return Collections.emptySet();
		}

	}

	@Override
	public FuelDto findById(int id) {
		System.out.println("findbyid is calling service....");
		if (id > 0) {
			FuelEntity entity = this.fuelRepository.find(id);
			if (entity != null) {
				System.out.println("Entity found in service for id" + id);
				FuelDto dto = new FuelDto();
				dto.setId(entity.getId());
				dto.setName(entity.getName());
				dto.setBrandName(entity.getBrandName());
				dto.setType(entity.getType());
				dto.setPrice(entity.getPrice());
				return dto;
			}
		}
		return FuelService.super.findById(id);

	}

	@Override
	public List<FuelDto> findByBrandName(String brandName) {
		System.out.println("Running findByBrandName in service" + brandName);
		if (brandName != null && !brandName.isEmpty()) {
			System.out.println("brandname is valid..calling repo");
	List<FuelEntity> entities = this.fuelRepository.findByBrandName(brandName);

			List<FuelDto> listofDTO = new ArrayList<FuelDto>();
			for (FuelEntity entity : entities) {
				FuelDto dto = new FuelDto();
				dto.setName(entity.getName());
				dto.setBrandName(entity.getBrandName());
				dto.setType(entity.getType());
				dto.setPrice(entity.getPrice());
				dto.setId(entity.getId());
				listofDTO.add(dto);
				return listofDTO;
			}
			System.out.println("size of dtos" + listofDTO.size());
			System.out.println("size of entities" + listofDTO.size());
		} else {
			System.out.println("BrandName is invalid...");
		}

		return FuelService.super.findByBrandName(brandName);

	}

	
	@Override
	public Set<ConstraintViolation<FuelDto>> validateAndUpdate(FuelDto dto) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<FuelDto>> violations = validator.validate(dto);
		if (violations != null && !violations.isEmpty()) {
			System.err.println("violations in dto" + dto);
			return violations;
		} else {
			System.out.println("violations are not there in dto");
			FuelEntity fuelEntity = new FuelEntity();
			fuelEntity.setName(dto.getName());
			fuelEntity.setBrandName(dto.getBrandName());
			fuelEntity.setType(dto.getType());
			fuelEntity.setPrice(dto.getPrice());
			fuelEntity.setId(dto.getId());

			boolean saved = fuelRepository.save(fuelEntity);
			System.out.println("Entity is saved:" + saved);
			return Collections.emptySet();

		}

	}
	@Override
	public FuelDto deleteById(int id) {
		System.out.println("Running delete by id in service:"+id);
		if(id>0) {
			FuelEntity entity=this.fuelRepository.deleteById(id);
		}
		return FuelService.super.deleteById(id);
	}
}