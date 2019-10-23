package com.turing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turing.entity.Car;
import com.turing.service.ICarService;

@Controller
public class CarController {
	//依赖业务层 ，注入业务层
	@Autowired
	private ICarService carService;
	
	//测试方法
	@RequestMapping("test")
	@ResponseBody //如果返回的结果是String，那么久直接返回String
	
	public String test() {
		return "controller success";
	}
	
	//通过id查询car，显示json数据
	@RequestMapping("/car/{id}")
	@ResponseBody //如果返回的结果是String，那么久直接返回String
	public Car getCar(@PathVariable("id")Integer id) {
		return carService.findById(id);
	}
}
