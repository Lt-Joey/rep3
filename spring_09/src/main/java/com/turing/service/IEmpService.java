package com.turing.service;

import java.util.List;

import com.turing.entity.Emp;

public interface IEmpService {
	List<Emp> findAll();
	
	//查询用户名是否存在
	boolean findByName(String name);
	
	//添加
	int addEmp(Emp emp);
}
