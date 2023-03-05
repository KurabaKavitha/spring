package com.xworkz.Fuel.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.hibernate.annotations.OnDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.Fuel.DTO.FuelDto;
import com.xworkz.Fuel.Service.FuelService;

@Controller
@RequestMapping("/")
public class FuelController {
	@Autowired
	private FuelService fuelService;
	
	private List<String> name= Arrays.asList("petrol","desial","oil","kerosine");	
	private List<String>brandName=Arrays.asList("Indian","bharat","hpetro","valero");
	private List<String>type=Arrays.asList("lit","halflit","2lit","3lit");
	
	public FuelController() {
		System.out.println(" Created FuelController"+this.getClass().getSimpleName());
	}
	
	@GetMapping("/fuel")
	public String onFuel(Model model) {
		 model.addAttribute("Name",name);
		 model.addAttribute("BrandName", brandName);
		 model.addAttribute("type", type);
		return "Select";
		
	}
	@PostMapping("/fuel")
	public String onFuel(Model model, FuelDto dto) {
		System.out.println(" Running FuelController postmethod:"+dto);
		Set<ConstraintViolation<FuelDto>> violation=fuelService.validateAndSave(dto);
		if(violation.isEmpty()) {
			System.out.println("no violation in controller go to sucess page");
			model.addAttribute("dto", dto);
			return "SelectSuccess";
		}
		model.addAttribute("dto", dto);
		model.addAttribute("name", name);
		model.addAttribute("Brandname", brandName);
		model.addAttribute("type", type);
		model.addAttribute("error", violation);
		System.out.println(" violation in FuelController");
		return "Select";
		
	}
	@GetMapping("/Search")
	public String onSearch(@RequestParam int id,Model model) {
		System.out.println("Running on search for id"+id);
		FuelDto dto=this.fuelService.findById(id);
		if(dto !=null) {
			model.addAttribute("dto", dto);
			
		}else {
			model.addAttribute("messages","data not found");
		}
		return "Search";
		
	}
	@GetMapping("/SearchbyBrandname")
	public String onSearchByBrandName(@RequestParam String brandName,Model model) {
		System.out.println("Running onSearchByBrandName controller"+brandName);
		List<FuelDto>list=this.fuelService.findByBrandName(brandName);
		if(list!=null) {
			model.addAttribute("list", list);
		}else {
		model.addAttribute("message", "Not found");}
		return "SearchbyBrandname";
		
	
	}
	@GetMapping("/update")
	public String onupdate(@RequestParam int id,Model model) {
		System.out.println("Running onupdate..");
		FuelDto dto=this.fuelService.findById(id);
		model.addAttribute("dto", dto);
		model.addAttribute("name", name);
		model.addAttribute("Brandname", brandName);
		model.addAttribute("type", type);
		return "UpdateFuel";
	}
	@PostMapping("/update")
	public String onUpdate(FuelDto dto,Model model) {
		System.out.println("Running onUpdate...");
			Set<ConstraintViolation<FuelDto>> contraintViolations=
						this.fuelService.validateAndSave(dto);
		if(contraintViolations.size()>0) {
			model.addAttribute("errors", contraintViolations);
			
		}else {
			model.addAttribute("message", "fuel update success...");
		}
		return "UpdateFuel";
	}
	@GetMapping("/delete")
	public String OnDelete(@RequestParam int id,Model model) {
		System.out.println("Running  findbyname in controller:"+id);
		FuelDto dto=this.fuelService.deleteById(id);
		if(dto==null) {
			model.addAttribute("id", id);
			model.addAttribute("message","Delete Successfully");
		}else {
			model.addAttribute("error", "Name not found");
		}
		return "delete";
		
	}
	

}
