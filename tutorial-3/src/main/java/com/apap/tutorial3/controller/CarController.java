package com.apap.tutorial3.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


import com.apap.tutorial3.service.CarService;
import com.apap.tutorial3.model.CarModel;

@Controller
public class CarController {
	@Autowired
	private CarService mobilService;

	@RequestMapping("/car/add")
	public String add(@RequestParam(value = "id", required = true) String id,
					@RequestParam(value = "brand", required = true) String brand,
					@RequestParam(value = "type", required = true) String type,
					@RequestParam(value = "price", required = true) Long price,
					@RequestParam(value = "amount", required = true) Integer amount) {
		CarModel car = new CarModel(id,brand,type,price,amount);
		mobilService.addCar(car);
		return "add";
	}
	
	@RequestMapping("/car/view")
	public String viewParam(@RequestParam(value ="id", required = false) String id, Model model) {
		
		if(id == null) {
			return "error-not-found";
		}
		CarModel archive = mobilService.getCarDetail(id);
		if(archive == null) {
			return "error-not-found";
		}
		
		model.addAttribute("car", archive);
		return "view-car";
	}
	
	@RequestMapping("/car/view/{id}")
	public String viewPath(@PathVariable Optional<String> id, Model model) {
		if(id.isPresent()) {
			CarModel archive = mobilService.getCarDetail(id.get());	
			model.addAttribute("car", archive);
			return "view-car";

		}
		return "error-not-found";
		
	}

	
	@RequestMapping("/car/viewall")
	public String viewall(Model model) {
		List<CarModel> archive = mobilService.getCarList();

		model.addAttribute("listCar",archive);
		return"viewall-car";
	}
	
	@RequestMapping("/car/update/{id}/amount/{amountCount}")
	public String viewall(@PathVariable Optional<String> id,@PathVariable Optional<String> amountCount,Model model) {

		if(id.isPresent()) {
			CarModel archive = mobilService.getCarDetail(id.get());
			if(archive == null) {
				return "error-not-found";
			}
			archive.setAmount(Integer.parseInt(amountCount.get()));
			model.addAttribute("car",archive);
			return"update-car";

		}
		return "error-not-found";		
	}

	@RequestMapping("/car/delete/{id}")
	public String deleteCar(@PathVariable Optional<String> id,Model model) {
		if(id.isPresent()) {
			CarModel archive = mobilService.getCarDetail(id.get());
			if(archive == null) {
				return "error-not-found";
			}
			
			String deletedId = id.get();
			
			mobilService.deleteCar(id.get());
			
			model.addAttribute("id",deletedId);
			return"delete-car";
		}
		return "error-not-found";
	}



}
