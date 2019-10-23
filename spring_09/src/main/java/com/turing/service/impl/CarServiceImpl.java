package com.turing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.entity.Car;
import com.turing.mapper.CarMapper;
import com.turing.service.ICarService;

@Service
public class CarServiceImpl implements ICarService{
	
	//ÒÀÀµmapper²ã ×¢Èë½øÀ´
	@Autowired
	private CarMapper carMapper;
	
	@Override
	public Car findById(Integer id) {
		
		return carMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Car> findAll() {
		
		return carMapper.selectByExample(null);
	}

	@Override
	public int insert(Car car) {
		return carMapper.insertSelective(car);
	}

	@Override
	public int update(Car car) {
		
		return carMapper.updateByPrimaryKey(car);
	}

	@Override
	public int delete(Integer id) {
		
		return carMapper.deleteByPrimaryKey(id);
	}

}
