package com.apap.tutorial3.service;
import java.util.List;
import com.apap.tutorial3.model.CarModel;


/**
 * CarService
 * @author Awl
 *
 */
public interface CarService {
	void addCar(CarModel car);
	void deleteCar(String id);

	List<CarModel> getCarList();
	
	CarModel getCarDetail(String id);
}
