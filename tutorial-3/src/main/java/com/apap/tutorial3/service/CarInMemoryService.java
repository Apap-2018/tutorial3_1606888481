package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import com.apap.tutorial3.model.CarModel;

import org.springframework.stereotype.Service;

@Service
public class CarInMemoryService implements CarService {
	private List<CarModel> archiveCar;
	
	public CarInMemoryService() {
		archiveCar = new ArrayList<>();
	}
	
	@Override
	public void addCar(CarModel car) {
		archiveCar.add(car);
	}
	
	@Override
	public List<CarModel> getCarList(){
		return archiveCar;
	}
	
	@Override
	public void deleteCar(String id) {
		archiveCar.remove(getCarDetail(id));
	}
	
	@Override
	public CarModel getCarDetail(String id) {
		for(CarModel temp : archiveCar) {
			System.out.println("pencarian mobil");
			System.out.println(temp.getId() + " = " + id);
			
			if (temp.getId().equals(id)) {
				System.out.println("MOBIL DITEMUKAN");
				return temp;
			}
		}
		System.out.println("mobil tidak ditemukan");
		return null;
	}

//	public CarModel getCarDetail(String id) {
//		CarModel tempCar = new CarModel();
//		for(CarModel temp : archiveCar) {
//			if (temp.getId() == id) {
//				tempCar = temp;
//			}
//		}
//		if(tempCar.getBrand() != null) {
//			return tempCar;
//		}
//		else{
//			return null;
//		}
//	}

}
