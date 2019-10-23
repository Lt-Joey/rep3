package com.turing.service;

import java.util.List;

import com.turing.entity.Car;

public interface ICarService {
	
	Car findById(Integer id);
	
	List<Car> findAll();
	
	int insert(Car car);
	
	int update(Car car);
	
	int delete(Integer id);
}
